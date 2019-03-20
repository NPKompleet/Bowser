package com.npkompleet.phenomenon.bowser.forms;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.npkompleet.phenomenon.bowser.LoginActivity;
import com.npkompleet.phenomenon.bowser.R;
import com.npkompleet.phenomenon.bowser.bluetooth.DeviceList;
import com.npkompleet.phenomenon.bowser.bluetooth.PrinterCommands;
import com.npkompleet.phenomenon.bowser.bluetooth.Utils;
import com.npkompleet.phenomenon.bowser.mvp.models.ADIQuery;
import com.npkompleet.phenomenon.bowser.mvp.models.PrintADI;
import com.npkompleet.phenomenon.bowser.retrofit.MyApiEndpointInterface;
import com.npkompleet.phenomenon.bowser.retrofit.RetrofitUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.npkompleet.phenomenon.bowser.LoginActivity.FOOTER;
import static com.npkompleet.phenomenon.bowser.LoginActivity.HEADER;
import static com.npkompleet.phenomenon.bowser.LoginActivity.LOGO;
import static com.npkompleet.phenomenon.bowser.LoginActivity.NAME;

public class ListADI extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, ListADIAdapter.FormClickHandler{
    @BindView(R.id.rv_adi_list)
    RecyclerView mADIRecyclerView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.swipeLayoutADI)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.text_adi_list)
    TextView textView;

    ListADIAdapter adapter;

    byte FONT_TYPE;
    public static BluetoothSocket btsocket;
    public static OutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adi);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mADIRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new ListADIAdapter(this, new ArrayList<PrintADI>(), this);
        mADIRecyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent i= new Intent(ListADI.this, FormADIActivity.class);
                startActivity(i);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*btsocket= null;
        outputStream=null;*/
    }


    @Override
    protected void onStart() {
        super.onStart();
        onRefresh();
    }



    @Override
    public void onRefresh() {
        if (!networkActive()){
            Snackbar.make(fab, "No network available. Check your network", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            textView.setText("No network available. Check your network");
            textView.setVisibility(View.VISIBLE);
            return;
        }

        swipeRefreshLayout.setRefreshing(true);

        MyApiEndpointInterface myApi= RetrofitUtils.getService();

        /*Calendar c= Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -1);
        DateFormat dateFormat= new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        String[] dt= dateFormat.format(c.getTime()).split(" ");*/

        ADIQuery query= new ADIQuery();
        //query.setMainTable("fait_form_adi");
        //query.setWhereValues(query.new ADIWhereValues(dt[0], "Deleted"));
        //query.setOrdersBy(query.new ADIOrdersBy("DESC"));
        //query.setJoinArrayParameters(query.new JoinArrayParameters());
        query.setWhereValues(LoginActivity.user.getGroupsSystemCode());

        /*Gson gson = new Gson();
        String uaString = gson.toJson(query);
        Toast.makeText(this, uaString, Toast.LENGTH_SHORT).show();*/


        Call<List<PrintADI>> call = myApi.getADIForms(query);

        call.enqueue(new Callback<List<PrintADI>>(){

            @Override
            public void onResponse(Call<List<PrintADI>> call, Response<List<PrintADI>> response) {
                swipeRefreshLayout.setRefreshing(false);
                //int statusCode = response.code();
                if(response.body().toString().equals("0")){
                    textView.setText("There are no ADI forms submitted in the last 24 hours");
                    textView.setVisibility(View.VISIBLE);
                }else {
                    List<PrintADI> returnedForms = response.body();
                    adapter.swapData(returnedForms);
                    textView.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onFailure(Call<List<PrintADI>> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                //Toast.makeText(ListADI.this, "Something went wrong. Try again", Toast.LENGTH_SHORT).show();
                textView.setText("There are no ADI forms submitted in the last 24 hours");
                textView.setVisibility(View.VISIBLE);
                t.printStackTrace();

            }
        });



    }

    @Override
    public void onClickForm(PrintADI adi) {
        if(btsocket == null){
            Intent BTIntent = new Intent(getApplicationContext(), DeviceList.class);
            this.startActivityForResult(BTIntent, DeviceList.REQUEST_CONNECT_BT);
        }
        else{
            OutputStream opstream = null;
            try {
                opstream = btsocket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            outputStream = opstream;

            //print command
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputStream = btsocket.getOutputStream();
                byte[] printformat = new byte[]{0x1B,0x21,0x03};
                outputStream.write(printformat);


                printNewLine();
                printNewLine();
                printPhoto(LOGO);
                printCustom(NAME,2,1);
                printNewLine();
                printCustom(HEADER,1,1);
                printCustom(new String(new char[32]).replace("\0", "."),0,1);
                printNewLine();

                printText("ADI No.: "+"ADI/"+/*new Date(adi.getFaitFormAdiDate()).getYear()+*/adi.getFaitFormAdiDate().split("-")[0]+"/"+adi.getFaitFormAdiNo());
                printText("DATE: "+adi.getFaitFormAdiDate());
                printText("COMPANY BRANCH: "+adi.getFaitLocationsName());
                printText("SALES REP: "+adi.getFaitUsersFirstname()+ " "+ adi.getFaitUsersLastname());
                printText("LOCATION: "+adi.getFaitFormAdiLocation());
                printText("AIRLINE: "+adi.getFaitAssetsCustomerName());
                printText("AIRCRAFT TYPE: "+adi.getFaitFormAdiAircraftType());
                printText("AIRCRAFT NO.: "+adi.getFaitFormAdiAircraftNo());
                printText("PRODUCT: "+adi.getFaitFormAdiProductType());
                printText("PACKAGE: "+adi.getFaitFormAdiPackageType());
                printText("PARK TIME: "+adi.getFaitFormAdiParkTime());
                printText("FLIGHT FROM: "+adi.getFaitFormAdiFlightFrom());
                printText("FLIGHT TO: "+adi.getFaitFormAdiFlightTo());
                printText("METER BEFORE: "+adi.getFaitFormAdiMeterStart()+" LTRS");
                printText("TIME START: "+adi.getFaitFormAdiTimeStart());
                printText("METER AFTER: "+adi.getFaitFormAdiMeterEnd()+ " LTRS");
                printText("TIME END: "+adi.getFaitFormAdiTimeEnd());
                printText("VOLUME: "+adi.getFaitFormAdiVolumeSold()+" LTRS");
                printText("AIRLINE REP: "+adi.getFaitFormAdiReceivingCustomerName());

                printNewLine();


                printCustom(new String(new char[32]).replace("\0", "."),0,1);
                printCustom(FOOTER,1,1);

                printNewLine();
                printNewLine();
                printNewLine();




                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    //checks for network
    public boolean networkActive() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    //print custom
    private void printCustom(String msg, int size, int align) {
        //Print config "mode"
        byte[] cc = new byte[]{0x1B,0x21,0x03};  // 0- normal size text
        //byte[] cc1 = new byte[]{0x1B,0x21,0x00};  // 0- normal size text
        byte[] bb = new byte[]{0x1B,0x21,0x08};  // 1- only bold text
        byte[] bb2 = new byte[]{0x1B,0x21,0x20}; // 2- bold with medium text
        byte[] bb3 = new byte[]{0x1B,0x21,0x10}; // 3- bold with large text
        try {
            switch (size){
                case 0:
                    outputStream.write(cc);
                    break;
                case 1:
                    outputStream.write(bb);
                    break;
                case 2:
                    outputStream.write(bb2);
                    break;
                case 3:
                    outputStream.write(bb3);
                    break;
            }

            switch (align){
                case 0:
                    //left align
                    outputStream.write(PrinterCommands.ESC_ALIGN_LEFT);
                    break;
                case 1:
                    //center align
                    outputStream.write(PrinterCommands.ESC_ALIGN_CENTER);
                    break;
                case 2:
                    //right align
                    outputStream.write(PrinterCommands.ESC_ALIGN_RIGHT);
                    break;
            }
            outputStream.write(msg.getBytes());
            outputStream.write(PrinterCommands.LF);
            //outputStream.write(cc);
            //printNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //print photo
    public void printPhoto(Bitmap bmp) {
        try {
            //Bitmap bmp = BitmapFactory.decodeResource(getResources(), img);
            if(bmp!=null){
                byte[] command = Utils.decodeBitmap(bmp);
                outputStream.write(PrinterCommands.ESC_ALIGN_CENTER);
                printText(command);
            }else{
                Log.e("Print Photo error", "the file isn't exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("PrintTools", "the file isn't exists");
        }
    }

    //print unicode
    public void printUnicode(){
        try {
            outputStream.write(PrinterCommands.ESC_ALIGN_CENTER);
            printText(Utils.UNICODE_TEXT);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //print new line
    private void printNewLine() {
        try {
            outputStream.write(PrinterCommands.FEED_LINE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void resetPrint() {
        try{
            outputStream.write(PrinterCommands.ESC_FONT_COLOR_DEFAULT);
            outputStream.write(PrinterCommands.FS_FONT_ALIGN);
            outputStream.write(PrinterCommands.ESC_ALIGN_LEFT);
            outputStream.write(PrinterCommands.ESC_CANCEL_BOLD);
            outputStream.write(PrinterCommands.LF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //print text
    private void printText(String msg) {
        try {
            // Print normal text
            outputStream.write(msg.getBytes());
            outputStream.write(PrinterCommands.CRLF);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //print byte[]
    private void printText(byte[] msg) {
        try {
            // Print normal text
            outputStream.write(msg);
            printNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String leftRightAlign(String str1, String str2) {
        String ans = str1 +str2;
        if(ans.length() <31){
            int n = (31 - str1.length() + str2.length());
            ans = str1 + new String(new char[n]).replace("\0", " ") + str2;
        }
        return ans;
    }


    /*private String[] getDateTime() {
        final Calendar c = Calendar.getInstance();
        String dateTime [] = new String[2];
        dateTime[0] = c.get(Calendar.DAY_OF_MONTH) +"/"+ c.get(Calendar.MONTH) +"/"+ c.get(Calendar.YEAR);
        dateTime[1] = c.get(Calendar.HOUR_OF_DAY) +":"+ c.get(Calendar.MINUTE);
        return dateTime;
    }*/

    @Override
    protected void onStop() {
        super.onStop();
        /*try {
            if(btsocket!= null){
                outputStream.close();
                btsocket.close();
                btsocket = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*resetConnection();*/
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            btsocket = DeviceList.getSocket();
            if(btsocket != null){
                //printText(message.getText().toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void resetConnection() {

        if (outputStream != null) {
            try {outputStream.close();} catch (Exception e) {}
            outputStream = null;
        }

        if (btsocket != null) {
            try {btsocket.close();} catch (Exception e) {}
            btsocket = null;
        }

        DeviceList.resetConnection();


    }




}

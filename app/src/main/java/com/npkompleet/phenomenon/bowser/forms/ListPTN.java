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
import com.npkompleet.phenomenon.bowser.mvp.models.PrintPTN;
import com.npkompleet.phenomenon.bowser.retrofit.MyApiEndpointInterface;
import com.npkompleet.phenomenon.bowser.retrofit.RetrofitUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
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
import static com.npkompleet.phenomenon.bowser.forms.ListADI.btsocket;
import static com.npkompleet.phenomenon.bowser.forms.ListADI.outputStream;

public class ListPTN extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, ListPTNAdapter.FormClickHandler{
    @BindView(R.id.rv_ptn_list)
    RecyclerView mPTNRecyclerView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.text_ptn_list)
    TextView textView;

    ListPTNAdapter adapter;

    byte FONT_TYPE;
    /*private static BluetoothSocket btsocket;
    private static OutputStream outputStream*/;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ptn);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPTNRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new ListPTNAdapter(this, new ArrayList<PrintPTN>(), this);
        mPTNRecyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent i= new Intent(ListPTN.this, FormPTNActivity.class);
                startActivity(i);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

        ADIQuery query= new ADIQuery();
        //query.setMainTable("fait_form_adi");
        //query.setWhereValues(query.new ADIWhereValues(dt[0], "Deleted"));
        //query.setOrdersBy(query.new ADIOrdersBy("DESC"));
        //query.setJoinArrayParameters(query.new JoinArrayParameters());
        query.setMethod("ptnList");
        query.setWhereValues(LoginActivity.user.getGroupsSystemCode());

        /*Gson gson = new Gson();
        String uaString = gson.toJson(query);
        Toast.makeText(this, uaString, Toast.LENGTH_SHORT).show();*/


        Call<List<PrintPTN>> call = myApi.getPTNForms(query);

        call.enqueue(new Callback<List<PrintPTN>>(){

            @Override
            public void onResponse(Call<List<PrintPTN>> call, Response<List<PrintPTN>> response) {
                swipeRefreshLayout.setRefreshing(false);
                //int statusCode = response.code();
                if(response.body().toString().equals("0")){
                    textView.setText("There are no PTN forms submitted in the last 24 hours");
                    textView.setVisibility(View.VISIBLE);
                }else {
                    List<PrintPTN> returnedForms = response.body();
                    adapter.swapData(returnedForms);
                    textView.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onFailure(Call<List<PrintPTN>> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                //Toast.makeText(ListPTN.this, "Something went wrong. Try again", Toast.LENGTH_SHORT).show();
                textView.setText("There are no PTN forms submitted in the last 24 hours");
                textView.setVisibility(View.VISIBLE);
                t.printStackTrace();

            }
        });



    }

    @Override
    public void onClickPrint(PrintPTN ptn) {
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


//                printCustom("Fair Group BD",2,1);
//                printCustom("Pepperoni Foods Ltd.",0,1);
//                printPhoto(LOGO);
//                printCustom("H-123, R-123, Dhanmondi, Dhaka-1212",0,1);
//                printCustom("Hot Line: +88000 000000",0,1);
//                printCustom(" Vat Reg : 0000000000,Mushak : 11",0,1);
//                String dateTime[] = getDateTime();
//                printText(leftRightAlign(dateTime[0], dateTime[1]));
//                printText(leftRightAlign("Qty: Name" , "Price "));
//                printCustom(new String(new char[32]).replace("\0", "."),0,1);
//                printText(leftRightAlign("Total" , "2,0000/="));
//                printNewLine();
//                printCustom("Thank you for coming & we look",0,1);
//                printCustom("forward to serve you again",0,1);
//                printNewLine();
//                printNewLine();
                printNewLine();
                printNewLine();
                printPhoto(LOGO);
                printCustom(NAME,2,1);
                printCustom(HEADER,1,1);
                printCustom(new String(new char[32]).replace("\0", "."),0,1);
                printNewLine();

                printText("PTN No.: "+"PTN/"+ptn.getFaitFormPtnDeliveryDate().split("-")[0]+"/"+ ptn.getFaitFormPtnNo());
                
                printText("DATE: "+ ptn.getFaitFormPtnDeliveryDate());
                
                printText("DELIVERY RANCH: "+ ptn.getFaitLocationsName());
                
                printText("COMPANY REP: "+ ptn.getFaitFormPtnLoaderName());
                
                printText("REC TANK: "+ ptn.getFaitAssetsStorageName());
                
                printText("WAYBILL NO.: "+ ptn.getFaitFormPtnWaybillNo());
                
                printText("PTN QUANTITY: "+ ptn.getFaitFormPtnQuantity()+" LTRS");
                printText("LOADING DATE: "+ ptn.getFaitFormPtnLoadingDate());
                printText("LOADING STATION: "+ ptn.getFaitFormPtnLoadingStation());
                
                printText("LOADER NAME: "+ ptn.getFaitFormPtnLoaderName());
                
                printText("TRANSPORTER: "+ ptn.getFaitFormPtnTransporter());
                
                printText("TRUCK NUMBER: "+ ptn.getFaitFormPtnTruckNo());
                
                printText("DRIVER NAME: "+ ptn.getFaitFormPtnDriverName());
                printText("PRODUCT: "+ ptn.getFaitFormPtnProductType());
                printText("METER BEFORE: "+ ptn.getFaitFormPtnMeterStart()+" LTRS");
                
                printText("METER AFTER: "+ ptn.getFaitFormPtnMeterEnd()+" LTRS");
                
                printText("VOLUME: "+ ptn.getFaitFormPtnQuantityReceivedByMeter()+" LTRS");
                printText("LOSS: "+ ptn.getFaitFormPtnClaimableLoss()+" LTRS");
                printText("Q/C B/N: "+ ptn.getFaitFormPtnQualityBatchNo());
                printText("Q/C DATE: "+ ptn.getFaitFormPtnQualityDate());
                printText("COLOR: "+ ptn.getFaitFormPtnQualityColour());
                printText("SG: "+ ptn.getFaitFormPtnQualitySpecificGravity());
                printText("TEST FOR WATER: "+ ptn.getFaitFormPtnQualityTestForWater());
                printText("PRODUCT L/C: "+ ptn.getFaitFormPtnQualityProductLastCarried());
                printText("TEMPERATURE: "+ ptn.getFaitFormPtnQualityTemperature());

                

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

    @Override
    public void onClickQuality(PrintPTN form) {
        //
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


    private String[] getDateTime() {
        final Calendar c = Calendar.getInstance();
        String dateTime [] = new String[2];
        dateTime[0] = c.get(Calendar.DAY_OF_MONTH) +"/"+ c.get(Calendar.MONTH) +"/"+ c.get(Calendar.YEAR);
        dateTime[1] = c.get(Calendar.HOUR_OF_DAY) +":"+ c.get(Calendar.MINUTE);
        return dateTime;
    }

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



}
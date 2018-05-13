package com.npkompleet.phenomenon.bowser.forms;

import android.app.TimePickerDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.npkompleet.phenomenon.bowser.LoginActivity;
import com.npkompleet.phenomenon.bowser.MenuActivity;
import com.npkompleet.phenomenon.bowser.R;
import com.npkompleet.phenomenon.bowser.customview.SignatureView;
import com.npkompleet.phenomenon.bowser.mvp.models.Asset;
import com.npkompleet.phenomenon.bowser.mvp.models.AssetQuery;
import com.npkompleet.phenomenon.bowser.mvp.models.Customer;
import com.npkompleet.phenomenon.bowser.mvp.models.FormADI;
import com.npkompleet.phenomenon.bowser.mvp.models.InsertUpdateQuery;
import com.npkompleet.phenomenon.bowser.mvp.models.Location;
import com.npkompleet.phenomenon.bowser.mvp.models.Query;
import com.npkompleet.phenomenon.bowser.retrofit.MyApiEndpointInterface;
import com.npkompleet.phenomenon.bowser.retrofit.RetrofitUtils;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormADIActivity extends AppCompatActivity {
    @BindView(R.id.adi_date)
    EditText date;

    @BindView(R.id.adi_parkTime)
    EditText parkTime;

    @BindView(R.id.adi_ADINo)
    EditText aDINo;

    @BindView(R.id.adi_bowserFrom)
    EditText bowserFrom;

    @BindView(R.id.adi_salesLocation)
    EditText salesLocation;

    /*@BindView(R.id.adi_salesLocation_others)
    EditText salesLocationOthers;*/

    @BindView(R.id.adi_customer)
    EditText customer;

    @BindView(R.id.adi_aircraftType)
    EditText aircaftType;

    @BindView(R.id.adi_aircraftNo)
    EditText airCraftNo;

    @BindView(R.id.adi_flightFrom)
    EditText flightFrom;

    @BindView(R.id.adi_flightTo)
    EditText flightTo;

    @BindView(R.id.adi_productType)
    EditText productType;

    @BindView(R.id.adi_packageType)
    EditText packageType;

    @BindView(R.id.adi_specificGravity)
    EditText specificGravity;

    @BindView(R.id.adi_temperature)
    EditText temperature;

    @BindView(R.id.adi_bowserMeterStart)
    EditText bowserMeterStart;

    @BindView(R.id.adi_bowserMeterEnd)
    EditText bowserMeterEnd;

    @BindView(R.id.adi_timeStart)
    EditText timeStart;

    @BindView(R.id.adi_timeEnd)
    EditText timeEnd;

    @BindView(R.id.adi_aircraftMassStart)
    EditText aircraftMassStart;

    @BindView(R.id.adi_aircraftMassEnd)
    EditText aircraftMassEnd;

    @BindView(R.id.adi_comment)
    EditText comment;

    @BindView(R.id.adi_customerName)
    EditText customerName;

    @BindView(R.id.adi_signature)
    SignaturePad signature;

    Calendar mcurrentTime;
    TimePickerDialog mTimePicker;
    int hour;
    int minute;


    MyApiEndpointInterface myApi= RetrofitUtils.getService();
    static List<Customer> customers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_adi);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] dt= dateFormat.format(new Date()).split(" ");
        date.setText(dt[0]);
        parkTime.setText(dt[1]);
        timeStart.setText(dt[1]);


    }

    @OnClick({R.id.adi_bowserFrom,  R.id.adi_customer, R.id.adi_packageType, R.id.adi_productType,
    R.id.adi_parkTime, R.id.adi_timeStart, R.id.adi_timeEnd})
    public void viewClicked(View view) {

        switch (view.getId()) {
            case R.id.adi_packageType:
                PopupMenu packagePopUp = new PopupMenu(this, packageType);
                packagePopUp.getMenuInflater().inflate(R.menu.package_type_menu, packagePopUp.getMenu());
                packagePopUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        packageType.setText(item.getTitle());
                        return true;
                    }
                });
                packagePopUp.show();
                break;

            case R.id.adi_productType:
                PopupMenu productPopUp = new PopupMenu(this, productType);
                productPopUp.getMenuInflater().inflate(R.menu.product_type_menu, productPopUp.getMenu());
                productPopUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        productType.setText(item.getTitle());
                        return true;
                    }
                });
                productPopUp.show();
                break;

            case R.id.adi_bowserFrom:
                final PopupMenu bowserPopUp= new PopupMenu(this, bowserFrom);

                if(MenuActivity.assets != null){
                    for (Asset asset : MenuActivity.assets){
                        if(asset.getFaitAssetsStorageType().equals("Bowser"))
                            bowserPopUp.getMenu().add(asset.getFaitAssetsStorageName()+" , "+ asset.getFaitAssetsStorageSystemCode());
                    }
                }else {

                    AssetQuery assetQuery = new AssetQuery();
                    assetQuery.setWhereValues(assetQuery.new WhereValues(LoginActivity.user.getLocationsSystemCode(), "Activated"));

                    Call<List<Asset>> call = myApi.getAssets(assetQuery);
                    call.enqueue(new Callback<List<Asset>>() {

                        @Override
                        public void onResponse(Call<List<Asset>> call, Response<List<Asset>> response) {
                            try {
                                MenuActivity.assets = response.body();
                                for (Asset asset : MenuActivity.assets) {
                                    if (asset.getFaitAssetsStorageType().equals("Bowser"))
                                        bowserPopUp.getMenu().add(asset.getFaitAssetsStorageName() + " , " + asset.getFaitAssetsStorageSystemCode());
                                }

                                bowserPopUp.getMenu().removeItem(0);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Asset>> call, Throwable t) {
                            Toast.makeText(FormADIActivity.this, "Something went wrong. Try again", Toast.LENGTH_SHORT).show();
                        }
                    });


                    bowserPopUp.getMenu().add("Loading bowsers....");
                }

                bowserPopUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        bowserFrom.setText(item.getTitle());
                        return true;
                    }
                });

                bowserPopUp.show();
                break;

            /*case R.id.adi_salesLocation:
                final PopupMenu locationPopUp= new PopupMenu(this, salesLocation);

                Query locationQuery= new Query();
                locationQuery.setMainTable("fait_locations");

                Call<List<Location>> locationCall = myApi.getLocations(locationQuery);
                locationCall.enqueue(new Callback<List<Location>>(){

                    @Override
                    public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                        for (Location location : response.body()){
                            locationPopUp.getMenu().add(location.getFaitLocationsName()+" , "+ location.getFaitLocationsSystemCode());
                        }
                        locationPopUp.getMenu().removeItem(0);
                    }

                    @Override
                    public void onFailure(Call<List<Location>> call, Throwable t) {
                        Toast.makeText(FormADIActivity.this, "Something went wrong. Try again", Toast.LENGTH_SHORT).show();
                    }
                });

                locationPopUp.getMenu().add("Loading locations....");


                locationPopUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        salesLocation.setText(item.getTitle());
                        return true;
                    }
                });

                locationPopUp.show();
                break;*/

            case  R.id.adi_customer:
                final PopupMenu customerPopUp= new PopupMenu(this, customer);

                if (customers != null){
                    for (Customer retCustomer : customers){
                        customerPopUp.getMenu().add(retCustomer.getFaitAssetsCustomerName()+" , "+ retCustomer.getFaitAssetsCustomerSystemCode());

                    }
                }else {
                    Query customerQuery = new Query();
                    customerQuery.setMainTable("fait_assets_customer");

                    Call<List<Customer>> customerCall = myApi.getCustomers(customerQuery);
                    customerCall.enqueue(new Callback<List<Customer>>() {

                        @Override
                        public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                            try {
                                customers = response.body();
                                for (Customer retCustomer : customers) {
                                    customerPopUp.getMenu().add(retCustomer.getFaitAssetsCustomerName() + " , " + retCustomer.getFaitAssetsCustomerSystemCode());

                                }
                                customerPopUp.getMenu().removeItem(0);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Customer>> call, Throwable t) {
                            Toast.makeText(FormADIActivity.this, "Something went wrong. Try again", Toast.LENGTH_SHORT).show();
                        }
                    });


                    customerPopUp.getMenu().add("Loading customers....");
                }

                customerPopUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        customer.setText(item.getTitle());
                        return true;
                    }
                });

                customerPopUp.show();
                break;

            case R.id.adi_parkTime:
                mcurrentTime = Calendar.getInstance();
                hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                minute = mcurrentTime.get(Calendar.MINUTE);
                mTimePicker = new TimePickerDialog(FormADIActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        parkTime.setText( selectedHour + ":" + selectedMinute + ":00");
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Park Time");
                mTimePicker.show();

                break;

            case R.id.adi_timeStart:
                mcurrentTime = Calendar.getInstance();
                hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                minute = mcurrentTime.get(Calendar.MINUTE);
                mTimePicker = new TimePickerDialog(FormADIActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        timeStart.setText( selectedHour + ":" + selectedMinute + ":00");
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Start Time");
                mTimePicker.show();
                break;

            case R.id.adi_timeEnd:
                mcurrentTime = Calendar.getInstance();
                hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                minute = mcurrentTime.get(Calendar.MINUTE);
                mTimePicker = new TimePickerDialog(FormADIActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        timeEnd.setText( selectedHour + ":" + selectedMinute + ":00");
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select End Time");
                mTimePicker.show();
                break;
        }
    }

    public void saveForm(View view){
        if (validInputs(date, parkTime, bowserFrom, customer, salesLocation, aircaftType, airCraftNo, productType,
                packageType, specificGravity, bowserMeterStart, timeStart, bowserMeterEnd, timeEnd, aircraftMassStart, aircraftMassEnd,
                customerName)) {

            Snackbar.make(view, "Saving form....", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

            FormADI form = new FormADI();
            form.setFaitFormAdiDate(date.getText().toString());
            form.setFaitFormAdiParkTime(parkTime.getText().toString());
            form.setFaitFormAdiNo(aDINo.getText().toString());
            form.setFaitFormAdiAssetsStorageSystemCode(bowserFrom.getText().toString().split(" , ")[1]);
            form.setFaitFormAdiLocation(salesLocation.getText().toString());
            form.setFaitFormAdiAssetsCustomerSystemCode(customer.getText().toString().split(" , ")[1]);
            form.setFaitFormAdiAircraftType(aircaftType.getText().toString());
            //form.setFaitFormAdiOtherCustomer(customerOthers.getText().toString());
            form.setFaitFormAdiAircraftNo(airCraftNo.getText().toString());
            form.setFaitFormAdiFlightFrom(flightFrom.getText().toString());
            form.setFaitFormAdiFlightTo(flightTo.getText().toString());
            form.setFaitFormAdiProductType(productType.getText().toString());
            form.setFaitFormAdiPackageType(packageType.getText().toString());
            form.setFaitFormAdiSpecificGravity(specificGravity.getText().toString());
            form.setFaitFormAdiTemperature(temperature.getText().toString());
            form.setFaitFormAdiMeterStart(bowserMeterStart.getText().toString());
            form.setFaitFormAdiTimeStart(timeStart.getText().toString());
            form.setFaitFormAdiMeterEnd(bowserMeterEnd.getText().toString());
            form.setFaitFormAdiTimeEnd(timeEnd.getText().toString());
            form.setFaitFormAdiAircraftMassStart(aircraftMassStart.getText().toString());
            form.setFaitFormAdiAircraftMassEnd(aircraftMassEnd.getText().toString());
            form.setFaitFormAdiComment(comment.getText().toString());
            form.setFaitFormAdiReceivingCustomerName(customerName.getText().toString());
            //form.setFaitFormAdiReceivingCustomerSignature(signature.getSignature());
            form.setFaitFormAdiReceivingCustomerSignature(getStringFromBitmap(signature.getSignatureBitmap()));

            form.setFaitFormAdiUsersSystemCode(LoginActivity.user.getSystemCode());
            form.setFaitFormAdiSystemCode("");

            InsertUpdateQuery insertADIForm = new InsertUpdateQuery();
            insertADIForm.setTable("fait_form_adi");
            insertADIForm.setMethod("insertAdi");
            insertADIForm.setValueArray(form);

            Call<List<String>> formInsert = myApi.insertADI(insertADIForm);
            formInsert.enqueue(new Callback<List<String>>() {

                @Override
                public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                    Toast.makeText(FormADIActivity.this, response.body().get(0).toString(), Toast.LENGTH_SHORT).show();
                    if(response.body().get(0).equals("New ADI record has been successfully added")) finish();
                }

                @Override
                public void onFailure(Call<List<String>> call, Throwable t) {
                    Toast.makeText(FormADIActivity.this, "Something went wrong with insert. Try again", Toast.LENGTH_SHORT).show();
                }
            });

            //finish();
        }

    }


    public boolean validInputs(EditText... editTexts){
        for(EditText ed: editTexts){
            if(ed.getText().toString().equals("")){
                showAlertDialog(ed.getHint().toString());
                return false;
            }
        }
        return true;
    }

    public void showAlertDialog(String hint){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        //set the title to be appear in the dialog
        alertDialogBuilder.setTitle("Validation Error");
        alertDialogBuilder.setMessage("'" +hint+ "' cannot be empty");
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_alert);
        alertDialogBuilder.show();
    }

    public void clearSignature(View view){
        signature.clear();
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


    private String getStringFromBitmap(Bitmap bitmapPicture) {

        Bitmap resized= Bitmap.createScaledBitmap(bitmapPicture, 198, 78, false);
        final int COMPRESSION_QUALITY = 100;
        String encodedImage;
        ByteArrayOutputStream byteArrayBitmapStream = new ByteArrayOutputStream();
        bitmapPicture.compress(Bitmap.CompressFormat.PNG, COMPRESSION_QUALITY,
                byteArrayBitmapStream);
        byte[] b = byteArrayBitmapStream.toByteArray();
        encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
        return encodedImage;
    }

}

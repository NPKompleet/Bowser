package com.npkompleet.phenomenon.bowser.forms;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.npkompleet.phenomenon.bowser.LoginActivity;
import com.npkompleet.phenomenon.bowser.MenuActivity;
import com.npkompleet.phenomenon.bowser.R;
import com.npkompleet.phenomenon.bowser.mvp.models.Asset;
import com.npkompleet.phenomenon.bowser.mvp.models.AssetQuery;
import com.npkompleet.phenomenon.bowser.mvp.models.FormADI;
import com.npkompleet.phenomenon.bowser.mvp.models.FormLMF;
import com.npkompleet.phenomenon.bowser.mvp.models.InsertUpdateQuery;
import com.npkompleet.phenomenon.bowser.retrofit.MyApiEndpointInterface;
import com.npkompleet.phenomenon.bowser.retrofit.RetrofitUtils;

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

public class FormLMFActivity extends AppCompatActivity {

    @BindView(R.id.lmf_date) EditText date;

    @BindView(R.id.lmf_productType) EditText prodType;

    @BindView(R.id.lmf_fromStorage) EditText fromStorage;

    @BindView(R.id.lmf_fromDrain) EditText fromDrain;

    @BindView(R.id.lmf_meterStart) EditText meterStart;

    @BindView(R.id.lmf_timeStart) EditText timeStart;

    @BindView(R.id.lmf_fromDipStart) EditText fromDipStart;

    @BindView(R.id.lmf_fromDipVolStart) EditText fromDipVolStart;

    @BindView(R.id.lmf_meterEnd) EditText meterEnd;

    @BindView(R.id.lmf_timeEnd) EditText timeEnd;

    @BindView(R.id.lmf_fromDipEnd) EditText fromDipEnd;

    @BindView(R.id.lmf_fromDipVolEnd) EditText fromDipVolEnd;

    @BindView(R.id.lmf_toStorage) EditText toStorage;

    @BindView(R.id.lmf_toDrain) EditText toDrain;

    @BindView(R.id.lmf_toDipStart) EditText toDipStart;

    @BindView(R.id.lmf_toDipVolStart) EditText toDipVolStart;

    @BindView(R.id.lmf_toDipEnd) EditText toDipEnd;

    @BindView(R.id.lmf_toDipVolEnd) EditText toDipVolumeEnd;

    @BindView(R.id.lmf_comment) EditText comment;

    Calendar mcurrentDate;
    DatePickerDialog mDatePicker;
    int mYear;
    int mMonth;
    int mDay;
    TimePickerDialog mTimePicker;
    int hour;
    int minute;

    MyApiEndpointInterface myApi= RetrofitUtils.getService();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_lmf);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
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
        timeStart.setText(dt[1]);
    }


    @OnClick({R.id.lmf_date,  R.id.lmf_productType, R.id.lmf_fromStorage, R.id.lmf_timeStart,
            R.id.lmf_timeEnd, R.id.lmf_toStorage})
    public void viewClicked(View view) {

        switch (view.getId()) {
            case R.id.lmf_date:
                mcurrentDate = Calendar.getInstance();
                mYear = mcurrentDate.get(Calendar.YEAR);
                mMonth = mcurrentDate.get(Calendar.MONTH);
                mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);


                mDatePicker = new DatePickerDialog(FormLMFActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {

                        selectedmonth = selectedmonth + 1;
                        date.setText(selectedyear + "-" + selectedmonth + "-" + selectedday);
                    }
                }, mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
                break;

            case R.id.lmf_productType:
                PopupMenu productPopUp = new PopupMenu(this, prodType);
                productPopUp.getMenuInflater().inflate(R.menu.product_type_menu, productPopUp.getMenu());
                productPopUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        prodType.setText(item.getTitle());
                        return true;
                    }
                });
                productPopUp.show();
                break;

            case R.id.lmf_fromStorage:
                final PopupMenu storagePopUp= new PopupMenu(this, fromStorage);
                if(MenuActivity.assets != null){
                    for (Asset asset : MenuActivity.assets){
                        storagePopUp.getMenu().add(asset.getFaitAssetsStorageName()+" , "+ asset.getFaitAssetsStorageSystemCode());
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

                                    storagePopUp.getMenu().add(asset.getFaitAssetsStorageName() + " , " + asset.getFaitAssetsStorageSystemCode());
                                }

                                storagePopUp.getMenu().removeItem(0);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Asset>> call, Throwable t) {
                            Toast.makeText(FormLMFActivity.this, "Something went wrong. Try again", Toast.LENGTH_SHORT).show();
                        }
                    });


                    storagePopUp.getMenu().add("Loading storages....");
                }

                storagePopUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        fromStorage.setText(item.getTitle());
                        return true;
                    }
                });

                storagePopUp.show();
                break;


            case R.id.lmf_toStorage:
                final PopupMenu storePopUp= new PopupMenu(this, toStorage);
                if(MenuActivity.assets != null){
                    for (Asset asset : MenuActivity.assets){
                        storePopUp.getMenu().add(asset.getFaitAssetsStorageName()+" , "+ asset.getFaitAssetsStorageSystemCode());
                    }
                }else {

                    AssetQuery assetQuery2 = new AssetQuery();
                    assetQuery2.setWhereValues(assetQuery2.new WhereValues(LoginActivity.user.getLocationsSystemCode(), "Activated"));

                    Call<List<Asset>> call2 = myApi.getAssets(assetQuery2);
                    call2.enqueue(new Callback<List<Asset>>() {

                        @Override
                        public void onResponse(Call<List<Asset>> call, Response<List<Asset>> response) {
                            try {
                                MenuActivity.assets = response.body();
                                for (Asset asset : MenuActivity.assets) {
                                    storePopUp.getMenu().add(asset.getFaitAssetsStorageName() + " , " + asset.getFaitAssetsStorageSystemCode());
                                }

                                storePopUp.getMenu().removeItem(0);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Asset>> call, Throwable t) {
                            Toast.makeText(FormLMFActivity.this, "Something went wrong. Try again", Toast.LENGTH_SHORT).show();
                        }
                    });


                    storePopUp.getMenu().add("Loading storages....");
                }

                storePopUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        toStorage.setText(item.getTitle());
                        return true;
                    }
                });

                storePopUp.show();
                break;

            case R.id.lmf_timeStart:
                mcurrentDate = Calendar.getInstance();
                hour = mcurrentDate.get(Calendar.HOUR_OF_DAY);
                minute = mcurrentDate.get(Calendar.MINUTE);
                mTimePicker = new TimePickerDialog(FormLMFActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        timeStart.setText( selectedHour + ":" + selectedMinute + ":00");
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Start Time");
                mTimePicker.show();
                break;

            case R.id.lmf_timeEnd:
                mcurrentDate = Calendar.getInstance();
                hour = mcurrentDate.get(Calendar.HOUR_OF_DAY);
                minute = mcurrentDate.get(Calendar.MINUTE);
                mTimePicker = new TimePickerDialog(FormLMFActivity.this, new TimePickerDialog.OnTimeSetListener() {
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


    public void saveForm(View view) {
        if (validInputs(date, prodType, fromStorage, fromDrain, meterStart, timeStart, fromDipStart, fromDipVolStart, meterEnd, timeEnd,
                fromDipEnd, fromDipVolEnd, toStorage, toDrain, toDipStart, toDipVolStart, toDipEnd,
                toDipVolumeEnd)) {

            Snackbar.make(view, "Saving form....", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

            FormLMF form = new FormLMF();

            form.setFaitFormLmfDate(date.getText().toString());
            form.setFaitFormLmfFromAssetsStorageSystemCode(fromStorage.getText().toString().split(" , ")[1]);
            form.setFaitFormLmfToAssetsStorageSystemCode(toStorage.getText().toString().split(" , ")[1]);
            form.setFaitFormLmfProductType(prodType.getText().toString());
            form.setFaitFormLmfMeterStart(meterStart.getText().toString());
            form.setFaitFormLmfTimeStart(timeStart.getText().toString());
            form.setFaitFormLmfMeterEnd(meterEnd.getText().toString());
            form.setFaitFormLmfTimeEnd(timeEnd.getText().toString());
            form.setFaitFormLmfFromDrain(fromDrain.getText().toString());
            form.setFaitFormLmfFromDipStart(fromDipStart.getText().toString());
            form.setFaitFormLmfFromDipEnd(fromDipEnd.getText().toString());
            form.setFaitFormLmfFromDipVolumeStart(fromDipVolStart.getText().toString());
            form.setFaitFormLmfFromDipVolumeEnd(fromDipVolEnd.getText().toString());
            form.setFaitFormLmfToDrain(toDrain.getText().toString());
            form.setFaitFormLmfToDipStart(toDipStart.getText().toString());
            form.setFaitFormLmfToDipEnd(toDipEnd.getText().toString());
            form.setFaitFormLmfToDipVolumeStart(toDipVolStart.getText().toString());
            form.setFaitFormLmfToDipVolumeEnd(toDipVolumeEnd.getText().toString());
            form.setFaitFormLmfComment(comment.getText().toString());

            form.setFaitFormLmfUsersSystemCode(LoginActivity.user.getSystemCode());
            form.setFaitFormLmfSystemCode("");

            InsertUpdateQuery insertLMFForm = new InsertUpdateQuery();
            insertLMFForm.setTable("fait_form_lmf");
            insertLMFForm.setMethod("insertLmf");
            insertLMFForm.setValueArray(form);

            Call<List<String>> formInsert = myApi.insertLMF(insertLMFForm);
            formInsert.enqueue(new Callback<List<String>>() {

                @Override
                public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                    Toast.makeText(FormLMFActivity.this, response.body().get(0).toString(), Toast.LENGTH_SHORT).show();
                    if(response.body().get(0).equals("New LMF record has been successfully added")) finish();
                }

                @Override
                public void onFailure(Call<List<String>> call, Throwable t) {
                    Toast.makeText(FormLMFActivity.this, "Something went wrong with insert. Try again", Toast.LENGTH_SHORT).show();
                }
            });

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



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

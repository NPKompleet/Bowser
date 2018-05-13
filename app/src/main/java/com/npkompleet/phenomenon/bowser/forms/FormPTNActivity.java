package com.npkompleet.phenomenon.bowser.forms;

import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.npkompleet.phenomenon.bowser.LoginActivity;
import com.npkompleet.phenomenon.bowser.MenuActivity;
import com.npkompleet.phenomenon.bowser.R;
import com.npkompleet.phenomenon.bowser.mvp.models.Asset;
import com.npkompleet.phenomenon.bowser.mvp.models.AssetQuery;
import com.npkompleet.phenomenon.bowser.mvp.models.Customer;
import com.npkompleet.phenomenon.bowser.mvp.models.FormPTN;
import com.npkompleet.phenomenon.bowser.mvp.models.InsertUpdateQuery;
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

public class FormPTNActivity extends AppCompatActivity {


    @BindView(R.id.ptn_PTNNo) EditText ptnNo;

    @BindView(R.id.ptn_WayBNo) EditText wBNo;

    @BindView(R.id.ptn_loading_date) EditText loadingDate;

    @BindView(R.id.ptn_loading_station) EditText loadingStation;

    @BindView(R.id.ptn_transporter) EditText transporter;

    @BindView(R.id.ptn_truck_number) EditText truckNum;

    @BindView(R.id.ptn_loader_name) EditText loaderName;

    @BindView(R.id.ptn_driver_name) EditText driverName;

    @BindView(R.id.ptn_delivery_date) EditText delvDate;

    @BindView(R.id.ptn_quantity) EditText quantity;

    @BindView(R.id.ptn_toTank) EditText toTank;

    @BindView(R.id.ptn_claimableLoss) EditText claimableLoss;

    @BindView(R.id.ptn_hDip1) EditText hDip1;

    @BindView(R.id.ptn_hDip1after) EditText hDip1After;

    @BindView(R.id.ptn_hDip2) EditText hDip2;

    @BindView(R.id.ptn_hDip2after) EditText hDip2After;

    @BindView(R.id.ptn_hDip3) EditText hDip3;

    @BindView(R.id.ptn_hDip3after) EditText hDip3After;

    @BindView(R.id.ptn_hDip4) EditText hDip4;

    @BindView(R.id.ptn_hDip4after) EditText hDip4After;

    @BindView(R.id.ptn_hVol1) EditText hVol1;

    @BindView(R.id.ptn_hVol2) EditText hVol2;

    @BindView(R.id.ptn_hVol3) EditText hVol3;

    @BindView(R.id.ptn_hVol4) EditText hVol4;

    @BindView(R.id.ptn_productType) EditText productType;

    @BindView(R.id.ptn_sealNo) EditText sealNum;

    @BindView(R.id.ptn_drain)  EditText drain;

    @BindView(R.id.ptn_MeterStart) EditText meterStart;

    @BindView(R.id.ptn_MeterEnd) EditText meterEnd;

    @BindView(R.id.ptn_DipStart) EditText dipStart;

    @BindView(R.id.ptn_DipEnd) EditText dipEnd;

    @BindView(R.id.ptn_DipVolStart) EditText dipVolStart;

    @BindView(R.id.ptn_DipVolEnd) EditText dipVolEnd;

    @BindView(R.id.ptnQual_date) EditText qualDate;

    @BindView(R.id.ptnQual_batchNo) EditText qualBNo;

    @BindView(R.id.ptnQual_temperature) EditText qualTemp;

    @BindView(R.id.ptnQual_sg) EditText qualSG;

    @BindView(R.id.ptnQual_color) EditText qualColor;

    @BindView(R.id.ptnQual_waterTest) EditText qualWTest;

    @BindView(R.id.ptnQual_prodLast) EditText prodLast;

    @BindView(R.id.ptn_comment) EditText comment;

    @BindView(R.id.ptnQual_comment) EditText qualComment;

    @BindView(R.id.ptn_signature)
    SignaturePad signature;

    Calendar mcurrentDate;
    DatePickerDialog mDatePicker;
    int mYear;
    int mMonth;
    int mDay;


    MyApiEndpointInterface myApi= RetrofitUtils.getService();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ptn);
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
        loadingDate.setText(dt[0]);
        delvDate.setText(dt[0]);

    }

    @OnClick({R.id.ptn_toTank, R.id.ptn_claimableLoss, R.id.ptn_productType, R.id.ptn_delivery_date, R.id.ptn_loading_date,
    R.id.ptnQual_date, R.id.ptnQual_prodLast})
    public void viewClicked(View view) {

        switch (view.getId()) {
            case R.id.ptn_productType:
                PopupMenu productPopUp = new PopupMenu(this, productType);
                productPopUp.getMenuInflater().inflate(R.menu.product_type_menu, productPopUp.getMenu());
                productPopUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        productType.setText(item.getTitle());
                        return true;
                    }
                });
                productPopUp.show();
                break;

            case R.id.ptn_toTank:
                final PopupMenu tankPopUp = new PopupMenu(this, toTank);
                if(MenuActivity.assets != null){
                    for (Asset asset : MenuActivity.assets){
                        if(asset.getFaitAssetsStorageType().equals("Tank"))
                            tankPopUp.getMenu().add(asset.getFaitAssetsStorageName()+" , "+ asset.getFaitAssetsStorageSystemCode());
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
                                    if (asset.getFaitAssetsStorageType().equals("Tank"))
                                        tankPopUp.getMenu().add(asset.getFaitAssetsStorageName() + " , " + asset.getFaitAssetsStorageSystemCode());
                                }

                                tankPopUp.getMenu().removeItem(0);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Asset>> call, Throwable t) {
                            Toast.makeText(FormPTNActivity.this, "Something went wrong. Try again", Toast.LENGTH_SHORT).show();
                        }
                    });


                    tankPopUp.getMenu().add("Loading tanks....");
                }

                tankPopUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        toTank.setText(item.getTitle());
                        return true;
                    }
                });

                tankPopUp.show();
                break;


            case R.id.ptn_claimableLoss:
                final PopupMenu lossPopUp = new PopupMenu(this, claimableLoss);

                lossPopUp.getMenu().add("YES");
                lossPopUp.getMenu().add("NO");

                lossPopUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        claimableLoss.setText(item.getTitle());
                        return true;
                    }
                });

                lossPopUp.show();
                break;

            case R.id.ptn_delivery_date:
                mcurrentDate = Calendar.getInstance();
                mYear = mcurrentDate.get(Calendar.YEAR);
                mMonth = mcurrentDate.get(Calendar.MONTH);
                mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);


                mDatePicker = new DatePickerDialog(FormPTNActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {

                        selectedmonth = selectedmonth + 1;
                        delvDate.setText(selectedyear + "-" + selectedmonth + "-" + selectedday);
                    }
                }, mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Delivery Date");
                mDatePicker.show();
                break;

            case R.id.ptn_loading_date:
                mcurrentDate = Calendar.getInstance();
                mYear = mcurrentDate.get(Calendar.YEAR);
                mMonth = mcurrentDate.get(Calendar.MONTH);
                mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);


                mDatePicker = new DatePickerDialog(FormPTNActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        selectedmonth = selectedmonth + 1;
                        loadingDate.setText(selectedyear + "-" + selectedmonth + "-" + selectedday);
                    }
                }, mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Loading Date");
                mDatePicker.show();
                break;


            case R.id.ptnQual_date:
                mcurrentDate = Calendar.getInstance();
                mYear = mcurrentDate.get(Calendar.YEAR);
                mMonth = mcurrentDate.get(Calendar.MONTH);
                mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);



                mDatePicker = new DatePickerDialog(FormPTNActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        selectedmonth = selectedmonth + 1;
                        qualDate.setText(selectedyear + "-" + selectedmonth + "-" + selectedday);
                    }
                }, mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Quality Check Date");
                mDatePicker.show();
                break;

            case R.id.ptnQual_prodLast:
                PopupMenu prodLastPopUp = new PopupMenu(this, prodLast);
                prodLastPopUp.getMenuInflater().inflate(R.menu.product_type_menu, prodLastPopUp.getMenu());
                prodLastPopUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        prodLast.setText(item.getTitle());
                        return true;
                    }
                });
                prodLastPopUp.show();
                break;

        }
    }

    public void saveForm(View view){
        if (validInputs(ptnNo, wBNo, loadingDate, loadingStation, loadingStation, transporter, truckNum, loaderName,
                driverName, delvDate, quantity, claimableLoss, hDip1, hDip1After, hVol1, productType, sealNum, meterStart,
                dipStart, dipVolStart, meterEnd, dipEnd, dipVolEnd)) {

            Snackbar.make(view, "Saving form....", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

            FormPTN form = new FormPTN();
            form.setFaitFormPtnNo(ptnNo.getText().toString());
            form.setFaitFormPtnWaybillNo(wBNo.getText().toString());
            form.setFaitFormPtnLoadingDate(loadingDate.getText().toString());
            form.setFaitFormPtnLoadingStation(loadingStation.getText().toString());
            form.setFaitFormPtnTransporter(transporter.getText().toString());
            form.setFaitFormPtnTruckNo(truckNum.getText().toString());
            form.setFaitFormPtnLoaderName(loaderName.getText().toString());
            form.setFaitFormPtnDriverName(driverName.getText().toString());
            form.setFaitFormPtnDeliveryDate(delvDate.getText().toString());
            form.setFaitFormPtnQuantity(quantity.getText().toString());
            form.setFaitFormPtnAssetsStorageSystemCode(toTank.getText().toString().split(" , ")[1]);
            form.setFaitFormPtnComputeLoss(claimableLoss.getText().toString());
            form.setFaitFormPtnHaullageDip1(hDip1.getText().toString());
            form.setFaitFormPtnHaullageDip1End(hDip1After.getText().toString());
            form.setFaitFormPtnHaullageVolume1(hVol1.getText().toString());
            form.setFaitFormPtnHaullageDip2(hDip2.getText().toString());
            form.setFaitFormPtnHaullageDip2End(hDip2After.getText().toString());
            form.setFaitFormPtnHaullageVolume2(hVol2.getText().toString());
            form.setFaitFormPtnHaullageDip3(hDip3.getText().toString());
            form.setFaitFormPtnHaullageDip3End(hDip3After.getText().toString());
            form.setFaitFormPtnHaullageVolume3(hVol3.getText().toString());
            form.setFaitFormPtnHaullageDip4(hDip4.getText().toString());
            form.setFaitFormPtnHaullageDip4End(hDip4After.getText().toString());
            form.setFaitFormPtnHaullageVolume4(hVol4.getText().toString());
            form.setFaitFormPtnDrain(drain.getText().toString());
            form.setFaitFormPtnProductType(productType.getText().toString());
            form.setFaitFormPtnSeal(sealNum.getText().toString());

            form.setFaitFormPtnMeterStart(meterStart.getText().toString());
            form.setFaitFormPtnDipStart(dipStart.getText().toString());
            form.setFaitFormPtnDipVolumeStart(dipVolStart.getText().toString());
            form.setFaitFormPtnMeterEnd(meterEnd.getText().toString());
            form.setFaitFormPtnDipEnd(dipEnd.getText().toString());
            form.setFaitFormPtnDipVolumeEnd(dipVolEnd.getText().toString());
            form.setFaitFormPtnQualityDate(qualDate.getText().toString());
            form.setFaitFormPtnQualityBatchNo(qualBNo.getText().toString());
            form.setFaitFormPtnQualityTemperature(qualTemp.getText().toString());
            form.setFaitFormPtnQualitySpecificGravity(qualSG.getText().toString());
            form.setFaitFormPtnQualityColour(qualColor.getText().toString());
            form.setFaitFormPtnQualityTestForWater(qualWTest.getText().toString());
            form.setFaitFormPtnQualityProductLastCarried(prodLast.getText().toString());
            form.setFaitFormPtnComment(comment.getText().toString());
            form.setFaitFormPtnQualityComment(qualComment.getText().toString());
            //form.setFaitFormAdiReceivingCustomerSignature(signature.getSignature());
            form.setFaitFormPtnDriverSignature(getStringFromBitmap(signature.getSignatureBitmap()));

            form.setFaitFormPtnUsersSystemCode(LoginActivity.user.getSystemCode());
            form.setFaitFormPtnSystemCode("");


            InsertUpdateQuery insertPTNForm = new InsertUpdateQuery();
            insertPTNForm.setTable("fait_form_ptn");
            insertPTNForm.setMethod("insertPtn");
            insertPTNForm.setValueArray(form);

            Call<List<String>> formInsert = myApi.insertPTN(insertPTNForm);
            formInsert.enqueue(new Callback<List<String>>() {

                @Override
                public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                    Toast.makeText(FormPTNActivity.this, response.body().get(0).toString(), Toast.LENGTH_SHORT).show();
                    if(response.body().get(0).equals("New PTN record has been successfully added")) finish();
                }

                @Override
                public void onFailure(Call<List<String>> call, Throwable t) {
                    Toast.makeText(FormPTNActivity.this, "Something went wrong with insert. Try again", Toast.LENGTH_SHORT).show();
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

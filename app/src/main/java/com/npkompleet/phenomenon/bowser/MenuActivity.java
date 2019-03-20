package com.npkompleet.phenomenon.bowser;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.npkompleet.phenomenon.bowser.customview.CircularImageView;
import com.npkompleet.phenomenon.bowser.forms.FormLMFActivity;
import com.npkompleet.phenomenon.bowser.forms.ListADI;
import com.npkompleet.phenomenon.bowser.forms.ListPTN;
import com.npkompleet.phenomenon.bowser.mvp.models.Asset;
import com.npkompleet.phenomenon.bowser.mvp.models.AssetQuery;
import com.npkompleet.phenomenon.bowser.mvp.models.Query;
import com.npkompleet.phenomenon.bowser.mvp.models.Template;
import com.npkompleet.phenomenon.bowser.mvp.models.User;
import com.npkompleet.phenomenon.bowser.retrofit.MyApiEndpointInterface;
import com.npkompleet.phenomenon.bowser.retrofit.RetrofitUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.npkompleet.phenomenon.bowser.LoginActivity.WEBSITE;

public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.menuview_welcome)
    TextView tv_welcome;

//    @BindView(R.id.menuview_operations)
//    ExpandableRelativeLayout layout_operations;


//    @BindView(R.id.menuview_reports)
//    ExpandableRelativeLayout layout_report;
//
//    @BindView(R.id.menuview_reports_button)
//    Button layout_report_button;
//
//
//    @BindView(R.id.menuview_settings)
//    ExpandableRelativeLayout layout_settings;

    @BindView(R.id.menuview_profilepic)
    CircularImageView imageView;


    User user;

    public static List<Asset> assets;
    MyApiEndpointInterface myApi= RetrofitUtils.getService();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user= getIntent().getParcelableExtra("user");
        Picasso.with(this).load("http://197.210.12.72:8080/fait/imports/profileimage/"+user.getPicture())
                .placeholder(R.drawable.ic_person_outline)
                .error(R.drawable.ic_person_outline)
                .into(imageView);

        //final Intent intent= new Intent(this, DashboardActivity.class);


        //layout_report_button.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_black, 0);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                startActivity(intent);*/
                try {
                    Uri webpage = Uri.parse(WEBSITE);
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MenuActivity.this, "No application can handle this request. Please install a web browser or check your URL.",  Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });


    }


    @Override
    protected void onStart() {
        super.onStart();
        if(assets == null && networkActive()) {
            AssetQuery assetQuery = new AssetQuery();
            assetQuery.setWhereValues(assetQuery.new WhereValues(LoginActivity.user.getLocationsSystemCode(), "Activated"));

            Call<List<Asset>> call = myApi.getAssets(assetQuery);
            call.enqueue(new Callback<List<Asset>>() {

                @Override
                public void onResponse(Call<List<Asset>> call, Response<List<Asset>> response) {
                    try {
                        assets = response.body();
                        //Toast.makeText(MenuActivity.this, "Assets loaded", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(MenuActivity.this, "Unable to load assets", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();

                    }
                }

                @Override
                public void onFailure(Call<List<Asset>> call, Throwable t) {
                    Toast.makeText(MenuActivity.this, "Something went wrong. Try again", Toast.LENGTH_SHORT).show();
                }
            });
        }else if(!networkActive()){
            Toast.makeText(MenuActivity.this, "No network. Please turn on your internet connection", Toast.LENGTH_LONG).show();
        }

    }

    //when profile option is clicked start a profile activity
    public void showProfileActivity(View view){
        Intent intent= new Intent(this, ProfileActivity.class);
        intent.putExtra("profile", user);
        startActivity(intent);

    }

    //show options under operations
    /*public void showOperationsOptions(View view){
        layout_operations.toggle();
    }*/

    //show options under reports
   /* public void showReportOptions(View view){

        layout_report.toggle();
    }*/

    //show options under settings
    /*public void showSettingsOptions(View view){
        layout_settings.toggle();
    }*/


    //when any option under operations in selected
//    public void onOperationsOptionSelected(View view){
//        Intent i;
//        /*switch (view.getId()){
//            case R.id.menuview_operations_dispense:
//                Intent i= new Intent(this, OperationDispenseActivity.class);
//                startActivity(i);
//                break;
//
//        }*/
//        switch (view.getId()) {
//
//            case R.id.menuview_operations_customer:
//                i = new Intent(this, CustomerManagerActivity.class);
//                startActivity(i);
//                break;
//
//            case R.id.menuview_operations_dispenseLocation:
//                i = new Intent(this, LocationManagerActivity.class);
//                startActivity(i);
//                break;
//
//
//            case R.id.menuview_operations_trucks:
//                i = new Intent(this, TruckManagerActivity.class);
//                startActivity(i);
//                break;
//
//
//            case R.id.menuview_operations_product:
//                i = new Intent(this, ProductManagerActivity.class);
//                startActivity(i);
//                break;
//
//
//            case R.id.menuview_operations_tanks:
//                i = new Intent(this, TankManagerActivity.class);
//                startActivity(i);
//                break;
//
//
//            case R.id.menuview_operations_forms:
//                i = new Intent(this, FormsActivity.class);
//                startActivity(i);
//                break;
//
//        }
//
//    }


    //when any option under settings is selected
//    public void onSettingsOptionSelected(View view){
//        Intent i;
//        switch (view.getId()){
//            case R.id.menuview_settings_userSettings:
//                i= new Intent(this, UserManagerActivity.class);
//                startActivity(i);
//                break;
//
//            case R.id.menuview_settings_unitSettings:
//                i= new Intent(this, UnitManagerActivity.class);
//                startActivity(i);
//                break;
//
//            case R.id.menuview_settings_designationSettings:
//                i= new Intent(this, DesignationManagerActivity.class);
//                startActivity(i);
//                break;
//
//            case R.id.menuview_settings_groupSettings:
//                i= new Intent(this, GroupManagerActivity.class);
//                startActivity(i);
//                break;
//
//            case R.id.menuview_settings_companySettings:
//                i= new Intent(this, CompanyManagerActivity.class);
//                startActivity(i);
//                break;

//        }

//    }


    //when any option under operations in selected
    public void showForm(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.form_menu_adi:
                i= new Intent(this, ListADI.class);
                startActivity(i);
                break;

            case R.id.form_menu_ptn:
                i= new Intent(this, ListPTN.class);
                startActivity(i);
                break;

            case R.id.form_menu_lmf:
                i= new Intent(this, FormLMFActivity.class);
                startActivity(i);
                break;

        }
    }

    public boolean networkActive() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }



}

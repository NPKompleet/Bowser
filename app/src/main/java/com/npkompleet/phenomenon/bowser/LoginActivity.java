package com.npkompleet.phenomenon.bowser;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.npkompleet.phenomenon.bowser.bluetooth.BluetoothUtils;
import com.npkompleet.phenomenon.bowser.mvp.models.Query;
import com.npkompleet.phenomenon.bowser.mvp.models.QueryParameters;
import com.npkompleet.phenomenon.bowser.mvp.models.Template;
import com.npkompleet.phenomenon.bowser.mvp.models.User;
import com.npkompleet.phenomenon.bowser.mvp.models.UserQuery;
import com.npkompleet.phenomenon.bowser.retrofit.MyApiEndpointInterface;
import com.npkompleet.phenomenon.bowser.retrofit.RetrofitUtils;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.security.MessageDigest;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{

    @BindView(R.id.email)
    EditText mEmailView;
    @BindView(R.id.password)
    EditText mPasswordView;
    @BindView(R.id.login_progress)
    ProgressBar mProgressView;
    @BindView(R.id.email_login_form)
    View mLoginFormView;

    @BindView(R.id.login_logo)
    ImageView imageView;

    @BindView(R.id.content_login)
    RelativeLayout contentLogin;

    MyApiEndpointInterface myApi;
    public static User user;

    public static Bitmap LOGO=null;
    public static String NAME;
    public static String HEADER;
    public static String FOOTER;
    public static String WEBSITE;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Query templateQuery = new Query();
        templateQuery.setMainTable("fait_settings");
        templateQuery.setMethod("printTemplate");
        /*Gson gson = new Gson();
        String uaString = gson.toJson(templateQuery);
        Toast.makeText(LoginActivity.this, uaString, Toast.LENGTH_SHORT).show();*/
        MyApiEndpointInterface myApi= RetrofitUtils.getService();
        Call<Template> call = myApi.getTemplate(templateQuery);
        call.enqueue(new Callback<Template>() {

            @Override
            public void onResponse(Call<Template> call, Response<Template> response) {
                Template template= response.body();
                //Toast.makeText(LoginActivity.this, template.getLogo()+" "+ template.getHeader(), Toast.LENGTH_SHORT).show();
                Picasso.with(LoginActivity.this).load("http://197.210.12.72:8080/fait/imports/configuration/" +template.getLogo2())
                        .into(imageView);
                //fetchLogo("http://197.210.12.72:8080/fait/imports/configuration/" +template.getLogo());
                LoginActivity.DownloadImageWithURLTask downloadTask = new LoginActivity.DownloadImageWithURLTask();
                downloadTask.execute("http://197.210.12.72:8080/fait/imports/configuration/" +template.getLogo());
                NAME= template.getName();
                HEADER= template.getHeader();
                FOOTER= template.getFooter();
                WEBSITE= template.getWebsiteLink();
            }

            @Override
            public void onFailure(Call<Template> call, Throwable t) {

            }
        });
    }





    //checks if the email or password fields are empty
    private boolean anyFieldIsEmpty(){
        return  (TextUtils.isEmpty(mEmailView.getText().toString()) || TextUtils.isEmpty(mPasswordView.getText().toString()));
    }


    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }



    //when sign in button is clicked
    @OnClick(R.id.email_sign_in_button)
    public void onClick(){

        if (anyFieldIsEmpty()){
            Snackbar.make(mLoginFormView, "UserId or Password cannot be empty", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return;
        }

        if (!networkActive()){
            Snackbar.make(mLoginFormView, "No network available. Check your network", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return;
        }


        mProgressView.setVisibility(View.VISIBLE);
        mProgressView.setIndeterminate(true);


        myApi= RetrofitUtils.getService();
        String hack="";

        try {
            hack=md5(mPasswordView.getText().toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //UserQuery.UserWhereValues uAccess= new UserQuery.UserWhereValues(mEmailView.getText().toString(), hack );
        UserQuery userQuery= new UserQuery();
        userQuery.setMainTable("fait_users");
        //userQuery.setMethod("search");
        //userQuery.setJoinArrayParameters(new QueryParameters.JoinArrayParameters());
        //userQuery.setWherein(new QueryParameters.Wherein());
        //userQuery.setSelectValues(new QueryParameters.SelectValues());
        userQuery.setWhereValues(userQuery.new UserWhereValues(mEmailView.getText().toString(), hack));
        //userQuery.setOrdersBy(new QueryParameters.OrdersBy());

        /*Gson gson = new Gson();
        String uaString = gson.toJson(userQuery);
        Toast.makeText(LoginActivity.this, uaString, Toast.LENGTH_SHORT).show();*/


        Call<List<User>> call = myApi.loginUser(userQuery);


        call.enqueue(new Callback<List<User>>(){

            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                //int statusCode = response.code();
                try{
                    user = response.body().get(0);

                    //Toast.makeText(LoginActivity.this, user.getStatus(), Toast.LENGTH_SHORT).show();

                    if (user.getStatus().equals("Activated")){
                        Snackbar.make(mLoginFormView, "logging in...", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        startMenuActivity(user);
                    }else{
                        mProgressView.setVisibility(View.GONE);
                        Snackbar.make(mLoginFormView, "Wrong UserId or Password. Try again", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }catch (Exception e){
                    Snackbar.make(mLoginFormView, "Wrong UserId or Password. Try again", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                mProgressView.setVisibility(View.GONE);
                Snackbar.make(mLoginFormView, "Wrong UserId or Password. Try again", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                t.printStackTrace();

            }
        });

    }


    //starts the menu activity
    public void startMenuActivity(User user){
        Intent intent= new Intent(this, MenuActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();
    }

    //converts any string to its MD5 hash
    private static String md5(String data) throws NoSuchAlgorithmException {
        // Get the algorithm:
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // Calculate Message Digest as bytes:
        byte[] digest = md5.digest(data.getBytes(UTF_8));
        // Convert to 32-char long String:
        return String.format("%032x", new BigInteger(1, digest));
    }

    //checks for network and internet
    public boolean networkActive() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }


    public static void setLOGO(Bitmap LOGO) {
        LoginActivity.LOGO = LOGO;
    }


    private static class DownloadImageWithURLTask extends AsyncTask<String, Void, Bitmap> {

        public DownloadImageWithURLTask() {

        }

        protected Bitmap doInBackground(String... urls) {
            String pathToFile = urls[0];
            Bitmap bitmap = null;
            try {
                InputStream in = new java.net.URL(pathToFile).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bitmap;
        }
        protected void onPostExecute(Bitmap result) {
            setLOGO(result);
        }
    }



}


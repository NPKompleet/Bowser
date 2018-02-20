package com.npkompleet.phenomenon.bowser.settings;

import android.content.Context;
import android.content.Intent;
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
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.npkompleet.phenomenon.bowser.MenuActivity;
import com.npkompleet.phenomenon.bowser.ProfileActivity;
import com.npkompleet.phenomenon.bowser.R;
import com.npkompleet.phenomenon.bowser.mvp.models.UserInfo;
import com.npkompleet.phenomenon.bowser.mvp.models.UserList;
import com.npkompleet.phenomenon.bowser.mvp.models.UserListAccess;
import com.npkompleet.phenomenon.bowser.retrofit.MyApiEndpointInterface;
import com.npkompleet.phenomenon.bowser.retrofit.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserManagerActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, UserListAdapter.UserClickHandler{

    @BindView(R.id.rv_user_list)
    RecyclerView mUserRecyclerView;

    @BindView(R.id.swipeLayout)
    FloatingActionButton fab;

    @BindView(R.id.fab)
    SwipeRefreshLayout swipeRefreshLayout;

    UserListAdapter adapter;

    //List<UserInfo> users= new ArrayList<UserInfo>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manager);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUserRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new UserListAdapter(this, new ArrayList<UserInfo>(), this);
        mUserRecyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onUserListItemClicked(View view){
        startActivity(new Intent(UserManagerActivity.this, ProfileActivity.class));
    }


    @Override
    protected void onStart() {
        super.onStart();
        onRefresh();
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



    public boolean networkActive() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }



    @Override
    public void onRefresh() {

        if (!networkActive()){
            Snackbar.make(fab, "No network available. Check your network", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return;
        }


        swipeRefreshLayout.setRefreshing(true);

        MyApiEndpointInterface myApi= RetrofitUtils.getService();

        UserListAccess access= new UserListAccess(10, 0, "userList");

        //Call<User> call = myApi.loginUser(mEmailView.getText().toString(), mPasswordView.getText().toString(), "login");
        Call<UserList> call = myApi.getUserList(access);
        //Toast.makeText(this, "text", Toast.LENGTH_SHORT).show();

        call.enqueue(new Callback<UserList>(){

            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                //int statusCode = response.code();
                UserList users = response.body();

                List<UserInfo> returnedUsers= users.getUserInfo();

                adapter.swapData(returnedUsers);
                swipeRefreshLayout.setRefreshing(false);

                //Toast.makeText(UserManagerActivity.this, user.getMessage(), Toast.LENGTH_SHORT).show();

               /* if (user.getStatus().equals("1") && user.getUserInfo().getUserStatus().equals("Active")){
                    Snackbar.make(mLoginFormView, user.getMessage(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    startMenuActivity(user);
                }else{
                    mProgressView.setVisibility(View.GONE);
                    Snackbar.make(mLoginFormView, "Wrong Email or Password", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }*/
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(UserManagerActivity.this, "Something went wrong. Try again", Toast.LENGTH_SHORT).show();
                t.printStackTrace();

            }
        });






    }

    @Override
    public void onClickUser(UserInfo user) {
        Intent intent= new Intent(this, ProfileActivity.class);
        intent.putExtra("profile", user);
        startActivity(intent);
    }
}

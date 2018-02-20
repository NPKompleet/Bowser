package com.npkompleet.phenomenon.bowser;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.npkompleet.phenomenon.bowser.customview.CircularImageView;
import com.npkompleet.phenomenon.bowser.customview.ExpandableRelativeLayout;
import com.npkompleet.phenomenon.bowser.mvp.models.User;
import com.npkompleet.phenomenon.bowser.operations.OperationDispenseActivity;
import com.npkompleet.phenomenon.bowser.settings.UserManagerActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.menuview_welcome)
    TextView tv_welcome;

    @BindView(R.id.menuview_operations)
    ExpandableRelativeLayout layout_operations;

    /*@BindView(R.id.menuview_transactions)
    TextView tv_transactions;*/

    @BindView(R.id.menuview_reports)
    ExpandableRelativeLayout layout_report;

    @BindView(R.id.menuview_reports_button)
    Button layout_report_button;

    /*@BindView(R.id.menuview_task_manager)
    TextView tv_taskManager;*/

    @BindView(R.id.menuview_settings)
    ExpandableRelativeLayout layout_settings;

    @BindView(R.id.menuview_profilepic)
    CircularImageView imageView;

    User user;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user= getIntent().getParcelableExtra("user");
        Picasso.with(this).load(user.getUserInfo().getUserPicture())
                .placeholder(R.drawable.ic_person_outline)
                .error(R.drawable.ic_person_outline)
                .into(imageView);

        final Intent intent= new Intent(this, DashboardActivity.class);


        layout_report_button.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_black, 0);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                startActivity(intent);
            }
        });


    }

    public void showProfileActivity(View view){
        Intent intent= new Intent(this, ProfileActivity.class);
        intent.putExtra("profile", user.getUserInfo());
        startActivity(intent);

    }

    public void showOperationsOptions(View view){
        layout_operations.toggle();
    }

    public void showReportOptions(View view){
        //AnimationDrawable d = (AnimationDrawable) layout_report_button.getCompoundDrawables()[2];
        //AnimationDrawable d = (AnimationDrawable) getResources().getDrawable(R.drawable.expand_anim);
        //d.start();
        layout_report.toggle();
    }

    public void showSettingsOptions(View view){
        layout_settings.toggle();
    }


    public void onOperationsOptionSelected(View view){
        switch (view.getId()){
            case R.id.menuview_operations_dispense:
                Intent i= new Intent(this, OperationDispenseActivity.class);
                startActivity(i);
                break;

        }

    }


    public void onSettingsOptionSelected(View view){
        switch (view.getId()){
            case R.id.menuview_settings_userSettings:
                Intent i= new Intent(this, UserManagerActivity.class);
                startActivity(i);
                break;

        }

    }

}

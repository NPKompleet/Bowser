package com.npkompleet.phenomenon.bowser;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.npkompleet.phenomenon.bowser.mvp.models.User;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.profileView_image)
    ImageView profImage;

    @BindView(R.id.profileView_firstName)
    TextView profFName;

    @BindView(R.id.profileView_lastName)
    TextView profLName;

    @BindView(R.id.profileView_email)
    TextView profEmail;

    @BindView(R.id.profileView_number)
    TextView profPhone;

    @BindView(R.id.profileView_status)
    SwitchCompat profStatusSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        User profile= getIntent().getParcelableExtra("profile");

        //populate views
        Picasso.with(this).load(profile.getPicture())
                .placeholder(R.drawable.ic_person_outline)
                .error(R.drawable.ic_person_outline)
                .into(profImage);

        profFName.setText(profile.getFirstName());
        profLName.setText(profile.getLastName());
        profEmail.setText(profile.getEmail());
        profPhone.setText(profile.getPhone());
        profStatusSwitch.setChecked(profile.getStatus().equals("Blocked"));

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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
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

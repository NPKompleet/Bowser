package com.npkompleet.phenomenon.bowser.settings;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.npkompleet.phenomenon.bowser.R;
import com.npkompleet.phenomenon.bowser.customview.ExpandableRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UnitManagerActivity extends AppCompatActivity {

    @BindView(R.id.unitManager_unit_description)
    ExpandableRelativeLayout layout_decription;

    @BindView(R.id.unitManager_unit_shortDescription)
    TextView layout_shDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_manager);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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


    //show full unit description
    public void onUnitListItemClicked(View view){
        layout_shDescription.setVisibility(layout_shDescription.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
        layout_decription.toggle();
    }

}

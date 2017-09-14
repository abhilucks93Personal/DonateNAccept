package com.donatenaccept.dna.citiesAutoComplete.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna.citiesAutoComplete.general.DelayAutoCompleteTextView;
import com.donatenaccept.dna.citiesAutoComplete.general.MyAutoCompleteAdapter;


/**
 * Created by abhi on 17/04/17.
 */

public class LocationActivity extends Activity implements View.OnClickListener {


    ImageView iconLeft;
    TextView tv_title;
    DelayAutoCompleteTextView cityPrediction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_location);

        setActionBarView();
        findViewById();
        initUi();

    }

    private void initUi() {
        cityPrediction.setThreshold(1);
        cityPrediction.setAdapter(new MyAutoCompleteAdapter(this));
        cityPrediction.setLoadingIndicator((android.widget.ProgressBar) findViewById(R.id.progressBar));
        cityPrediction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String city = (String) adapterView.getItemAtPosition(position);
                cityPrediction.setText(city);
                cityPrediction.setSelection(cityPrediction.getText().length());
            }
        });
    }

    private void findViewById() {

        cityPrediction = (DelayAutoCompleteTextView) findViewById(R.id.cityTitle);

    }

    private void setActionBarView() {

        tv_title = (TextView) findViewById(R.id.actionbar_view_title);
        tv_title.setText("Search Location");

        iconLeft = (ImageView) findViewById(R.id.actionbar_view_icon_left);
        iconLeft.setVisibility(View.VISIBLE);
        iconLeft.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.actionbar_view_icon_left:
                finish();
                break;


        }
    }
}

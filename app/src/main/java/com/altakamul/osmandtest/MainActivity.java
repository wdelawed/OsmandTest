package com.altakamul.osmandtest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText fromLat ;
    EditText fromLong ;
    EditText toLat ;
    EditText toLong ;

    Button navigateButton ;

    Activity activity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this ;

        fromLat = findViewById(R.id.from_lat) ;
        fromLong = findViewById(R.id.from_long) ;
        toLat = findViewById(R.id.to_lat) ;
        toLong = findViewById(R.id.to_long) ;

        navigateButton = findViewById(R.id.navigate_button) ;

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double flat  = Double.parseDouble(fromLat.getText().toString()) ;
                double flong = Double.parseDouble(fromLong.getText().toString()) ;
                double tlat  = Double.parseDouble(toLat.getText().toString()) ;
                double tlong = Double.parseDouble(toLong.getText().toString()) ;

                OsmAndHelper helper = new OsmAndHelper(activity, 10, new OsmAndHelper.OnOsmandMissingListener() {
                    @Override
                    public void osmandMissing() {
                        Log.d("Osmand","Osmand App is missing") ;
                    }
                }) ;
                helper.navigate("Khartoum",flat,flong,"Umodurman",tlat,tlong,"me",true);
            }
        });
    }
}

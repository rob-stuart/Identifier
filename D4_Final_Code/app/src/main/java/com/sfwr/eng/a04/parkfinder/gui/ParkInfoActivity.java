package com.sfwr.eng.a04.parkfinder.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sfwr.eng.a04.parkfinder.R;
import com.sfwr.eng.a04.parkfinder.parks.Park;

public class ParkInfoActivity extends AppCompatActivity {
    private final static String TAG = "MINE.info: ";
    private Park park;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_info);

        park = (Park) getIntent().getSerializableExtra("park");

        TextView t = (TextView) findViewById(R.id.Name);
        t.setText(park.getName());
        t = (TextView) findViewById(R.id.activities);
        for (String foo : park.getActivityTypes()) {
            t.setText(t.getText() + " " + foo);
        }
        t = (TextView) findViewById(R.id.Camping);
        for (String foo : park.getCampTypes()) {
            t.setText(t.getText() + " " + foo);
        }
        t = (TextView) findViewById(R.id.Facilities);
        for (String foo : park.getFacilityType()) {
            t.setText(t.getText() + " " + foo);
        }
        t = (TextView) findViewById(R.id.size);
        t.setText(t.getText() + " " + Double.toString(park.getSize()));
        t = (TextView) findViewById(R.id.url);
        t.setText(t.getText() + " " + park.getURL());

    }

    public void onViewMapClick(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("park", park);
        startActivity(intent);
    }
}
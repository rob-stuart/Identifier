package com.sfwr.eng.a04.parkfinder.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sfwr.eng.a04.parkfinder.R;
import com.sfwr.eng.a04.parkfinder.blackboard.BlackBoard;
import com.sfwr.eng.a04.parkfinder.parks.Park;

public class ParkListingsActivity extends AppCompatActivity {
    private final static String TAG = "MINE.listings: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_listings);

        BlackBoard blackBoard = (BlackBoard) getIntent().getSerializableExtra(BlackBoard.ID);
        LinearLayout layout = (LinearLayout) findViewById(R.id.content_vertical);
        Button but;
        for (final Park park : blackBoard.getMatchingParks()) {
            but = new Button(this);
            but.setText(park.getName());
            but.setTextColor(ContextCompat.getColor(this, R.color.expertClickable));
            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ParkListingsActivity.this, ParkInfoActivity.class);
                    intent.putExtra("park", park);
                    startActivity(intent);
                }
            });
            layout.addView(but);
        }
    }
}
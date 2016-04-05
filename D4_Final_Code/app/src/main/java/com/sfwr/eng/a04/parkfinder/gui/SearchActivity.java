package com.sfwr.eng.a04.parkfinder.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sfwr.eng.a04.parkfinder.R;
import com.sfwr.eng.a04.parkfinder.blackboard.BlackBoard;
import com.sfwr.eng.a04.parkfinder.parks.Park;

public class SearchActivity extends AppCompatActivity {
    private final static String TAG = "MINE== searchactivity";
    private BlackBoard blackBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "oncreate");
        setContentView(R.layout.activity_search);
        blackBoard = (BlackBoard) getIntent().getSerializableExtra("blackboard");
        LinearLayout layout = (LinearLayout) findViewById(R.id.content_vertical);
        Button but;
        if (blackBoard != null) {
            for (String expert : blackBoard.getAvailableExpertNames()) {
                but = new Button(this);
                but.setText(expert);
                but.setTextColor(ContextCompat.getColor(this, R.color.expertClickable));
                but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button button = (Button) v;
                        blackBoard.useExpert(SearchActivity.this, button.getText().toString());
                    }
                });
                layout.addView(but);
            }
        }
        but = new Button(this);
        but.setText("getshit");
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Park park : blackBoard.getMatchingParks()) {
                    Log.d(TAG, park.getName());
                }
            }
        });
        layout.addView(but);

    }


    public void onSearchClick(View view) {
        Intent intent = new Intent(this, ParkListingsActivity.class);
        intent.putExtra("blackboard", blackBoard);
        startActivity(intent);
    }
}
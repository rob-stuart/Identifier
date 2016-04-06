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

public class SearchActivity extends AppCompatActivity {
    private final static String TAG = "MINE.search: ";
    private BlackBoard blackBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        blackBoard = (BlackBoard) getIntent().getSerializableExtra(BlackBoard.ID);
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
    }

    public void onSearchClick(View view) {
        Intent intent = new Intent(this, ParkListingsActivity.class);
        intent.putExtra(BlackBoard.ID, blackBoard);
        startActivity(intent);
    }
}
package com.sfwr.eng.a04.parkfinder.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sfwr.eng.a04.parkfinder.R;
import com.sfwr.eng.a04.parkfinder.blackboard.BlackBoard;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MINE.main: ";
    private BlackBoard blackBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blackBoard = new BlackBoard(this);
    }

    public void onStartSearch(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("blackboard", blackBoard);
        startActivity(intent);
    }
}
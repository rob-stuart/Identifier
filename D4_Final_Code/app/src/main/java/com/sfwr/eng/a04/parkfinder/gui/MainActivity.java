package com.sfwr.eng.a04.parkfinder.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sfwr.eng.a04.parkfinder.R;
import com.sfwr.eng.a04.parkfinder.blackboard.BlackBoard;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MINE== mainactivity";
    private BlackBoard blackBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blackBoard = new BlackBoard(this);


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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onStartSearch(View view) {
        Log.d(TAG, "clicked_1");
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("blackboard", blackBoard);
        Log.d(TAG, "clicked_2");
        startActivity(intent);
    }

//    public void onSearchParksClick(View view) {
//        Log.d(TAG, "clicked_1");
//        blackBoard.useExpert(this, "Facilities");
//        Log.d(TAG, "clicked_2");
//    }

    public void onViewAllParksClick(View view) {
        //TODO get back to this later
//        Intent getNameScreenIntent = new Intent(this, SecondScreen.class);
//        final int result = 1;
//        getNameScreenIntent.putExtra("callingActivity", "MainActivity");
//        startActivityForResult(getNameScreenIntent, result);

    }
}


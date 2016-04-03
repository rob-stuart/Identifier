package com.sfwr.eng.a04.parkfinder.gui;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.sfwr.eng.a04.parkfinder.R;

/**
 * Created by Nathanael on 02-Apr-2016.
 */
public class SearchActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[]paths = {"Location","Rentals","Amenities","Size","Seasons","Activities"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_search);

        spinner = (Spinner)findViewById(R.id.searchCriteriaSpinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(SearchActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the third item gets selected
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onSearchCriteriaClick(View view) {
        //TODO
    }
}



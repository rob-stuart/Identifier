package com.sfwr.eng.a04.parkfinder.gui;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.sfwr.eng.a04.parkfinder.R;

import java.util.ArrayList;

/**
 * Created by Nathanael on 02-Apr-2016.
 */
public class SearchActivity extends Activity {
    private CheckBox checkCanoeing, checkBirding, checkFishing, checkHiking,checkNaturalHeritage,
            checkBarrierFree, checkBoatLaunch, checkComfortStations, checkDayuse, checkFlushToilets,
            checkLaundromat, checkParkStore, checkPicnicShelters, checkRentals, checkSwimming, checkHunting, checkWinterActivities,
    checkVisitorCenter, checkPetExerciseArea;

    ArrayList<String> filterOptions = new ArrayList<String>();
    TextView finalText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_search);
        /*checkCanoeing = (CheckBox) findViewById(R.id.checkBox_Canoeing);
        checkBirding = (CheckBox) findViewById(R.id.checkBox_Birding);
        checkFishing = (CheckBox) findViewById(R.id.checkBox_Fishing);
        checkHiking = (CheckBox) findViewById(R.id.checkBox_Hiking);
        checkNaturalHeritage = (CheckBox) findViewById(R.id.checkBox_NaturalHeritage);
        checkBarrierFree = (CheckBox) findViewById(R.id.checkBox_BarrierFree);
        checkBoatLaunch = (CheckBox) findViewById(R.id.checkBox_BoatLaunch);
        checkComfortStations = (CheckBox) findViewById(R.id.checkBox_ComfortStations);
        checkDayuse = (CheckBox) findViewById(R.id.checkBox_DayUse);
        checkFlushToilets = (CheckBox) findViewById(R.id.checkBox_FlushToilets);
        checkLaundromat = (CheckBox) findViewById(R.id.checkBox_Laundromat);
        checkParkStore = (CheckBox) findViewById(R.id.checkBox_ParkStore);
        checkPicnicShelters = (CheckBox) findViewById(R.id.checkBox_PicnicShelters);
        checkRentals = (CheckBox) findViewById(R.id.checkBox_Rentals);
        checkSwimming = (CheckBox) findViewById(R.id.checkBox_Swimming);
        checkHunting = (CheckBox) findViewById(R.id.checkBox_Hunting);
        checkWinterActivities = (CheckBox) findViewById(R.id.checkBox_WinterActivites);
        checkVisitorCenter = (CheckBox) findViewById(R.id.checkBox_VisitorCenter);
        checkPetExerciseArea = (CheckBox) findViewById(R.id.checkBox_PetExerciseArea);*/

        finalText = (TextView) findViewById(R.id.final_result);
        finalText.setEnabled(false);

    }


    public void checkBox(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.checkBox_Canoeing:
                if (checked) {
                    filterOptions.add("Canoeing");
                } else {
                    filterOptions.remove("Canoeing");
                }
                break;

            case R.id.checkBox_Birding:
                if (checked) {
                    filterOptions.add("Birding");
                } else {
                    filterOptions.remove("Birding");
                }
                break;

            case R.id.checkBox_Fishing:
                if (checked) {
                    filterOptions.add("Fishing");
                } else {
                    filterOptions.remove("Fishing");
                }
                break;

            case R.id.checkBox_Hiking:
                if (checked) {
                    filterOptions.add("Hiking");
                } else {
                    filterOptions.remove("Hiking");
                }
                break;

            case R.id.checkBox_NaturalHeritage:
                if (checked) {
                    filterOptions.add("Natural Heritage");
                } else {
                    filterOptions.remove("Natural Heritage");
                }
                break;

            case R.id.checkBox_BarrierFree:
                if (checked) {
                    filterOptions.add("Barrier Free");
                } else {
                    filterOptions.remove("Barrier Free");
                }
                break;

            case R.id.checkBox_BoatLaunch:
                if (checked) {
                    filterOptions.add("Boat Launch");
                } else {
                    filterOptions.remove("Boat Launch");
                }
                break;

            case R.id.checkBox_ComfortStations:
                if (checked) {
                    filterOptions.add("Comfort Stations");
                } else {
                    filterOptions.remove("Comfort Stations");
                }
                break;

            case R.id.checkBox_DayUse:
                if (checked) {
                    filterOptions.add("Day Use");
                } else {
                    filterOptions.remove("Day Use");
                }
                break;

            case R.id.checkBox_FlushToilets:
                if (checked) {
                    filterOptions.add("Flush Toilets");
                } else {
                    filterOptions.remove("Flush Toilets");
                }
                break;

            case R.id.checkBox_Laundromat:
                if (checked) {
                    filterOptions.add("Laundromat");
                } else {
                    filterOptions.remove("Laundromat");
                }
                break;

            case R.id.checkBox_ParkStore:
                if (checked) {
                    filterOptions.add("Park Store");
                } else {
                    filterOptions.remove("Park Store");
                }
                break;

            case R.id.checkBox_PicnicShelters:
                if (checked) {
                    filterOptions.add("Picnic Shelters");
                } else {
                    filterOptions.remove("Picnic Shelters");
                }
                break;

            case R.id.checkBox_Rentals:
                if (checked) {
                    filterOptions.add("Rentals");
                } else {
                    filterOptions.remove("Rentals");
                }
                break;

            case R.id.checkBox_Swimming:
                if (checked) {
                    filterOptions.add("Swimming");
                } else {
                    filterOptions.remove("Swimming");
                }
                break;

            case R.id.checkBox_Hunting:
                if (checked) {
                    filterOptions.add("Hunting");
                } else {
                    filterOptions.remove("Hunting");
                }
                break;

            case R.id.checkBox_WinterActivities:
                if (checked) {
                    filterOptions.add("Winter Activities");
                } else {
                    filterOptions.remove("Winter Activities");
                }
                break;

            case R.id.checkBox_VisitorCenter:
                if (checked) {
                    filterOptions.add("Visitor Center");
                } else {
                    filterOptions.remove("Visitor Center");
                }
                break;

            case R.id.checkBox_PetExerciseArea:
                if (checked) {
                    filterOptions.add("Pet Exercise Area");
                } else {
                    filterOptions.remove("Pet Exercise Area");
                }
                break;

        }
    }

        public void finalSelection(View view){
            String final_filter_selection = "";
            for(String Selections: filterOptions){
                final_filter_selection = final_filter_selection + Selections + "\n";
        }
            finalText.setText(final_filter_selection);
            finalText.setEnabled(true);

    }

}





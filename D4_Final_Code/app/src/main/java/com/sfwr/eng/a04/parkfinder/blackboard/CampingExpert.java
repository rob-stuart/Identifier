package com.sfwr.eng.a04.parkfinder.blackboard;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.sfwr.eng.a04.parkfinder.R;
import com.sfwr.eng.a04.parkfinder.parks.Park;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class CampingExpert extends Expert {
    private static final String TAG = "MINE== CampingExpert";
    public static final String name = "Camping";
    private static HashMap<String, Boolean> criteria = null;

    CampingExpert(Set<Park> allParks) {
        criteria = new HashMap<>(20);
        for (Park park : allParks) {
            for (String camp : park.getFacilityType()) {
                criteria.put(camp, false);
            }
        }
    }

    public CampingExpert() {
        super();
    }

    @Override
    public void getMatchingParks(Set<Park> parkSet) {
        for (String foo : criteria.keySet()) {
            if (criteria.get(foo)) {
                Log.d(TAG, foo);
            }
        }
        if (isCriteriaSet()) {
            Set<String> selected = new HashSet<>(criteria.size());
            for (String camp : criteria.keySet()) {
                if (criteria.get(camp)) {
                    selected.add(camp);
                }
            }
            HashSet<Park> temp = new HashSet<>(parkSet);
            for (Park park : temp) {
                if (!park.getCampTypes().containsAll(selected)) {
                    parkSet.remove(park);
                }
            }

        }
    }

    @Override
    public boolean isCriteriaSet() {
        return criteria.values().contains(true);
    }

    @Override
    public String getName() {
        return name;
    }

    public void onCriteriaSet(View view) {
        finish();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_expert_camp);
        LinearLayout content = (LinearLayout) findViewById(R.id.content_vertical);

        CheckBox test;
        for (String camp : criteria.keySet()) {
            test = new CheckBox(this);
            test.setText(camp);
            test.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox box = (CheckBox) v;
                    criteria.put(box.getText().toString(), box.isChecked());
                }
            });
            content.addView(test);
        }
    }

}
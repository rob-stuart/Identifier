package com.sfwr.eng.a04.parkfinder.blackboard;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.sfwr.eng.a04.parkfinder.R;
import com.sfwr.eng.a04.parkfinder.parks.Park;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FacilitiesExpert extends Expert {
    private static final String TAG = "MINE.facilities: ";
    public static final String name = "Facilities";
    private static HashMap<String, Boolean> criteria = null;

    FacilitiesExpert(Set<Park> allParks) {
        criteria = new HashMap<>(20);
        for (Park park : allParks) {
            for (String facility : park.getFacilityType()) {
                criteria.put(facility, false);
            }
        }
    }

    public FacilitiesExpert() {
        super();
    }

    @Override
    public void getMatchingParks(Set<Park> parkSet) {
        if (isCriteriaSet()) {
            Set<String> selected = new HashSet<>(criteria.size());
            for (String facility : criteria.keySet()) {
                if (criteria.get(facility)) {
                    selected.add(facility);
                }
            }
            HashSet<Park> temp = new HashSet<>(parkSet);
            for (Park park : temp) {
                if (!park.getFacilityType().containsAll(selected)) {
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
        setContentView(R.layout.activity_expert_facilities);
        LinearLayout content = (LinearLayout) findViewById(R.id.content_vertical);

        CheckBox chkBox;
        for (String facility : criteria.keySet()) {
            chkBox = new CheckBox(this);
            chkBox.setText(facility);
            chkBox.setChecked(criteria.get(facility));
            chkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox box = (CheckBox) v;
                    criteria.put(box.getText().toString(), box.isChecked());
                }
            });
            content.addView(chkBox);
        }
    }

}
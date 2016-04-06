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


public class ActivitiesExpert extends Expert {
    private static final String TAG = "MINE.activities: ";
    public static final String name = "Activities";
    private static HashMap<String, Boolean> criteria = null;

    ActivitiesExpert(Set<Park> allParks) {
        criteria = new HashMap<>(20);
        for (Park park : allParks) {
            for (String activity : park.getActivityTypes()) {
                criteria.put(activity, false);
            }
        }
    }

    public ActivitiesExpert() {
        super();
    }

    @Override
    public void getMatchingParks(Set<Park> parkSet) {
        if (isCriteriaSet()) {
            Set<String> selected = new HashSet<>(criteria.size());
            for (String activity : criteria.keySet()) {
                if (criteria.get(activity)) {
                    selected.add(activity);
                }
            }
            HashSet<Park> temp = new HashSet<>(parkSet);
            for (Park park : temp) {
                if (!park.getActivityTypes().containsAll(selected)) {
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
        setContentView(R.layout.activity_expert_activities);
        LinearLayout content = (LinearLayout) findViewById(R.id.content_vertical);
        CheckBox chkBox;
        for (String activity : criteria.keySet()) {
            chkBox = new CheckBox(this);
            chkBox.setText(activity);
            chkBox.setChecked(criteria.get(activity));
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
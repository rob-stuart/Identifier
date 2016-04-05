package com.sfwr.eng.a04.parkfinder.blackboard;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.sfwr.eng.a04.parkfinder.R;
import com.sfwr.eng.a04.parkfinder.parks.Park;

import java.util.Set;

public class SizeExpert extends Expert {
    private static final String TAG = "MINE== ActivitiesExpert";
    private static final String name = "Size";
    private static int op = R.id.less_than;
    private static double small, large;
    private static boolean isCriteriaSet = false;

    public SizeExpert() {

    }

    @Override
    public void getMatchingParks(Set<Park> parkSet) {
        if (isCriteriaSet()) {
            for (Park park : parkSet) {
                switch (op) {
                    case R.id.less_than:
                        if (park.getSize() > small) {
                            parkSet.remove(park);
                        }
                        break;
                    case R.id.between:
                        if (park.getSize() < small || park.getSize() > large) {
                            parkSet.remove(park);
                        }
                        break;
                    case R.id.greater_than:
                        if (park.getSize() < large) {
                            parkSet.remove(park);
                        }
                        break;
                }
            }
        }
    }

    @Override
    public boolean isCriteriaSet() {
        return isCriteriaSet;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_size);

    }

    private boolean isParsable(String str) {
        return str.matches("[+-]?\\d*\\.\\d*");
    }

    public void onCriteriaSet(View view) {
        EditText size1 = (EditText) findViewById(R.id.editText_smaller);
        EditText size2 = (EditText) findViewById(R.id.editText_larger);

        switch (op) {
            case R.id.less_than:
                if (!isParsable(size1.getText().toString())) {
                    return;
                }
                small = Double.parseDouble(size1.getText().toString());
                isCriteriaSet = true;
                break;
            case R.id.between:
                if (!isParsable(size1.getText().toString()) || !isParsable(size2.getText().toString())) {
                    return;
                }
                small = Math.min(Double.parseDouble(size1.getText().toString()), Double.parseDouble(size2.getText().toString()));
                large = Math.max(Double.parseDouble(size1.getText().toString()), Double.parseDouble(size2.getText().toString()));
                isCriteriaSet = true;
                break;

            case R.id.greater_than:
                if (!isParsable(size2.getText().toString())) {
                    return;
                }
                large = Double.parseDouble(size2.getText().toString());
                isCriteriaSet = true;
                break;
        }

        finish();
    }

    public void onOpChosen(View view) {
        EditText smaller = (EditText) findViewById(R.id.editText_smaller);
        EditText greater = (EditText) findViewById(R.id.editText_larger);
        switch (view.getId()) {
            case R.id.less_than:
                op = R.id.less_than;
                smaller.findFocus();
                smaller.setFocusable(true);
                smaller.setFocusableInTouchMode(true);
                smaller.setClickable(true);

                greater.setFocusable(false);
                greater.setFocusableInTouchMode(false);
                greater.setClickable(false);
                break;
            case R.id.between:
                op = R.id.between;
                smaller.findFocus();
                smaller.setFocusable(true);
                smaller.setFocusableInTouchMode(true);
                smaller.setClickable(true);

                greater.setFocusable(true);
                greater.setFocusableInTouchMode(true);
                greater.setClickable(true);
                break;
            case R.id.greater_than:
                op = R.id.greater_than;
                smaller.setFocusable(false);
                smaller.setFocusableInTouchMode(false);
                smaller.setClickable(false);

                greater.findFocus();
                greater.setFocusable(true);
                greater.setFocusableInTouchMode(true);
                greater.setClickable(true);
                break;
        }
    }

}
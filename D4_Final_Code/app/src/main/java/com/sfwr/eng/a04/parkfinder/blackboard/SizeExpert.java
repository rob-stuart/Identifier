package com.sfwr.eng.a04.parkfinder.blackboard;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.sfwr.eng.a04.parkfinder.R;
import com.sfwr.eng.a04.parkfinder.parks.Park;

import java.util.HashSet;
import java.util.Set;

public class SizeExpert extends Expert {
    private static final String TAG = "MINE== ActivitiesExpert";
    public static final String name = "Size";
    private static int op = R.id.less_than;
    private static double small = 0, large = 0;
    private static boolean isCriteriaSet = false;

    public SizeExpert() {

    }

    @Override
    public void getMatchingParks(Set<Park> parkSet) {
        if (isCriteriaSet()) {
            HashSet<Park> temp = new HashSet<>(parkSet);
            for (Park park : temp) {
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
        ((EditText) findViewById(R.id.editText_smaller)).setText(String.valueOf(small));
        ((EditText) findViewById(R.id.editText_larger)).setText(String.valueOf(large));
        ((RadioButton) findViewById(op)).setChecked(true);
        setEditTexts(op);
    }

    private void setEditTexts(int oper) {
        EditText smaller = (EditText) findViewById(R.id.editText_smaller);
        EditText greater = (EditText) findViewById(R.id.editText_larger);
        switch (oper) {
            case R.id.less_than:
                smaller.setEnabled(true);
                greater.setEnabled(false);
                break;
            case R.id.between:
                smaller.setEnabled(true);
                greater.setEnabled(true);
                break;
            case R.id.greater_than:
                smaller.setEnabled(false);
                greater.setEnabled(true);
                break;
        }
    }

    public void onOpChosen(View view) {
        switch (view.getId()) {
            case R.id.less_than:
            case R.id.between:
            case R.id.greater_than:
                op = view.getId();
                setEditTexts(op);
                break;
            default:
                Log.d(TAG, "bad view.ID");
        }
    }

    private boolean isParsable(String str) {
        return str.matches("[+-]?\\d*\\.?\\d*");
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

}
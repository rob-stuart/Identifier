package com.sfwr.eng.a04.parkfinder.blackboard;

import android.view.View;

import com.sfwr.eng.a04.parkfinder.parks.Park;

import java.util.Set;

public class SizeExpert implements Expert {
    private String name = "Size";
    private String op;
    private double size1, size2;

    @Override
    public void getMatchingParks(Set<Park> parkSet) {
        //TODO
    }

    @Override
    public boolean isCriteriaSet() {
        //TODO
        return false;
    }

    @Override
    public String getName() {
        //TODO
        return null;
    }

    @Override
    public void setFinishListener(View.OnClickListener listener) {
        //TODO
    }

    @Override
    public void removeFinishListener(View.OnClickListener listener) {
        //TODO
    }

    @Override
    public void startNewCriteria() {
        //TODO
    }

    @Override
    public void modifyCriteria() {
        //TODO
    }
}

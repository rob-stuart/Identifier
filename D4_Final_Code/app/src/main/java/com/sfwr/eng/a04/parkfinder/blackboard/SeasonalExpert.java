package com.sfwr.eng.a04.parkfinder.blackboard;

import android.view.View;

import com.sfwr.eng.a04.parkfinder.parks.Park;

import java.util.Date;
import java.util.Set;

class SeasonalExpert implements Expert {
    private String name = "Seasons";
    private Date date;


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

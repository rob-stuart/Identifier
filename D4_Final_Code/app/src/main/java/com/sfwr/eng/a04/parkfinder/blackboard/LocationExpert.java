package com.sfwr.eng.a04.parkfinder.blackboard;

import android.view.View;

import com.google.android.gms.maps.model.LatLng;
import com.sfwr.eng.a04.parkfinder.parks.Park;

import java.util.Set;

class LocationExpert implements Expert {
    private String name = "Location";
    private LatLng loc;
    private double distanceTo;
    private int numParks;

    void getNearestParks(Set<Park> parkSet, int num) {
        //TODO
    }

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

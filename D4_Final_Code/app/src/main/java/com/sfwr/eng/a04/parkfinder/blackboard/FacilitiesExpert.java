package com.sfwr.eng.a04.parkfinder.blackboard;

import android.view.View;

import com.sfwr.eng.a04.parkfinder.parks.Pair;
import com.sfwr.eng.a04.parkfinder.parks.Park;

import java.util.HashSet;
import java.util.Set;

class FacilitiesExpert implements Expert {
    private String name = "Facilities";
    private Set<String> facilities;

    FacilitiesExpert(Set<Park> allParks) {
        facilities = new HashSet<>();
        for (Park park : allParks) {
            for (Pair<String, String> facility : park.getFacilityType()) {
                facilities.add(facility.getItem1());
            }
        }
        //TODO anything else?
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

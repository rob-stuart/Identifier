package com.a04.parkfinder.blackboard;

import android.view.View;

import com.a04.parkfinder.parks.Park;

import java.util.Set;

/**
 * Created by robert on 01-Apr-16.
 */
public class FacilitiesExpert  implements Expert{
    private String name = "Facilities";
    private Set<String> facilities;

    FacilitiesExpert(Set<Park> allParks){
        //TODO
    }

    @Override
    public void getMatchingParks(Set<Park> parkSet) {

    }

    @Override
    public boolean isCriteriaSet() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setFinishListener(View.OnClickListener listener) {

    }

    @Override
    public void removeFinishListener(View.OnClickListener listener) {

    }

    @Override
    public void startNewCriteria() {

    }

    @Override
    public void modifyCriteria() {

    }
}

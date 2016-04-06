package com.sfwr.eng.a04.parkfinder.blackboard;

import android.os.Bundle;

import com.sfwr.eng.a04.parkfinder.R;
import com.sfwr.eng.a04.parkfinder.parks.Location;
import com.sfwr.eng.a04.parkfinder.parks.Park;

import java.util.Set;

public class LocationExpert extends Expert {
    private static final String TAG = "MINE.location: ";
    public static final String name = "Location";
    private Location loc;
    private double distanceTo;
    private int numParks;

    public LocationExpert() {
        super();
        //TODO
    }

//    void getNearestParks(Set<Park> parkSet, int num) {
//        //TODO
//    }

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
        return name;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_facilities);
        //TODO
    }
}
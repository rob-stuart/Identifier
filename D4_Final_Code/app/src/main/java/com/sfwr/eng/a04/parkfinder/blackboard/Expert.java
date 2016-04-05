package com.sfwr.eng.a04.parkfinder.blackboard;

import android.app.Activity;

import com.sfwr.eng.a04.parkfinder.parks.Park;

import java.io.Serializable;
import java.util.Set;

abstract class Expert extends Activity implements Serializable {
    public String name;

    abstract void getMatchingParks(Set<Park> parkSet);

    abstract boolean isCriteriaSet();

    abstract String getName();

}

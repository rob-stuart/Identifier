package com.sfwr.eng.a04.parkfinder.blackboard;

import com.sfwr.eng.a04.parkfinder.parks.Park;

import java.util.Set;

/**
 * Created by robert on 01-Apr-16.
 */
interface Expert extends ExpertView{

    void getMatchingParks(Set<Park> parkSet);

    boolean isCriteriaSet();

    String getName();
}

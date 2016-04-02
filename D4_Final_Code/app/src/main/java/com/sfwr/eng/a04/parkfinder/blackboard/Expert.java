package com.sfwr.eng.a04.parkfinder.blackboard;

import com.sfwr.eng.a04.parkfinder.parks.Park;

import java.util.Set;

interface Expert extends ExpertView {

    void getMatchingParks(Set<Park> parkSet);

    boolean isCriteriaSet();

    String getName();
}

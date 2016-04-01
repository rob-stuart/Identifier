package com.a04.parkfinder.parks;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by robert on 01-Apr-16.
 */
public class ParkDataController {
    private HashSet<Park> parkSet;

    public ParkDataController(){
        //TODO initialize parkSet
    }

    public Set<Park> getParkSet(){
        return (HashSet) parkSet.clone();
    }

}

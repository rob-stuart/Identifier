package com.sfwr.eng.a04.parkfinder.parks;

/**
 * Created by robert on 01-Apr-16.
 */
public class Location {
    final private double lat;
    final private double log;

    public Location(double lat, double log){
        this.lat = lat;
        this.log = log;
    }

    public double getLatitude(){
        return lat;
    }

    public double getLongitude(){
        return log;
    }
}

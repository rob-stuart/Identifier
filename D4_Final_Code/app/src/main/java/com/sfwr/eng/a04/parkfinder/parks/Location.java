package com.sfwr.eng.a04.parkfinder.parks;

import java.io.Serializable;

public class Location implements Serializable {
    private final double lat, log;

    public Location(double lat, double log) {
        this.lat = lat;
        this.log = log;
    }

    public double getLatitude() {
        return lat;
    }

    public double getLongitude() {
        return log;
    }

}
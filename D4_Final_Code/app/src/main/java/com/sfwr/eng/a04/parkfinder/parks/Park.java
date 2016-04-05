package com.sfwr.eng.a04.parkfinder.parks;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Park implements Serializable {
    private final String name;
    private final double size;
    private final Location loc;
    private final Pair<Date, Date> openDateRange;
    private final String URL;
    private final List<Pair<String, String>> campTypes;
    private final List<Pair<String, String>> activityTypes;
    private final List<Pair<String, String>> facilityTypes;

    Park(String name, double size, Location loc, Pair<Date, Date> openDateRange, String URL) {
        this.name = name;
        this.size = size;
        this.loc = loc;
        this.openDateRange = openDateRange;
        this.URL = URL;
        campTypes = new ArrayList<Pair<String, String>>();
        activityTypes = new ArrayList<Pair<String, String>>();
        facilityTypes = new ArrayList<Pair<String, String>>();
    }

    void addCampType(String campType, String campDescription) {
        campTypes.add(new Pair<>(campType, campDescription));
    }

    void addActivity(String activityType, String activityDescription) {
        activityTypes.add(new Pair<>(activityType, activityDescription));
    }

    void addFacility(String facilityType, String facilityDescription) {
        facilityTypes.add(new Pair<>(facilityType, facilityDescription));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Park)) {
            return false;
        }
        Park that = (Park) obj;
        return this.name.equalsIgnoreCase(that.name);
        //TODO use more than name to park_data equality?
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public Location getLoc() {
        return loc;
    }

    public Pair<Date, Date> getOpenDateRange() {
        return openDateRange;
    }

    public String getURL() {
        return URL;
    }

    public Set<String> getCampTypes() {
        Set<String> types = new HashSet<>(campTypes.size() * 2);
        for (Pair<String, String> camp : campTypes) {
            types.add(camp.getItem1());
        }
        return types;
    }

    public Set<String> getActivityTypes() {
        Set<String> types = new HashSet<>(activityTypes.size() * 2);
        for (Pair<String, String> activity : activityTypes) {
            types.add(activity.getItem1());
        }
        return types;
    }

    public Set<String> getFacilityType() {
        Set<String> types = new HashSet<>(facilityTypes.size() * 2);
        for (Pair<String, String> facility : facilityTypes) {
            types.add(facility.getItem1());
        }
        return types;
    }

}

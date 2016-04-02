package com.sfwr.eng.a04.parkfinder.parks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by robert on 01-Apr-16.
 */
public class Park {
    private final String name;
    private final double size;
    private final Location loc;
    private final Pair<Date, Date> openDateRange;
    private final String URL;
    private final List<Pair<String, String>> campTypes;
    private final List<Pair<String, String>> activityTypes;
    private final List<Pair<String, String>> facilityTypes;

    public Park(String name, double size, Location loc, Pair<Date, Date> openDateRange, String URL) {
        this.name = name;
        this.size = size;
        this.loc = loc;
        this.openDateRange = openDateRange;
        this.URL = URL;
        campTypes = new ArrayList<Pair<String, String>>();
        activityTypes = new ArrayList<Pair<String, String>>();
        facilityTypes = new ArrayList<Pair<String, String>>();
    }

    public void addCampType(String campType, String campDescription) {
        campTypes.add(new Pair<>(campType, campDescription));
    }

    public void addActivity(String activityType, String activityDescription) {
        activityTypes.add(new Pair<>(activityType, activityDescription));
    }

    public void addFacility(String facilityType, String facilityDescription) {
        facilityTypes.add(new Pair<>(facilityType, facilityDescription));
    }

    public boolean isNameSame(Park that) {
        return this.name.equalsIgnoreCase(that.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Park)) {
            return false;
        }
        Park that = (Park) obj;
        return this.name.equalsIgnoreCase(that.name);
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

    public String getURL() {
        return URL;
    }

    public List<Pair<String, String>> getCampTypes() {
        return campTypes;
    }

    public List<Pair<String, String>> getActivityTypes() {
        return activityTypes;
    }

    public List<Pair<String, String>> getFacilityType() {
        return facilityTypes;
    }

    public Pair<Date, Date> getOpenDateRange() {
        return openDateRange;
    }
}

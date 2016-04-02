package com.sfwr.eng.a04.parkfinder.blackboard;

import android.content.Context;

import com.sfwr.eng.a04.parkfinder.parks.Park;
import com.sfwr.eng.a04.parkfinder.parks.ParkDataController;

import java.util.HashSet;
import java.util.Set;

public class BlackBoard {
    private Set<Expert> availableExperts;
    private ParkDataController parkData;

    public BlackBoard(Context context) {
        parkData = new ParkDataController(context);
        availableExperts = new HashSet<>();
        availableExperts.add(new ActivitiesExpert(parkData.getParkSet()));
        availableExperts.add(new CampingExpert(parkData.getParkSet()));
        availableExperts.add(new FacilitiesExpert(parkData.getParkSet()));
        availableExperts.add(new LocationExpert());
        availableExperts.add(new SeasonalExpert());
        availableExperts.add(new SizeExpert());
        //TODO initialize other stuff?
    }

    public Set<String> getAvailableExpertNames() {
        Set<String> names = new HashSet<>(availableExperts.size());
        for (Expert expert : availableExperts) {
            names.add(expert.getName());
        }
        return names;
    }

    public ExpertView getExpertView(String name) {
        assert (name != null);
        for (Expert expert : availableExperts) {
            if (name.equals(expert.getName())) {
                return (ExpertView) expert;
            }
        }
        return null;
    }

    public Set<Park> getMatchingParks() {
        Set<Park> allParks = parkData.getParkSet();
        Set<Park> parkSet;
        for (Expert expert : availableExperts) {
            if (expert.isCriteriaSet()) {
                parkSet = parkData.getParkSet();
                expert.getMatchingParks(parkSet);
                allParks.retainAll(parkSet);
            }
        }
        return allParks;
    }

    public Set<Park> getNearestParks(int num) {
        Set<Park> parkSet = null;
        for (Expert expert : availableExperts) {
            if (expert.getName().equals("LocationExpert")) {
                parkSet = parkData.getParkSet();
                ((LocationExpert) expert).getNearestParks(parkSet, num);
            }
        }
        return parkSet;
    }

}

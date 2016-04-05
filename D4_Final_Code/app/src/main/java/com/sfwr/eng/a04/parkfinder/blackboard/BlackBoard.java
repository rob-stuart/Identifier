package com.sfwr.eng.a04.parkfinder.blackboard;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sfwr.eng.a04.parkfinder.gui.SearchActivity;
import com.sfwr.eng.a04.parkfinder.parks.Park;
import com.sfwr.eng.a04.parkfinder.parks.ParkDataController;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class BlackBoard implements Serializable {
    private final static String TAG = "MINE== blackboard";
    private Set<Expert> availableExperts = null;
    private ParkDataController parkData = null;

    public BlackBoard(Context context) {
        Log.d(TAG, "init");
        parkData = new ParkDataController(context);
        availableExperts = new HashSet<>();
        availableExperts.add(new ActivitiesExpert(parkData.getParkSet()));
        availableExperts.add(new CampingExpert(parkData.getParkSet()));
        availableExperts.add(new FacilitiesExpert(parkData.getParkSet()));
//         availableExperts.add(new LocationExpert());
//         availableExperts.add(new SeasonalExpert());
        availableExperts.add(new SizeExpert());
    }


    public Set<String> getAvailableExpertNames() {
        Set<String> names = new HashSet<>(availableExperts.size());
        for (Expert expert : availableExperts) {
            names.add(expert.getName());
        }
        return names;
    }

    public void useExpert(Context context, String name) {
        for (Expert expert : availableExperts) {
            if (name.equals(expert.getName())) {
                Intent intent = new Intent(context, expert.getClass());
                context.startActivity(intent);

            }
        }
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
                break;
            }
        }
        return parkSet;
    }

}
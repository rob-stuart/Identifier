package com.sfwr.eng.a04.parkfinder.blackboard;

import android.content.Context;
import android.content.Intent;

import com.sfwr.eng.a04.parkfinder.parks.Park;
import com.sfwr.eng.a04.parkfinder.parks.ParkDataController;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class BlackBoard implements Serializable {
    private final static String TAG = "MINE.blackboard: ";
    public final static String ID = "blackboard";
    private Set<Expert> availableExperts = null;
    private ParkDataController parkData = null;

    public BlackBoard(Context context) {
        parkData = new ParkDataController(context);
        availableExperts = new HashSet<>();
        availableExperts.add(new ActivitiesExpert(parkData.getParkSet()));
        availableExperts.add(new CampingExpert(parkData.getParkSet()));
        availableExperts.add(new FacilitiesExpert(parkData.getParkSet()));
        availableExperts.add(new SizeExpert());
//         availableExperts.add(new LocationExpert());
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
        Set<Park> subParkSet;
        for (Expert expert : availableExperts) {
            if (expert.isCriteriaSet()) {
                subParkSet = parkData.getParkSet();
                expert.getMatchingParks(subParkSet);
                allParks.retainAll(subParkSet);
            }
        }
        return allParks;
    }

//    public Set<Park> getNearestParks(int num) {
//        Set<Park> parkSet = null;
//        for (Expert expert : availableExperts) {
//            if (expert.getName().equals("LocationExpert")) {
//                parkSet = parkData.getParkSet();
//                ((LocationExpert) expert).getNearestParks(parkSet, num);
//                break;
//            }
//        }
//        return parkSet;
//    }

}
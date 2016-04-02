package com.sfwr.eng.a04.parkfinder.gui;


import android.content.Context;

import com.sfwr.eng.a04.parkfinder.blackboard.BlackBoard;
import com.sfwr.eng.a04.parkfinder.blackboard.ExpertView;

import java.util.Set;

public class GuiController {
    private BlackBoard blackboard;

    protected GuiController(Context context) {
        blackboard = new BlackBoard(context);
        //TODO other stuff?
    }

    protected void startSearch() {
        //TODO
    }

    protected void viewAllParks() {
        //TODO
    }

    protected void mapNearestParks() {
        //TODO
    }

    protected ExpertView getExpertView(String name) {
        //TODO
        return null;
    }

    protected void goBack() {
        //TODO
    }

    protected void doSearch() {
        //TODO
    }

    protected void mapParks(Set<String> parkNames) {
        //TODO
    }

    protected void viewParkDetails(String name) {
        //TODO
    }

}

package com.example.walmartcodechallenge.model;


public class DisplayLocation {

    private String full;
    private String state;
    private String stateName;

    public DisplayLocation(String full, String state, String stateName) {
        this.full = full;
        this.state = state;
        this.stateName = stateName;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}

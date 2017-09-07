package com.example.walmartcodechallenge.model;


import com.google.gson.annotations.SerializedName;

public class ForecastCondition {

    private String displayTime;
    private String icon;
    private String condition;
    private String tempFarenheit;
    private String tempCelsius;
    private Temp temp;

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    @SerializedName("FCTTIME")
    private FactTime factTime;

    public FactTime getFactTime() {
        return factTime;
    }

    public void setFactTime(FactTime factTime) {
        this.factTime = factTime;
    }

    public String getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTempFarenheit() {
        return tempFarenheit;
    }

    public void setTempFarenheit(String tempFarenheit) {
        this.tempFarenheit = tempFarenheit;
    }

    public String getTempCelsius() {
        return tempCelsius;
    }

    public void setTempCelsius(String tempCelsius) {
        this.tempCelsius = tempCelsius;
    }
}

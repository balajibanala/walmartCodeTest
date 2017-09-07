package com.example.walmartcodechallenge.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherData {

  //(name = "current_observation")
    @SerializedName("current_observation")
  private CurrentObservation currentObservation;
  //(name = "hourly_forecast")
    @SerializedName("hourly_forecast")
  private List<ForecastCondition> forecastCondition;

  public void setCurrentObservation(CurrentObservation currentObservation) {
    this.currentObservation = currentObservation;
  }

    public List<ForecastCondition> getForecastCondition() {
        return forecastCondition;
    }

    public void setForecastCondition(List<ForecastCondition> forecastCondition) {
        this.forecastCondition = forecastCondition;
    }

    public CurrentObservation getCurrentObservation() {
    return currentObservation;
  }
}

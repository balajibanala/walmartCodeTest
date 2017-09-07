package com.example.walmartcodechallenge.model;

import com.google.gson.annotations.SerializedName;

public class CurrentObservation {

  //name = "display_location"
    @SerializedName("display_location")
  private DisplayLocation displayLocation;
  //name = "temp_f"
    @SerializedName("temp_f")
  private String farenheit;
  //name = "temp_c"
    @SerializedName("temp_c")
  private String celcius;
  //name = "weather"
  private String weather;
  //name = "icon"
  private String icon;

  public CurrentObservation(DisplayLocation displayLocation, String farenheit, String celcius, String weather, String icon) {
    this.displayLocation = displayLocation;
    this.farenheit = farenheit;
    this.celcius = celcius;
    this.weather = weather;
    this.icon = icon;
  }

  public DisplayLocation getDisplayLocation() {
    return displayLocation;
  }

  public void setDisplayLocation(DisplayLocation displayLocation) {
    this.displayLocation = displayLocation;
  }

  public String getFarenheit() {
    return farenheit;
  }

  public void setFarenheit(String farenheit) {
    this.farenheit = farenheit;
  }

  public String getCelcius() {
    return celcius;
  }

  public void setCelcius(String celcius) {
    this.celcius = celcius;
  }

  public String getWeather() {
    return weather;
  }

  public void setWeather(String weather) {
    this.weather = weather;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }
}

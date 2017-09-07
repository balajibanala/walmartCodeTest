package com.example.walmartcodechallenge;

import com.example.walmartcodechallenge.model.WeatherData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface RestAPI {

    @GET("api/{apiKey}/conditions/hourly/q/{zipCode}.json")
    Call<WeatherData> getAll(@Path("apiKey") String apiKey, @Path("zipCode") String zipCode);
}

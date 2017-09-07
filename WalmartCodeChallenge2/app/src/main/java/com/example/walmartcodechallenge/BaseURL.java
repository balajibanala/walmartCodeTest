package com.example.walmartcodechallenge;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseURL {


    public static RestAPI getAPI() {


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.wunderground.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        return retrofit.create(RestAPI.class);
}
}

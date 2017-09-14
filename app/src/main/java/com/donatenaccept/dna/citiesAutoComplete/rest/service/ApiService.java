package com.donatenaccept.dna.citiesAutoComplete.rest.service;


import com.donatenaccept.dna.citiesAutoComplete.rest.responses.PredictionResponse;

import java.util.Map;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


/**
 * Created by DAVID-WORK on 17/06/2015.
 */
public interface ApiService
{
    @GET("/place/autocomplete/json")
    void getPredictions(@QueryMap Map<String, String> options, Callback<PredictionResponse> callback);

    @GET("/place/autocomplete/json")
    PredictionResponse getPredictions(@QueryMap Map<String, String> options);
}

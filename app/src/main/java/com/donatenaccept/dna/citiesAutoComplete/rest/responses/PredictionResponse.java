package com.donatenaccept.dna.citiesAutoComplete.rest.responses;

import com.donatenaccept.dna.citiesAutoComplete.rest.model.Prediction;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by DAVID-WORK on 19/07/2015.
 */

@Parcel
public class PredictionResponse extends BaseResponse
{
    @SerializedName("predictions")
    public ArrayList<Prediction> mPredictionList;

    public ArrayList<Prediction> getPredictionList()
    {
        return mPredictionList;
    }

    @Override
    public String toString()
    {
        return "PredictionResponse{" +
                "mPredictionList=" + mPredictionList +
                "} " + super.toString();
    }
}

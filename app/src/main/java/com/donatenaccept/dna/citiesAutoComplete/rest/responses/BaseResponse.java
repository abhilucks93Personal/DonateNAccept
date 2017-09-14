package com.donatenaccept.dna.citiesAutoComplete.rest.responses;

import com.donatenaccept.dna.citiesAutoComplete.rest.ServerParams;
import com.google.gson.annotations.SerializedName;


import org.parceler.Parcel;


/**
 * Created by DAVID BELOOSESKY on 03/12/2014.
 */
@Parcel
public class BaseResponse
{
    @SerializedName("status")
    public String mStatus;

    @SerializedName("error_message")
    public String mErrorMessage;

    public String getStatus()
    {
        return mStatus;
    }

    public boolean isSucceeded()
    {
        if (mStatus.equals(ServerParams.STATUS_SUCCEEDED))
        {
            return true;
        }

        return false;
    }

    public boolean isFailure()
    {
        return !isSucceeded();
    }

    @Override
    public String toString()
    {
        return "BaseResponse{" +
                "mStatus='" + mStatus + '\'' +
                ", mErrorMessage='" + mErrorMessage + '\'' +
                '}';
    }
}

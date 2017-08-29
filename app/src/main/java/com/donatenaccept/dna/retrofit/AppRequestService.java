package com.donatenaccept.dna.retrofit;


import com.donatenaccept.dna.login.ModelRegistration;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * * Interface through which all the api calls will be performed
 */
public interface AppRequestService {


    @POST("userapi/")
    Observable<ModelResponseMain> signUpApi(@Body ModelRegistration modelVendorRegistration);


}


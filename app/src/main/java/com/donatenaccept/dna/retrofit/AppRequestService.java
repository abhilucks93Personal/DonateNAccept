package com.donatenaccept.dna.retrofit;


import com.donatenaccept.dna._history.ResponseModelBloodHistory;
import com.donatenaccept.dna._memories.ResponseModelAddMemory;
import com.donatenaccept.dna._memories.ResponseModelMemories;
import com.donatenaccept.dna._notifications.ResponseModelNotification;
import com.donatenaccept.dna.login.ModelRegistrationMain;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * * Interface through which all the api calls will be performed
 */
public interface AppRequestService {


    @FormUrlEncoded
    @POST("userapi/")
    Observable<ModelRegistrationMain> signUpApi(@Field("token") String token,
                                                @Field("methodname") String methodname,
                                                @Field("full_name") String full_name,
                                                @Field("user_mobile") String user_mobile,
                                                @Field("user_email") String user_email,
                                                @Field("password") String password,
                                                @Field("user_age") String user_age,
                                                @Field("user_blood_group_id") String user_blood_group_id,
                                                @Field("user_lat") String user_lat,
                                                @Field("user_long") String user_long,
                                                @Field("registration_type") String registration_type,
                                                @Field("device_type") String device_type,
                                                @Field("device_token") String device_token
    );

    @FormUrlEncoded
    @POST("userapi/")
    Observable<ModelRegistrationMain> loginApi(@Field("token") String token,
                                               @Field("methodname") String methodname,
                                               @Field("username") String username,
                                               @Field("password") String password,
                                               @Field("registration_type") String registration_type

    );


    @FormUrlEncoded
    @POST("userapi/")
    Observable<ResponseModelMemories> getMemoriesApi(@Field("token") String token,
                                                     @Field("methodname") String methodname,
                                                     @Field("userId") String userId);


    @FormUrlEncoded
    @POST("userapi/")
    Observable<ResponseModelAddMemory> addMemoriesApi(@Field("token") String token,
                                                      @Field("methodname") String methodname,
                                                      @Field("receiverId") String receiverId,
                                                      @Field("donorId") String donorId,
                                                      @Field("image") String image,
                                                      @Field("description") String description);

    @FormUrlEncoded
    @POST("userapi/")
    Observable<ResponseModelBloodHistory> getHistoryApi(@Field("token") String token,
                                                        @Field("methodname") String methodname,
                                                        @Field("userId") String userId);

    Observable<ResponseModelNotification> getNotificationsApi(@Field("token") String token,
                                                              @Field("methodname") String methodname,
                                                              @Field("userId") String userId);
}


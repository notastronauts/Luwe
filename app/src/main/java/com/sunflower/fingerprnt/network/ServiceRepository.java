package com.sunflower.fingerprnt.network;


import com.sunflower.fingerprnt.model.AuthorizationResponse;
import com.sunflower.fingerprnt.model.Credentials;
import com.sunflower.fingerprnt.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ServiceRepository {
    @Headers({
            "Content-Type: application/json",
            "X-Requested-With: XMLHttpRequest"
    })
    @POST("/api/login")
    Call<AuthorizationResponse> login(@Body Credentials credentials);

    @Headers({
            "Content-Type: application/json",
    })
    @GET("api/logout")
    Call<Void> logout(@Header("Authorization") String authorization);

    @Headers({
            "Content-Type: application/json",
    })
    @GET("api/user")
    Call<UserResponse> user(@Header("Authorization") String authorization);
}

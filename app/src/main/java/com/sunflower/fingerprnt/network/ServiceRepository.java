package com.sunflower.fingerprnt.network;


import com.sunflower.fingerprnt.model.AuthorizationResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface ServiceRepository {
    @Headers({
            "Accept: application/json",
            "User-Agent: FingerPrnt-web"
    })
    @GET("api/login")
    Call<AuthorizationResponse> login(@Header("Authorization") String authorization);
}

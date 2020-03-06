package com.sunflower.fingerprnt.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceClient {
    public static Retrofit.Builder builder = new Retrofit.Builder();
    public static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();
    public static ServiceRepository buildServiceClient() {
        return builder.baseUrl("http://192.168.100.49:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(ServiceRepository.class);
    }
}

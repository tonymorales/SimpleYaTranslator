package com.example.tony_.simpleyatranslator.network;


import android.app.Application;

import com.example.tony_.simpleyatranslator.AppConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkServiceGenerator extends Application{

    private static IRestApi api;



    @Override
    public void onCreate() {
        super.onCreate();


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging);


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppConfig.BASE_URL)
                .client(httpClient.build())
                .build();

        api = retrofit.create(IRestApi.class);
    }

    public static IRestApi getApi(){
        return api;
    }
}

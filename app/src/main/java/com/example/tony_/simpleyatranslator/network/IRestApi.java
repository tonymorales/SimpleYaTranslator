package com.example.tony_.simpleyatranslator.network;


import com.example.tony_.simpleyatranslator.network.response.TranslatedText;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRestApi {

    @GET("translate")
    Call<TranslatedText>getTranslate(@Query("key") String apiKey, @Query("text") String text, @Query("lang") String lang, @Query("format") String textFormat);
}

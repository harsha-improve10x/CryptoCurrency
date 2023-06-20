package com.example.cryptocurrency;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinApi {

    public CoinService createCoinService() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.COIN_BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        CoinService coinService = retrofit.create(CoinService.class);
        return coinService;
    }
}

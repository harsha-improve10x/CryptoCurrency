package com.example.cryptocurrency;

import com.example.cryptocurrency.modelclass.Coin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinService {

    @GET(Constants.COIN_END_POINT)
    Call<List<Coin>> getCoins();
}

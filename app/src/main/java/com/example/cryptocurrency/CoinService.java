package com.example.cryptocurrency;

import com.example.cryptocurrency.modelclass.Coin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoinService {

    @GET(Constants.COIN_END_POINT)
    Call<List<Coin>> getCoins();

    @GET(Constants.COIN_END_POINT + "/{coinId}")
    Call<CoinName> getCoinName(@Path("coinId") String coinId);
}

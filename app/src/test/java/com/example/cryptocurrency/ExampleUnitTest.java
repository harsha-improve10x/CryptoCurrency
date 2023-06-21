package com.example.cryptocurrency;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cryptocurrency.modelclass.coinname.CoinName;
import com.example.cryptocurrency.modelclass.Coin;
import com.example.cryptocurrency.network.CoinApi;
import com.example.cryptocurrency.network.CoinService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getCoins() throws IOException {
        CoinService coinService = new CoinApi().createCoinService();
        Call<List<Coin>> call = coinService.getCoins();
        List<Coin> coins = call.execute().body();
        assertNotNull(coins);
        assertFalse(coins.isEmpty());
        System.out.println(new Gson().toJson(coins));
    }

    @Test
    public void getCoinId() throws IOException {
        CoinService coinService = new CoinApi().createCoinService();
        Call<CoinName> call = coinService.getCoinName("btc-bitcoin");
        CoinName coinName = call.execute().body();
        assertNotNull(coinName);
        System.out.println(new Gson().toJson(coinName));
    }
}
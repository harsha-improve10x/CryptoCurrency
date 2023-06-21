package com.example.cryptocurrency.coin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cryptocurrency.coinsdetail.CoinDetailsActivity;
import com.example.cryptocurrency.Constants;
import com.example.cryptocurrency.network.CoinApi;
import com.example.cryptocurrency.network.CoinService;
import com.example.cryptocurrency.databinding.ActivityCoinsBinding;
import com.example.cryptocurrency.modelclass.Coin;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinsActivity extends AppCompatActivity {

    private ActivityCoinsBinding coinsBinding;
    private CoinAdapter coinAdapter;
    private ArrayList<Coin> coins = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        coinsBinding = ActivityCoinsBinding.inflate(getLayoutInflater());
        setContentView(coinsBinding.getRoot());
        getCoins();
        setUpAdapter();
        setUpCoinsRv();
    }

    private void setUpCoinsRv() {
        coinsBinding.coinsRv.setLayoutManager(new LinearLayoutManager(this));
        coinsBinding.coinsRv.setAdapter(coinAdapter);
    }

    private void setUpAdapter() {
        coinAdapter = new CoinAdapter();
        coinAdapter.setCoins(coins);
        coinAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClicked(String coinId) {
                Intent intent = new Intent(CoinsActivity.this, CoinDetailsActivity.class);
                intent.putExtra(Constants.KEY_COIN_VALUE, coinId);
                startActivity(intent);
            }
        });
    }

    private void getCoins() {
        CoinApi coinApi = new CoinApi();
        CoinService coinService = coinApi.createCoinService();
        Call<List<Coin>> call = coinService.getCoins();
        call.enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CoinsActivity.this, "Successfully fetched the data", Toast.LENGTH_SHORT).show();
                    List<Coin> coinList = response.body();
                    coinAdapter.setCoins(coinList);
                }
            }

            @Override
            public void onFailure(Call<List<Coin>> call, Throwable t) {
                Toast.makeText(CoinsActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
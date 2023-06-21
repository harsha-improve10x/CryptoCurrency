package com.example.cryptocurrency.coinsdetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cryptocurrency.Constants;
import com.example.cryptocurrency.databinding.ActivityCoinDetailsBinding;
import com.example.cryptocurrency.modelclass.coinname.CoinName;
import com.example.cryptocurrency.modelclass.coinname.Tags;
import com.example.cryptocurrency.modelclass.coinname.Team;
import com.example.cryptocurrency.network.CoinApi;
import com.example.cryptocurrency.network.CoinService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinDetailsActivity extends AppCompatActivity {

    private ArrayList<Tags> tags = new ArrayList<>();
    private ArrayList<Team> teams = new ArrayList<>();
    private TagAdapter tagAdapter;
    private TeamMemberAdapter teamMemberAdapter;
    private ActivityCoinDetailsBinding activityCoinDetailsBinding;
    private String coinId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCoinDetailsBinding = ActivityCoinDetailsBinding.inflate(getLayoutInflater());
        setContentView(activityCoinDetailsBinding.getRoot());
        if (getIntent().hasExtra(Constants.KEY_COIN_VALUE)) {
            coinId = getIntent().getStringExtra(Constants.KEY_COIN_VALUE);
            getCoinDetails();
            setupAdapter();
            setupRv();
        }
    }

    private void setupAdapter() {
        tagAdapter = new TagAdapter();
        tagAdapter.setTagsArrayList(tags);
        teamMemberAdapter = new TeamMemberAdapter();
        teamMemberAdapter.setTeams(teams);
    }

    private void setupRv() {
        activityCoinDetailsBinding.tagsRv.setLayoutManager(new GridLayoutManager(this, 3));
        activityCoinDetailsBinding.tagsRv.setAdapter(tagAdapter);
        activityCoinDetailsBinding.teamMembersRv.setLayoutManager(new LinearLayoutManager(this));
        activityCoinDetailsBinding.teamMembersRv.setAdapter(teamMemberAdapter);
    }

    private void getCoinDetails() {
        CoinApi coinApi = new CoinApi();
        CoinService coinService = coinApi.createCoinService();
        Call<CoinName> call = coinService.getCoinName(coinId);
        call.enqueue(new Callback<CoinName>() {
            @Override
            public void onResponse(Call<CoinName> call, Response<CoinName> response) {
                if (response.isSuccessful()) {
                    CoinName coinName = response.body();
                    activityCoinDetailsBinding.setCoinDetails(coinName);
                    tagAdapter.setTagsArrayList(coinName.getTags());
                    teamMemberAdapter.setTeams(coinName.getTeam());
                    Toast.makeText(CoinDetailsActivity.this, "Successfully loaded data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CoinName> call, Throwable t) {
                Toast.makeText(CoinDetailsActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
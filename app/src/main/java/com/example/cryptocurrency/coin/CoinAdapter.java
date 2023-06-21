package com.example.cryptocurrency.coin;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.OnItemActionListener;
import com.example.cryptocurrency.coin.CoinsViewHolder;
import com.example.cryptocurrency.databinding.CoinItemLayoutBinding;
import com.example.cryptocurrency.modelclass.Coin;

import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<CoinsViewHolder> {
    private List<Coin> coins;
    private OnItemActionListener onItemActionListener;

    public void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CoinsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CoinItemLayoutBinding coinItemLayoutBinding = CoinItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CoinsViewHolder coinsViewHolder = new CoinsViewHolder(coinItemLayoutBinding);
        return coinsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoinsViewHolder holder, int position) {
        Coin coin = coins.get(position);
        holder.coinItemLayoutBinding.setCoin(coin);
        holder.coinItemLayoutBinding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClicked(coin.getId());
        });
    }

    @Override
    public int getItemCount() {
        return coins.size();
    }
}

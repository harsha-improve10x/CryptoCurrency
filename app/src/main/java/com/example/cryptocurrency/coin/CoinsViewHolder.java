package com.example.cryptocurrency.coin;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.databinding.CoinItemLayoutBinding;

public class CoinsViewHolder extends RecyclerView.ViewHolder {
    CoinItemLayoutBinding coinItemLayoutBinding;
    public CoinsViewHolder(@NonNull CoinItemLayoutBinding coinItemLayoutBinding) {
        super(coinItemLayoutBinding.getRoot());
        this.coinItemLayoutBinding = coinItemLayoutBinding;
    }
}

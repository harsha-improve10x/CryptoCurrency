package com.example.cryptocurrency.coinsdetail;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.databinding.TeammemberItemLayoutBinding;

public class TeamMemberViewHolder extends RecyclerView.ViewHolder {
    protected TeammemberItemLayoutBinding teammemberItemLayoutBinding;

    public TeamMemberViewHolder(@NonNull TeammemberItemLayoutBinding teammemberItemLayoutBinding) {
        super(teammemberItemLayoutBinding.getRoot());
        this.teammemberItemLayoutBinding = teammemberItemLayoutBinding;
    }
}

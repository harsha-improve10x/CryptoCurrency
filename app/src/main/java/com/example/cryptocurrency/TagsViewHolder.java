package com.example.cryptocurrency;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.databinding.ActivityCoinDetailsBinding;
import com.example.cryptocurrency.databinding.TagsItemLayoutBinding;

public class TagsViewHolder extends RecyclerView.ViewHolder {
    protected TagsItemLayoutBinding tagsItemLayoutBinding;

    public TagsViewHolder(@NonNull TagsItemLayoutBinding tagsItemLayoutBinding) {
        super(tagsItemLayoutBinding.getRoot());
        this.tagsItemLayoutBinding = tagsItemLayoutBinding;
    }
}

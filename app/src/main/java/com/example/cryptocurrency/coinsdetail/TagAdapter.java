package com.example.cryptocurrency.coinsdetail;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.databinding.TagsItemLayoutBinding;
import com.example.cryptocurrency.modelclass.coinname.Tags;

import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagsViewHolder> {
    private List<Tags> tagsArrayList;

    public void setTagsArrayList(List<Tags> tagsArrayList) {
        this.tagsArrayList = tagsArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TagsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TagsItemLayoutBinding tagsItemLayoutBinding = TagsItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        TagsViewHolder tagsViewHolder = new TagsViewHolder(tagsItemLayoutBinding);
        return tagsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TagsViewHolder holder, int position) {
        Tags tags = tagsArrayList.get(position);
        holder.tagsItemLayoutBinding.setTags(tags);
    }

    @Override
    public int getItemCount() {
        return tagsArrayList.size();
    }
}

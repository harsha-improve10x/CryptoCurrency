package com.example.cryptocurrency;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.databinding.TeammemberItemLayoutBinding;
import com.example.cryptocurrency.modelclass.coinname.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamMemberAdapter extends RecyclerView.Adapter<TeamMemberViewHolder> {
    private List<Team> teams;

    public void setTeams(List<Team> teams) {
        this.teams = teams;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TeamMemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TeammemberItemLayoutBinding teammemberItemLayoutBinding = TeammemberItemLayoutBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        TeamMemberViewHolder teamMemberViewHolder = new TeamMemberViewHolder(teammemberItemLayoutBinding);
        return teamMemberViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamMemberViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.teammemberItemLayoutBinding.setTeamMember(team);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }
}

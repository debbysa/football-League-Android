package com.debbysa.footballleageproject.model.teams;

import com.debbysa.footballleageproject.model.competitions.Competition;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Teams {

    @SerializedName("count")
    @Expose
    private Integer countTeams;

    @SerializedName("competition")
    @Expose
    private Competition teamCompetition;

    @SerializedName("teams")
    @Expose
    private List<Team> teamList;

    public Integer getCountTeams() {
        return countTeams;
    }

    public Competition getTeamCompetition() {
        return teamCompetition;
    }

    public List<Team> getTeamList() {
        return teamList;
    }
}


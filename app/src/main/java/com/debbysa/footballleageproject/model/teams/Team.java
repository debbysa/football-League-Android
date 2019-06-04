package com.debbysa.footballleageproject.model.teams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Team {
    @SerializedName("id")
    @Expose
    private Integer teamId;

    @SerializedName("name")
    @Expose
    private String teamName;

    @SerializedName("crestUrl")
    @Expose
    private String teamLogo;

    @SerializedName("squad")
    @Expose
    private List<Squad> squadList;

    public Integer getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public List<Squad> getSquadList() {
        return squadList;
    }
}

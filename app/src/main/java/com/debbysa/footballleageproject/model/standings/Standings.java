package com.debbysa.footballleageproject.model.standings;

import com.debbysa.footballleageproject.model.competitions.Competition;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Standings {

    @SerializedName("competition")
    @Expose
    private Competition standingCompetition;

    @SerializedName("standings")
    @Expose
    private List<Standing> standingList;

    public Competition getStandingCompetition() {
        return standingCompetition;
    }

    public List<Standing> getStandingList() {
        return standingList;
    }
}


package com.debbysa.footballleageproject.model.competitions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Competitions {

    @SerializedName("count")
    @Expose
    private Integer countCompetitions;

    @SerializedName("competitions")
    @Expose
    private List<Competition> competitionList;

    public Integer getCountCompetitions() {
        return countCompetitions;
    }

    public List<Competition> getCompetitionList() {
        return competitionList;
    }
}

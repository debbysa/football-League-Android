package com.debbysa.footballleageproject.model.matches;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Matches {

    @SerializedName("count")
    @Expose
    private Integer countMatches;

    @SerializedName("matches")
    @Expose
    private List<Match> matchList;

    public Integer getCountMatches() {
        return countMatches;
    }

    public List<Match> getMatchList() {
        return matchList;
    }
}

package com.debbysa.footballleageproject.model.matches;

import com.debbysa.footballleageproject.model.AwayTeam;
import com.debbysa.footballleageproject.model.HomeTeam;
import com.debbysa.footballleageproject.model.competitions.Competition;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match {

    @SerializedName("id")
    @Expose
    private Integer matchId;

    @SerializedName("competition")
    @Expose
    private Competition matchCompetition;

    @SerializedName("utcDate")
    @Expose
    private String matchDate;

    @SerializedName("status")
    @Expose
    private String matchStatus;


    @SerializedName("homeTeam")
    @Expose
    private HomeTeam matchHomeTeam;

    @SerializedName("awayTeam")
    @Expose
    private AwayTeam matchAwayTeam;


    public Integer getMatchId() {
        return matchId;
    }

    public Competition getMatchCompetition() {
        return matchCompetition;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getMatchStatus() {
        return matchStatus;
    }


    public HomeTeam getMatchHomeTeam() {
        return matchHomeTeam;
    }

    public AwayTeam getMatchAwayTeam() {
        return matchAwayTeam;
    }

}

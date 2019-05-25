package com.debbysa.footballleageproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Score {

    @SerializedName("fullTime")
    @Expose
    private FullTime fullTime;

    public FullTime getFullTime() {
        return fullTime;
    }
}

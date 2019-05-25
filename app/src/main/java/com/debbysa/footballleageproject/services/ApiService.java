package com.debbysa.footballleageproject.services;

import com.debbysa.footballleageproject.generator.ServiceGenerator;
import com.debbysa.footballleageproject.model.Competitions;
import com.debbysa.footballleageproject.model.Matches;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiService {
    @Headers(ServiceGenerator.BASE_KEY)
    @GET("/v2/competitions")
    Call<Competitions> getCompetitions();

    @Headers(ServiceGenerator.BASE_KEY)
    @GET("/v2/matches")
    Call<Matches> getFixtures();

    @Headers(ServiceGenerator.BASE_KEY)
    @GET("/v2/competitions/{id}/matches")
    Call<Matches> getMatches(@Path("id") int id);

}
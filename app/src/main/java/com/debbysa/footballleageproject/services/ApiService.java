package com.debbysa.footballleageproject.services;

import com.debbysa.footballleageproject.generator.ServiceGenerator;
import com.debbysa.footballleageproject.model.competitions.Competitions;
import com.debbysa.footballleageproject.model.matches.Matches;
import com.debbysa.footballleageproject.model.standings.Standings;
import com.debbysa.footballleageproject.model.teams.Team;
import com.debbysa.footballleageproject.model.teams.Teams;

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
    @GET("/v2/competitions/{id}/standings")
    Call<Standings> getStandings(@Path("id") int id);

    @Headers(ServiceGenerator.BASE_KEY)
    @GET("/v2/competitions/{id}/teams")
    Call<Teams> getTeams(@Path("id") int id);

    @Headers(ServiceGenerator.BASE_KEY)
    @GET("/v2/teams/{id}")
    Call<Team> getPlayers(@Path("id") int id);

}
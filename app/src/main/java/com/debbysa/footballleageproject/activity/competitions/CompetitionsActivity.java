package com.debbysa.footballleageproject.activity.competitions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.debbysa.footballleageproject.R;
import com.debbysa.footballleageproject.adapter.CompetitionsAdapter;
import com.debbysa.footballleageproject.fragments.ListItemClickListener;
import com.debbysa.footballleageproject.model.competitions.Competition;
import com.debbysa.footballleageproject.model.competitions.Competitions;
import com.debbysa.footballleageproject.services.ApiClient;
import com.debbysa.footballleageproject.services.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompetitionsActivity extends Fragment implements ListItemClickListener {

    private static final String LOG_TAG = CompetitionsActivity.class.getSimpleName();
    private List<Competition> competitionList;
//    private EditText search;

    public CompetitionsActivity() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_competitions, container, false);

        Log.d(LOG_TAG, LOG_TAG + " ACTIVE");

        RecyclerView list = view.findViewById(R.id.list_competitions);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        list.setLayoutManager(layoutManager);
        list.setHasFixedSize(true);
        list.setItemAnimator(new DefaultItemAnimator());

        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<Competitions> call = apiService.getCompetitions();
        call.enqueue(new Callback<Competitions>() {
            @Override
            public void onResponse(@NonNull Call<Competitions> call, @NonNull final Response<Competitions> response) {
                if (!response.isSuccessful()) {
                    Log.e(LOG_TAG, "FAILED CONNECTION ");
                    return;
                }

                Log.d(LOG_TAG, "SUCCESSFUL CONNECTION ");

                final Competitions res = response.body();

                if (res != null) {
                    competitionList = new ArrayList<>(res.getCompetitionList());
                    Log.d(LOG_TAG, "competitionList:" + competitionList.size());

                    CompetitionsAdapter adapter = new CompetitionsAdapter(competitionList, CompetitionsActivity.this);
                    list.setAdapter(adapter);

                    DividerItemDecoration divider = new DividerItemDecoration(list.getContext(), layoutManager.getOrientation());
                    list.addItemDecoration(divider);
                } else {
                    Log.w(LOG_TAG, "RESPONSE IS NULL!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Competitions> call, @NonNull Throwable t) {
                try {
                    Log.e(LOG_TAG, "QUERY FAILED: ");
                    throw t;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });

        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex, int clickedItemId, String clickedItemName) {

        Intent intent = new Intent(this.getActivity(), CompetitionActivity.class);
        intent.putExtra("competitionId", clickedItemId);
        intent.putExtra("competitionName", clickedItemName);
        startActivity(intent);
    }

}



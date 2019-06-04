package com.debbysa.footballleageproject.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.debbysa.footballleageproject.R;
import com.debbysa.footballleageproject.adapter.MatchesAdapter;
import com.debbysa.footballleageproject.fragments.ListItemClickListener;
import com.debbysa.footballleageproject.model.matches.Match;
import com.debbysa.footballleageproject.model.matches.Matches;
import com.debbysa.footballleageproject.services.ApiClient;
import com.debbysa.footballleageproject.services.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FixturesActivity extends Fragment implements ListItemClickListener {

    private static final String LOG_TAG = FixturesActivity.class.getSimpleName();
    private List<Match> matchList;
    private List<Match> filteredMatchList;
    RecyclerView recyclerView;
//    EditText txt_search;

    public FixturesActivity() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_fixtures, container, false);

        Log.d(LOG_TAG, LOG_TAG + " ACTIVE");

        recyclerView = view.findViewById(R.id.list_fixtures);
//        txt_search = view.findViewById(R.id.txt_search);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

//        txt_search.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                search(s.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<Matches> call = apiService.getFixtures();
        call.enqueue(new Callback<Matches>() {
            @Override
            public void onResponse(@NonNull Call<Matches> call, @NonNull final Response<Matches> response) {
                if (!response.isSuccessful()) {
                    Log.e(LOG_TAG, "FAILED CONNECTION : ");
                    return;
                }


                final Matches res = response.body();

                if (res != null) {

                    matchList = new ArrayList<>(res.getMatchList());
                    Log.d(LOG_TAG, "matchList:" + matchList.size());

                    MatchesAdapter adapter = new MatchesAdapter(matchList, FixturesActivity.this);
                    recyclerView.setAdapter(adapter);

                    DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
                    recyclerView.addItemDecoration(divider);
                } else {
                    Log.w(LOG_TAG, "RESPONSE null!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Matches> call, @NonNull Throwable t) {
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
        Toast.makeText(this.getActivity(), "item clicked", Toast.LENGTH_LONG).show();
    }

    @TargetApi(Build.VERSION_CODES.N)
    public void search(String query) {
        filteredMatchList = matchList;
        filteredMatchList.removeIf(match -> !match.getMatchHomeTeam().getHomeTeamName().contains(query));

        MatchesAdapter adapter = new MatchesAdapter(filteredMatchList, FixturesActivity.this);
        recyclerView.setAdapter(adapter);
    }
}
package com.debbysa.footballleageproject.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.debbysa.footballleageproject.R;
import com.debbysa.footballleageproject.activity.competitions.CompetitionsActivity;
import com.debbysa.footballleageproject.generator.ServiceGenerator;
import com.debbysa.footballleageproject.services.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar toolbar = getSupportActionBar();

        final int navCompetitions = R.id.navigation_competitions;
        final int navFixtures = R.id.navigation_fixtures;

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                int id = item.getItemId();
                assert toolbar != null;

                switch (id) {
                    case navCompetitions:
                        Toast.makeText(MainActivity.this, "Competitions clicked!",Toast.LENGTH_SHORT).show();
                        toolbar.setTitle(R.string.navigation_competitions);
                        fragment = new CompetitionsActivity();
                        loadFragment(fragment);
                        break;
                    case navFixtures:
                    default:
                        Toast.makeText(MainActivity.this, "Match clicked!",Toast.LENGTH_SHORT).show();
                        toolbar.setTitle(R.string.navigation_fixtures);
                        fragment = new FixturesActivity();
                        loadFragment(fragment);
                        break;
                }
                return true;
            }
        });
        bottomNavigation.setSelectedItemId(navFixtures);
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        return true;
    }

}

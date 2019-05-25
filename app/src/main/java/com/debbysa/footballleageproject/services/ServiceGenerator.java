package com.debbysa.footballleageproject.services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ServiceGenerator {
    public static final String BASE_URL = "https://api.football-data.org";
    public static final String BASE_KEY = "X-Auth-Token: d1ba213481124ac484aba62428f9f60b";
    private static ServiceGenerator instance = new ServiceGenerator();
    private static Context context;

    public static ServiceGenerator getInstance(Context c) {
        context = c.getApplicationContext();
        return instance;
    }

    public boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }
}

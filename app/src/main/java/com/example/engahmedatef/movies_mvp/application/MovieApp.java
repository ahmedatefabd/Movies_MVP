package com.example.engahmedatef.movies_mvp.application;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.appizona.yehiahd.fastsave.FastSave;

public class MovieApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidNetworking.initialize(getApplicationContext());
        FastSave.init(getApplicationContext());
    }
}

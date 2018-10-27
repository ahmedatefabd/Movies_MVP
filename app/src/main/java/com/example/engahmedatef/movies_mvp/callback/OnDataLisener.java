package com.example.engahmedatef.movies_mvp.callback;

import com.example.engahmedatef.movies_mvp.data.local_data.Movie;

import java.util.List;

public interface OnDataLisener {

    void onSucess(List<Movie> movieList);

    void onError(String errorMsg);
}

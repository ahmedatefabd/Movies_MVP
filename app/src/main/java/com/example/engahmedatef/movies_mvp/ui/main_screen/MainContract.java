package com.example.engahmedatef.movies_mvp.ui.main_screen;

import com.example.engahmedatef.movies_mvp.data.local_data.Movie;

import java.util.List;

public interface MainContract {

    interface Presenter {
        void detachView();
    }

    interface View {

        void displayError(String msg);

        void displayData(List<Movie> movies);

    }
}

package com.example.engahmedatef.movies_mvp.ui.main_screen;

import com.example.engahmedatef.movies_mvp.callback.CB_OnDataLisener;
import com.example.engahmedatef.movies_mvp.data.local_data.Movie;
import com.example.engahmedatef.movies_mvp.data.remote_data.ApiModel;
import com.example.engahmedatef.movies_mvp.ui.base_screen.BasePresenter;

import java.util.List;

public class MainPresenter extends BasePresenter implements MainContract.Presenter {

    private MainContract.View view; // dependency for interface MainContract.View
    private ApiModel apiModel;

    public MainPresenter(MainContract.View view) // Injection or inject for interface MainContract.View
    {
        this.view = view;
        apiModel = new ApiModel();
    }

    public void getDataMainPresenter( String type){
        apiModel.getMovies(type, new CB_OnDataLisener() {
            @Override
            public void onSucess(List<Movie> movieList) {
                view.displayData(movieList);
            }

            @Override
            public void onError(String errorMsg) {
                view.displayError(errorMsg);

            }
        });

    }



    @Override
    public void detachView() {

        view = null;

    }
}

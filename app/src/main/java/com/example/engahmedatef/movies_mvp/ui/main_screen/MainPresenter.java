package com.example.engahmedatef.movies_mvp.ui.main_screen;

import android.view.View;
import android.widget.ProgressBar;

import com.example.engahmedatef.movies_mvp.R;
import com.example.engahmedatef.movies_mvp.callback.OnDataLisener;
import com.example.engahmedatef.movies_mvp.data.local_data.Movie;
import com.example.engahmedatef.movies_mvp.data.remote_data.ApiModel;
import com.example.engahmedatef.movies_mvp.ui.base_screen.BasePresenter;
import com.example.engahmedatef.movies_mvp.util.Constant;

import java.util.List;

public class MainPresenter extends BasePresenter implements MainContract.Presenter {

    private MainContract.View view;
    private ApiModel apiModel;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        apiModel = new ApiModel();
    }

    public void getDataMainPresenter( String type){
        apiModel.getMovies(type, new OnDataLisener() {
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

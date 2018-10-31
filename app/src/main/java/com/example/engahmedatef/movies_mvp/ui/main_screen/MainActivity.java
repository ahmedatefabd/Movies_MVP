package com.example.engahmedatef.movies_mvp.ui.main_screen;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.engahmedatef.movies_mvp.Adapter.MovieAdapter;
import com.example.engahmedatef.movies_mvp.R;
import com.example.engahmedatef.movies_mvp.data.local_data.Movie;
import com.example.engahmedatef.movies_mvp.ui.base_screen.BaseActivity;
import com.example.engahmedatef.movies_mvp.util.Connection;
import com.example.engahmedatef.movies_mvp.util.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View {

    private MainPresenter presenter ;
    private MovieAdapter adapter ;

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this); // dependency

        presenter.getDataMainPresenter(Constant.Api.POPULAR_MOVIES_KEY);
    }


    @Override
    public void displayData(List<Movie> movies) {

        recycler(movies);

    }

    @Override
    public void displayError(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    private void recycler(List<Movie> movies) {

        adapter = new MovieAdapter(MainActivity.this, movies);
        recycler.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        recycler.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.popular:
                presenter.getDataMainPresenter(Constant.Api.POPULAR_MOVIES_KEY);// Method download Movies by Library-->Fastnetwark
//                return true;
                break;

            case R.id.top_rated:

                presenter.getDataMainPresenter(Constant.Api.TOP_RATED_MOVIES_KEY);// Method download Movies by Library-->Fastnetwark

                break;


        }
        return super.onOptionsItemSelected(item);

    }


}

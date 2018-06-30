package com.plusultra.flicksmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.plusultra.flicksmovies.models.Movie;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailsActivity extends AppCompatActivity {

    //the movie to display
    Movie movie;

    @BindView(R.id.tvTitle) TextView getTvTitle;
    @BindView(R.id.tvOverview) TextView getTvOverview;
    @BindView(R.id.rbVoteAverage) RatingBar getRbVoteAverage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);
        //unwrap the movie passed in via intent, using its simple name as a key
        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));

        getTvTitle.setText(movie.getTitle());
        getTvOverview.setText(movie.getOverview());

        float voteAverage = (float) movie.getVoteAverage();
        getRbVoteAverage.setRating(voteAverage = voteAverage > 0 ? voteAverage / 2.0f : voteAverage);
    }
}
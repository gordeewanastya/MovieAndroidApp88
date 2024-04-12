package com.example.movieapplication.activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.movieapplication.R;
import com.example.movieapplication.adapters.ActorsListAdapter;
import com.example.movieapplication.adapters.CategoryEachFilmListAdapter;
import com.example.movieapplication.domain.Film;
import com.example.movieapplication.domain.FilmItem;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private ProgressBar progressBar;
    private TextView titleTxt,movieRateTxt,movieTimeTxt,movieSummary,movieActorsInfo;
    private int idFilm;
    private ImageView pic2,backImg;
    private RecyclerView.Adapter adapterActorList,adapterCategory;
    private RecyclerView recyclerViewActors, recyclerViewCategory;
    private NestedScrollView scrollView;
    ArrayList<Film> films = new ArrayList<Film>(
            Arrays.asList(
                    new Film(1, "The Avengers", R.drawable.poster2, 8.4f, 143, "Earth's mightiest heroes must come together and learn to fight as" +
                            " a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.",
                            "Robert Downey Jr., Chris Evans, Scarlett Johansson", new ArrayList<>(Arrays.asList("Action", "Adventure", "Sci-Fi"))),
                    new Film(2, "Annette", R.drawable.annete, 6.5f, 139, "A stand-up comedian and his opera singer wife have" +
                            " a 2-year-old daughter with a surprising gift.",
                            "Adam Driver, Marion Cotillard, Simon Helberg", new ArrayList<>(Arrays.asList("Drama", "Musical", "Romance"))),
                    new Film(3, "Dune", R.drawable.dune, 7.5f, 155, "A mythic and emotionally charged hero's journey," +
                            " 'Dune' tells the story of Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding.",
                            "Timothee Chalamet, Zendaya, Oscar Isaac", new ArrayList<>(Arrays.asList("Adventure", "Drama", "Sci-Fi"))),
                    new Film(4, "Jaws", R.drawable.jaws, 8.0f, 124, "When a killer shark " +
                            "unleashes chaos on a beach resort, it's up to a local sheriff, a marine biologist, and an old seafarer to hunt the beast down.",
                            "Roy Scheider, Robert Shaw, Richard Dreyfuss", new ArrayList<>(Arrays.asList("Adventure", "Thriller"))),
                    new Film(5, "The Last of Us", R.drawable.last_of_us, 7.6f, 145, "In a post-apocalyptic world, a hardened survivor" +
                            " and a young girl must make their way through a dangerous and infected landscape.",
                            "Pedro Pascal, Bella Ramsey, Gabriel Luna", new ArrayList<>(Arrays.asList("Action", "Adventure", "Drama"))),
                    new Film(6, "Harry Potter", R.drawable.potter, 7.6f, 152, "A young wizard discovers his" +
                            " true heritage and battles the dark forces threatening the wizarding world.",
                            "Daniel Radcliffe, Emma Watson, Rupert Grint", new ArrayList<>(Arrays.asList("Adventure", "Family", "Fantasy")))


            )
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        idFilm = getIntent().getIntExtra("id",0);
        initView();
//        sendRequest();
        setDetails();
    }

    private void setDetails() {
        progressBar.setVisibility(View.GONE);
        Film item = films.get(idFilm-1);
//            for (Film currentFilm: films) {
//                if(currentFilm.getId() == idFilm) item = currentFilm;
//            }
            Glide.with(DetailActivity.this)
                    .load(item.getPoster())
                    .into(pic2);

            titleTxt.setText(item.getTitle());
            movieRateTxt.setText(Float.toString(item.getImdbRating()));
//            movieTimeTxt.setText(item.getRunTime());
            movieSummary.setText(item.getPlot());
            movieActorsInfo.setText(item.getActors());

            if(item.getGenres() != null){
                adapterCategory = new CategoryEachFilmListAdapter(item.getGenres());
                recyclerViewCategory.setAdapter(adapterCategory);
            }
    }

//    private void sendRequest() {
//        mRequestQueue = Volley.newRequestQueue(this);
//        progressBar.setVisibility(View.VISIBLE);
//        scrollView.setVisibility(View.GONE);
//
//        mStringRequest = new StringRequest(Request.Method.GET, "https://moviesapi.ir/api/v1/movies/" + idFilm, response -> {
//            Gson gson = new Gson();
//            progressBar.setVisibility(View.GONE);
//            scrollView.setVisibility(View.VISIBLE);
//
////            FilmItem item = gson.fromJson(response, FilmItem.class);
//            Film item = null;
//            for (Film currentFilm: films) {
//                if(currentFilm.getId() == idFilm) item = currentFilm;
//            }
//
//
//            Glide.with(DetailActivity.this)
//                    .load(item.getPoster())
//                    .into(pic2);
//
//            titleTxt.setText(item.getTitle());
//            movieRateTxt.setText(Float.toString(item.getImdbRating()));
//            movieTimeTxt.setText(item.getRunTime());
//            movieSummary.setText(item.getPlot());
//            movieActorsInfo.setText(item.getActors());
//
////            if(item.getImages() != null){
////                adapterActorList = new ActorsListAdapter(item.getImages());
////                recyclerViewActors.setAdapter(adapterActorList);
////            }
////
////            if(item.getGenres() != null){
////                adapterCategory = new CategoryEachFilmListAdapter(item.getGenres());
////                recyclerViewCategory.setAdapter(adapterCategory);
////            }
////
////        }, error -> progressBar.setVisibility(View.GONE)
////        );
////
////        mRequestQueue.add(mStringRequest);}



    private void initView() {
        titleTxt = findViewById(R.id.movieNameTxt);
        progressBar = findViewById(R.id.progressBarDetail);
        scrollView = findViewById(R.id.nestedScrollView);
        pic2 = findViewById(R.id.picDetail);
        movieRateTxt = findViewById(R.id.movieStar);
        movieTimeTxt = findViewById(R.id.movieTime);
        movieSummary = findViewById(R.id.movieSummary);
        movieActorsInfo = findViewById(R.id.movieActorInfo);
        backImg = findViewById(R.id.backImg);
        recyclerViewCategory = findViewById(R.id.genreView);
        recyclerViewActors = findViewById(R.id.imagesRecycler);

        recyclerViewActors.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        backImg.setOnClickListener(view -> finish());
    }
}
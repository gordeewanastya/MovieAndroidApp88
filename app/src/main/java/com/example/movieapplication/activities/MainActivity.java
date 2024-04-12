package com.example.movieapplication.activities;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.movieapplication.R;
import com.example.movieapplication.adapters.CategoryListAdapter;
import com.example.movieapplication.adapters.FilmListAdapter;
import com.example.movieapplication.adapters.FilmListAdapter_2;
import com.example.movieapplication.adapters.SliderAdapters;
import com.example.movieapplication.domain.Film;
import com.example.movieapplication.domain.GenresItem;
import com.example.movieapplication.domain.ListFilm;
import com.example.movieapplication.domain.SliderItems;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterBestMovies,adapterUpcoming,adapterCategory;
    private RecyclerView recyclerViewBestMovies, recyclerViewUpcoming, recyclerViewCategory;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest,mStringRequest2,mStringRequest3;
    private ProgressBar loading1,loading2, loading3;

    private ViewPager2 viewPager2;
    private Handler slideHandler = new Handler();
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
        setContentView(R.layout.activity_main);
        
        initView();
        banners();
//        sendRequestBestMovies();
        setBestMovies();
//        sendRequestCategory();
        setCategories();
//        sendRequestUpcomingMovies();
        setUpcomingMovies();
    }

//    private void sendRequestBestMovies() {
//        mRequestQueue = Volley.newRequestQueue(this);
//        loading1.setVisibility(View.VISIBLE);
//        mStringRequest = new StringRequest(Request.Method.GET, "https://moviesapi.ir/api/v1/movies?page=1", response -> {
//            Gson gson = new Gson();
//            loading1.setVisibility(View.GONE);
//            ListFilm items = gson.fromJson(response,ListFilm.class);
//            adapterBestMovies = new FilmListAdapter(items);
//            recyclerViewBestMovies.setAdapter(adapterBestMovies);
//
//        }, error -> {
//            loading1.setVisibility(View.GONE);
//            Log.i("UILover","onErrorResponse: " + error.toString());
//
//        });
//
//        mRequestQueue.add(mStringRequest);
//    }
    private void setBestMovies(){
        loading1.setVisibility(View.GONE);

        adapterBestMovies = new FilmListAdapter_2(films);
        recyclerViewBestMovies.setAdapter(adapterBestMovies);
    }

//    private void sendRequestCategory() {
//        mRequestQueue = Volley.newRequestQueue(this);
//        loading2.setVisibility(View.VISIBLE);
//        mStringRequest2 = new StringRequest(Request.Method.GET, "https://moviesapi.ir/api/v1/genres", response -> {
//            Gson gson = new Gson();
//            loading2.setVisibility(View.GONE);
//            ArrayList<GenresItem> categoryList = gson.fromJson(response,new TypeToken<ArrayList<GenresItem>>(){}.getType());
//            adapterCategory = new CategoryListAdapter(categoryList);
//            recyclerViewCategory.setAdapter(adapterCategory);
//
//        }, error -> {
//            loading2.setVisibility(View.GONE);
//            Log.i("UILover","onErrorResponse: " + error.toString());
//
//        });
//
//        mRequestQueue.add(mStringRequest2);
//    }
    private void setCategories(){
        loading2.setVisibility(View.GONE);
        ArrayList<GenresItem> categoryList = new ArrayList<>(
                Arrays.asList(
                        new GenresItem("Action", "1"),
                        new GenresItem("Comedy", "2"),
                        new GenresItem("Drama", "3"),
                        new GenresItem("Horror", "4"),
                        new GenresItem("Sci-Fi", "5"),
                        new GenresItem("Thriller", "6")
                )
        );
        adapterCategory = new CategoryListAdapter(categoryList);
        recyclerViewCategory.setAdapter(adapterCategory);
    }

//    private void sendRequestUpcomingMovies() {
//        mRequestQueue = Volley.newRequestQueue(this);
//        loading3.setVisibility(View.VISIBLE);
//        mStringRequest3 = new StringRequest(Request.Method.GET, "https://moviesapi.ir/api/v1/movies?page=2", response -> {
//            Gson gson = new Gson();
//            loading3.setVisibility(View.GONE);
//            ListFilm items = gson.fromJson(response,ListFilm.class);
//            adapterUpcoming = new FilmListAdapter(items);
//            recyclerViewUpcoming.setAdapter(adapterUpcoming);
//
//        }, error -> {
//            loading3.setVisibility(View.GONE);
//            Log.i("UILover","onErrorResponse: " + error.toString());
//
//        });
//
//        mRequestQueue.add(mStringRequest3);
//    }
    private void setUpcomingMovies(){
        loading3.setVisibility(View.GONE);
        adapterUpcoming = new FilmListAdapter_2(films);
        recyclerViewUpcoming.setAdapter(adapterUpcoming);
    }

    private void banners() {
        List<SliderItems> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItems(R.drawable.wide));
        sliderItems.add(new SliderItems(R.drawable.wide1));
        sliderItems.add(new SliderItems(R.drawable.wide3));

        viewPager2.setAdapter(new SliderAdapters(sliderItems,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull @NotNull View page, float position) {
                float r = 1-Math.abs(position);
                page.setScaleY(0.85f+r*0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.setCurrentItem(1);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(sliderRunnable);
            }
        });
    }

    private Runnable sliderRunnable=new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        slideHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        slideHandler.postDelayed(sliderRunnable,2000);
    }

    private void initView() {
        viewPager2=findViewById(R.id.viewPagerSlider);

        recyclerViewBestMovies = findViewById(R.id.view1);
        recyclerViewBestMovies.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerViewUpcoming = findViewById(R.id.view3);
        recyclerViewUpcoming.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerViewCategory = findViewById(R.id.view2);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        loading1 = findViewById(R.id.progressBar1);
        loading2 = findViewById(R.id.progressBar2);
        loading3 = findViewById(R.id.progressBar3);
    }
}
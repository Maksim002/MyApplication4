package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ForumService {

    @GET("/ajax/kinoteatrs_load")
    Call<Kinoafisha> getMovies();

}
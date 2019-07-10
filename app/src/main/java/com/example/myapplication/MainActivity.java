package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Listener {
    public static final String baseUrl = "https://kinoafisha.ua";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Adapter adapter = new Adapter(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerViiew);
        recyclerView.setAdapter(adapter);

        NetworkManager.getRetrofit(baseUrl)
                .getMovies().enqueue(new Callback<Kinoafisha>() {
            @Override
            public void onResponse(Call<Kinoafisha> call, Response<Kinoafisha> response) {
                adapter.setNewList(response.body().getResult().getUnmain());
            }

            @Override
            public void onFailure(Call<Kinoafisha> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onClikGaleri(UnMain textView) {

        Intent intent = new Intent(MainActivity.this, VtoroeAcno.class);
        intent.putExtra("key", textView);
        startActivity(intent);
    }
}

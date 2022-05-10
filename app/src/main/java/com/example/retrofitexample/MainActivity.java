package com.example.retrofitexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private final static String baseURL = "https://api.github.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        GitHubClient client = retrofit.create(GitHubClient.class);

        recyclerView = findViewById(R.id.recycler_view);

        Call<List<GitHubRepo>> call = client.reposForUser("BogdanStarunskiy");
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> repos = response.body();
                recyclerView.setAdapter(new RecAdapter(MainActivity.this, repos));
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });

//test
    }


}
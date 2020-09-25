package com.example.workingwithapi.data;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.example.workingwithapi.models.NewsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ApiNews {

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://newsapi.org/")
            .build();
    NewsApi services = retrofit.create(NewsApi.class);

    public void getListNews(NewsCallback newscallback) {
        Call<NewsModel> call = services.getNewss("bitcoin", "2020-07-25", "publishedAt", "e13552173f22454eacd03caa30a9edbd");
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        newscallback.onSuccess(response.body());
                        Log.e("tag", response.body().toString());
                    } else {
                        Log.e("tag", "response body is null");
                        newscallback.onFailure(new NetworkErrorException());
                    }
                }
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Log.e("tag", "Error");
                newscallback.onFailure(new Exception());
            }
        });
    }

    public interface NewsCallback {
        void onSuccess(NewsModel newsMS);

        void onFailure(Exception e);
    }

    public interface NewsApi {
        @GET("v2/everything")
        Call<NewsModel> getNewss(@Query("q") String q,
                                 @Query("from") String from,
                                 @Query("sortBy") String sortBy,
                                 @Query("apiKey") String apiKey);

    }
}

package com.example.workingwithapi.data;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.example.workingwithapi.models.FilmM;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class GhibliService {

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .build();

    GhibliApi service = retrofit.create(GhibliApi.class);

    public void getListFilms(GhibliCallback callback){
        Call<ArrayList<FilmM>> call = service.getFilms();
        call.enqueue(new Callback<ArrayList<FilmM>>() {
            @Override
            public void onResponse(Call<ArrayList<FilmM>> call, Response<ArrayList<FilmM>> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        Log.d("tag", response.body().toString());
                        callback.onSuccess(response.body());
                    }else {
                        Log.e("tag", "response body is null");
                        callback.onFailure(new NetworkErrorException());
                    }
                }
            }
            @Override
            public void onFailure(Call<ArrayList<FilmM>> call, Throwable t) {
                Log.d("tag", "Error");
                callback.onFailure(new Exception());
            }
        });
    }
    public void getFilmById(String id, GhibliCallback callback){
        Call<FilmM> call = service.getFilmById(id);
        call.enqueue(new Callback<FilmM>() {
            @Override
            public void onResponse(Call<FilmM> call, Response <FilmM> response) {
                if (response.isSuccessful() && response.body() != null){
                    Log.e("tag", response.body().toString());
                    callback.onResponseFilm(response.body());
                }
            }

            @Override
            public void onFailure(Call<FilmM> call, Throwable t) {
                Log.d("tag", "Error");
                callback.onFailure(new NetworkErrorException());

            }
        });

    }
    public interface GhibliCallback{
        void onSuccess(ArrayList<FilmM> filmMS);
        void onResponseFilm(FilmM filmM);
        void onFailure(Exception e);
    }
    public interface GhibliApi{
        @GET("films/")
        Call<ArrayList<FilmM>> getFilms();

        @GET("films/{id}")
        Call<FilmM> getFilmById(@Path("id") String filmId);
    }

}
//android:usesCleartextTraffic="true"

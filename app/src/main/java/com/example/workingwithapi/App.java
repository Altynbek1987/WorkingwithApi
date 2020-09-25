package com.example.workingwithapi;

import android.app.Application;

import androidx.room.Room;

import com.example.workingwithapi.data.CatApi;
import com.example.workingwithapi.data.GhibliService;
import com.example.workingwithapi.data.ApiNews;
import com.example.workingwithapi.local.AppDatabase;

public class App extends Application {

    public static GhibliService ghibliService;
    public static CatApi apiCat;
    public static ApiNews apiNews;
    public static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        ghibliService = new GhibliService();
        apiCat = new CatApi();
        apiNews = new ApiNews();
        appDatabase = Room.databaseBuilder
                (this,AppDatabase.class,"database")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }
}

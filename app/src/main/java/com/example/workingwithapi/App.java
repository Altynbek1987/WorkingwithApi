package com.example.workingwithapi;

import android.app.Application;

import com.example.workingwithapi.data.CatApi;
import com.example.workingwithapi.data.GhibliService;
import com.example.workingwithapi.data.ApiNews;

public class App extends Application {

    public static GhibliService ghibliService;
    public static CatApi apiCat;
    public static ApiNews apiNews;

    @Override
    public void onCreate() {
        super.onCreate();
        ghibliService = new GhibliService();
        apiCat = new CatApi();
        apiNews = new ApiNews();
    }
}

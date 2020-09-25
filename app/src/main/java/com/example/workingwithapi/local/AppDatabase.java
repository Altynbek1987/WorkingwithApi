package com.example.workingwithapi.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.workingwithapi.models.FilmM;

@Database(entities = {FilmM.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FilmDao filmDao();
}

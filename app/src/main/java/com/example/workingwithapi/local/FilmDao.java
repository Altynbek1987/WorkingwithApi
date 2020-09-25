package com.example.workingwithapi.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.workingwithapi.models.FilmM;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface FilmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFilm(FilmM filmM);
    @Delete
    void deleteFilm(FilmM filmM);

    @Query("SELECT * FROM FilmM")
    List<FilmM> getAllFilms();
}

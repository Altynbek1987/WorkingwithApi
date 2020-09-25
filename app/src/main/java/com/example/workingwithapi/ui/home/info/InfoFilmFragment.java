package com.example.workingwithapi.ui.home.info;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.workingwithapi.App;
import com.example.workingwithapi.R;
import com.example.workingwithapi.data.GhibliService;
import com.example.workingwithapi.models.FilmM;

import java.util.ArrayList;

public class InfoFilmFragment extends Fragment implements GhibliService.GhibliCallback {
    private TextView filmName, filmDeck,filmDirector,filmProducer,filmReleaseDate,filmScore,
            info_release,score,name_director,name_producer;
    private Button btnSave;
    private FilmM filmM;

    public InfoFilmFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("tag","onCreateView");
        Bundle bundle = getArguments();
        if (bundle != null){
            String id = bundle.getString("id");
           App.ghibliService.getFilmById(id,this);
        }
        return inflater.inflate(R.layout.fragment_info_film, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("tag","onViewCreated");
        filmName = view.findViewById(R.id.info_filmName);
        filmDeck = view.findViewById(R.id.info_desc);
        filmDirector = view.findViewById(R.id.info_director);
        filmProducer = view.findViewById(R.id.info_producer);
        filmReleaseDate = view.findViewById(R.id.info_releaseDate);
        filmScore = view.findViewById(R.id.info_rtScore);
        info_release = view.findViewById(R.id.info_release);
        score = view.findViewById(R.id.score);
        name_director = view.findViewById(R.id.name_director);
        name_producer = view.findViewById(R.id.name_producer);
        btnSave = view.findViewById(R.id.btn_save);

        //App.appDatabase.filmDao().insertFilm(filmM);
    }

    @Override
    public void onSuccess(ArrayList<FilmM> filmMS) {

    }

    @Override
    public void onResponseFilm(FilmM filmM) {
        Log.e("tag","onResponseFilm");
        filmName.setText(filmM.getTitle());
        filmDeck.setText(filmM.getDescription());
        filmDirector.setText(filmM.getDirector());
        filmProducer.setText(filmM.getProducer());
        filmReleaseDate.setText(filmM.getReleaseDate());
        filmScore.setText(filmM.getRtScore());
    }

    @Override
    public void onFailure(Exception e) {

    }

    //tools:context=".ui.home.info.InfoFilmFragment"
}

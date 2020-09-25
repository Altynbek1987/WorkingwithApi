package com.example.workingwithapi.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.workingwithapi.App;
import com.example.workingwithapi.R;
import com.example.workingwithapi.data.GhibliService;
import com.example.workingwithapi.interfac.OnItemFBNClickListener;
import com.example.workingwithapi.models.FilmM;
import com.example.workingwithapi.ui.home.adapter.AdapterFilm;
import com.example.workingwithapi.ui.home.info.InfoFilmFragment;

import java.util.ArrayList;

public class FilmFragment extends Fragment implements GhibliService.GhibliCallback {

    private RecyclerView recyclerViewFilm;
    private AdapterFilm adapterFilm;
    private ArrayList<FilmM> mList;
    NavController navController;
    private FilmM filmM;
    public FilmFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        return inflater.inflate(R.layout.fragment_film, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.ghibliService.getListFilms(this);
         recyclerViewFilm = view.findViewById(R.id.recyclerViewFilm);
    }

    @Override
    public void onSuccess(ArrayList<FilmM> films) {
        Log.e("tag","onSuccess_filmsFragment");
        Log.e("ololo","films from DB" + App.appDatabase.filmDao().getAllFilms());
        mList = films;
        adapterFilm = new AdapterFilm(mList);
        recyclerViewFilm.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));
        recyclerViewFilm.setAdapter(adapterFilm);
        adapterFilm.setOnItemFBNClickListener(new OnItemFBNClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.e("tag","OnItemClick");
                Bundle bundle = new Bundle();
                bundle.putString("id",mList.get(position).getId());
                InfoFilmFragment infoFilmFragment = new InfoFilmFragment();
                infoFilmFragment.setArguments(bundle);
                navController.navigate(R.id.infoFilmFragment,bundle);
            }
        });
        App.appDatabase.filmDao().insertFilm(films.get(0));

    }

    @Override
    public void onResponseFilm(FilmM filmM) {

    }


    @Override
    public void onFailure(Exception e) {

    }


}

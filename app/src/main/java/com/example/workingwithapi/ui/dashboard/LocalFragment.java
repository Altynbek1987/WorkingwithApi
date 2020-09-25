package com.example.workingwithapi.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workingwithapi.App;
import com.example.workingwithapi.R;
import com.example.workingwithapi.models.FilmM;
import com.example.workingwithapi.ui.home.adapter.AdapterLocal;

import java.util.ArrayList;
import java.util.List;

public class LocalFragment extends Fragment {
    private RecyclerView recyclerViewLocal;
    private AdapterLocal adapterLocal;
    private ArrayList<String> arrayList;

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewLocal = view.findViewById(R.id.recyclerViewLocal);
        //List<FilmM> list = App.appDatabase.filmDao().getAllFilms();
        arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        adapterLocal = new AdapterLocal(arrayList);
        recyclerViewLocal.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));
        recyclerViewLocal.setAdapter(adapterLocal);
    }
}

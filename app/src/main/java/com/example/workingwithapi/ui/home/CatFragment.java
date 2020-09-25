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
import com.example.workingwithapi.data.CatApi;
import com.example.workingwithapi.interfac.OnItemFBNClickListener;
import com.example.workingwithapi.models.CatM;
import com.example.workingwithapi.ui.home.adapter.AdapterCat;
import com.example.workingwithapi.ui.home.info.InfoCatFragment;

import java.util.ArrayList;

public class CatFragment extends Fragment implements CatApi.CatCallback {

    private AdapterCat adapterCat;
    private ArrayList<CatM> list;
    RecyclerView recyclerViewCat;
    private CatM bookM;
    NavController navController;

    public CatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("tag", "onCreateViewCatFragment");
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        return inflater.inflate(R.layout.fragment_cat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.e("tag", " onViewCreatedCatFragment");
        super.onViewCreated(view, savedInstanceState);
        App.apiCat.getListCats(this);
        recyclerViewCat = view.findViewById(R.id.recyclerViewCat);
    }

    @Override
    public void onSuccess(ArrayList<CatM> body) {
        Log.e("tag", "onSuccessCatFragment");
        list = body;
        adapterCat = new AdapterCat(list);
        adapterCat.notifyDataSetChanged();
        recyclerViewCat.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        recyclerViewCat.setAdapter(adapterCat);
        adapterCat.setOnItemFBNClickListener(new OnItemFBNClickListener() {
            @Override
            public void onItemClick(int position) {
                Bundle bundle = new Bundle();
                bundle.putString("id",list.get(position).getId());
                InfoCatFragment infoCatFragment = new InfoCatFragment();
                infoCatFragment.setArguments(bundle);
                navController.navigate(R.id.infoCatFragment,bundle);
            }
        });
    }

    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void onSuccessCat(CatM body) {

    }

}

package com.example.workingwithapi.ui.home.info;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.workingwithapi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoNewsFragment extends Fragment {

    public InfoNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_news, container, false);
    }
}

package com.example.workingwithapi.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workingwithapi.R;
import com.example.workingwithapi.interfac.OnItemFBNClickListener;
import com.example.workingwithapi.models.FilmM;

import java.util.ArrayList;

public class AdapterLocal extends RecyclerView.Adapter<AdapterLocal.ViewHolder>{

    public AdapterLocal(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public void setOnItemFBNClickListener(OnItemFBNClickListener onItemFBNClickListener) {
        this.onItemFBNClickListener = onItemFBNClickListener;
    }

    private OnItemFBNClickListener onItemFBNClickListener;

    private ArrayList<String> arrayList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_local_film,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textLocal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textLocal = itemView.findViewById(R.id.tv_local_holder);
        }

        public void bind(String string) {
            textLocal.setText(string);
        }
    }
}

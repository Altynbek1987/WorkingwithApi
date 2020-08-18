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
import java.util.List;

public class AdapterFilm extends RecyclerView.Adapter<AdapterFilm.ViewHolder>{

    public void setOnItemFBNClickListener(OnItemFBNClickListener onItemFBNClickListener) {
        this.onItemFBNClickListener = onItemFBNClickListener;
    }
    private OnItemFBNClickListener onItemFBNClickListener;

    private ArrayList<FilmM> mList;

    public AdapterFilm(ArrayList<FilmM> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data_film,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_dataFilm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemFBNClickListener.onItemClick(getAdapterPosition());
                }
            });
            tv_dataFilm = itemView.findViewById(R.id.tv_film_holder);

        }

        public void bind(FilmM filmM) {
            tv_dataFilm.setText(filmM.getTitle());

        }
    }
}

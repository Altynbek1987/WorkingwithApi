package com.example.workingwithapi.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workingwithapi.R;
import com.example.workingwithapi.interfac.OnItemFBNClickListener;
import com.example.workingwithapi.models.CatM;

import java.util.ArrayList;


public class AdapterCat extends RecyclerView.Adapter<AdapterCat.ViewHolder> {

    public void setOnItemFBNClickListener(OnItemFBNClickListener onItemFBNClickListener) {
        this.onItemFBNClickListener = onItemFBNClickListener;
    }

    private OnItemFBNClickListener onItemFBNClickListener;

    public AdapterCat(ArrayList<CatM> list) {
        this.list = list;
    }

    private ArrayList<CatM> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data_holder,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }
    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_book;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemFBNClickListener.onItemClick(getAdapterPosition());
                }
            });
            tv_book = itemView.findViewById(R.id.tv_book_holder);
        }
        public void bind(CatM bookM) {
            tv_book.setText(bookM.getType());

        }
    }
}

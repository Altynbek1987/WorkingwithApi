package com.example.workingwithapi.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workingwithapi.R;
import com.example.workingwithapi.interfac.OnItemFBNClickListener;
import com.example.workingwithapi.models.NewsModel;

import java.util.List;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder>{
    public void setOnItemFBNClickListener(OnItemFBNClickListener onItemFBNClickListener) {
        this.onItemFBNClickListener = onItemFBNClickListener;
    }
    private OnItemFBNClickListener onItemFBNClickListener;


    public AdapterNews(List<NewsModel> newsMList) {
        this.newsMList = newsMList;
    }

    private List<NewsModel> newsMList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data_news,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(newsMList.get(position));

    }

    @Override
    public int getItemCount() {
        return newsMList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView newsHolder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsHolder = itemView.findViewById(R.id.tv_news_holder);
        }

        public void bind(NewsModel newsM) {
            newsHolder.setText(newsM.getTotalResults());

        }
    }
}

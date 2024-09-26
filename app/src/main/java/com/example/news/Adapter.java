package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.PluralsRes;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<DataHolder> {

    private List<News> newsList;
    private Context context;

    public Adapter(List<News> shop) {
        this.newsList = shop;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View shopView = inflater.inflate(R.layout.line_item_layout,parent,false);

        DataHolder viewHolder = new DataHolder(shopView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        News item = newsList.get(position);
        holder.setTitle(item.getTitle());
        holder.setAuthor(item.getAuthor());
        holder.setReference(item.getReference());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}

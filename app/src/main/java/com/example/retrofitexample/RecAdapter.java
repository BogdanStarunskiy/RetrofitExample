package com.example.retrofitexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecAdapter extends RecyclerView.Adapter<RecViewHolder> {
    LayoutInflater inflater;
    List<GitHubRepo> reposList;
    public RecAdapter (Context context, List<GitHubRepo> list){
        this.reposList = list;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycler_view, parent, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, int position) {
        holder.textView.setText(reposList.get(position).getName());
    }

    @Override
    public int getItemCount() {
            return reposList.size();
    }
}

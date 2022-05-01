package com.example.retrofitexample;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecViewHolder  extends RecyclerView.ViewHolder {
    TextView textView;
    public RecViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_item);
    }
}

package com.example.myapplication;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView textView;
    Listener listener;

    public ViewHolder(@NonNull View itemView, final Listener listener) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        textView = itemView.findViewById(R.id.textView);
        this.listener = listener;
    }

    public void bind(final UnMain value) {
        Glide.with(itemView)
        .load(MainActivity.baseUrl + value.getImage())
        .into(imageView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClikGaleri(value);
            }
        });
        textView.setText(value.getName());
    }
}

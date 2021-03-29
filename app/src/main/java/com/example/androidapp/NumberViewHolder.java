package com.example.androidapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumberViewHolder extends RecyclerView.ViewHolder {

    private TextView number;

    public NumberViewHolder(@NonNull View itemView) {
        super(itemView);
        this.number = itemView.findViewById(R.id.number);
    }

    public void bind(NumberModel numberModel) {
        this.number.setText(String.valueOf(numberModel.number));
        this.number.setTextColor(numberModel.color);
    }
}

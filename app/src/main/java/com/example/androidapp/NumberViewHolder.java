package com.example.androidapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumberViewHolder extends RecyclerView.ViewHolder {

    private TextView number;
    private ViewGroup parent;
    private NumbersFragment.ListenerClickNumber listenerClickNumber;

    public NumberViewHolder(@NonNull View itemView) {
        super(itemView);
        this.number = itemView.findViewById(R.id.number);
    }

    public void bind(NumberModel numberModel) {
        this.number.setText(String.valueOf(numberModel.number));
        this.number.setTextColor(numberModel.color);
        this.number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerClickNumber.listenerOnClick(numberModel.number);
            }
        });
//        this.number.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FrameLayout frameLayout = parent.findViewById(R.id.fragment_numbers);
//                frameLayout.setVisibility(View.GONE);
//                View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_one_number, parent, false);
//                TextView number = view.findViewById(R.id.number);
//                number.setTextColor(numberModel.color);
//                number.setText(String.valueOf(numberModel.number));
//                view.invalidate();
//                view.setVisibility(View.VISIBLE);
//            }
//        });
    }

    public void setParent(ViewGroup viewGroup) {
        this.parent = viewGroup;
    }

    public void setListenerClickNumber(NumbersFragment.ListenerClickNumber listener) {
        this.listenerClickNumber = listener;
    }
}

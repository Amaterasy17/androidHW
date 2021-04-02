package com.example.androidapp.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidapp.fragments.NumbersFragment;
import com.example.androidapp.R;

import java.util.ArrayList;

public class NumberAdapter extends RecyclerView.Adapter<NumberViewHolder> {
    public ArrayList<NumberModel> data = Numbers.getInstance().getData();
    public ViewGroup view;
    public NumbersFragment.ListenerClickNumber listener;

    public NumberAdapter(ViewGroup viewGroup, NumbersFragment.ListenerClickNumber listener) {
        this.view = viewGroup;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_item, parent, false);
        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        NumberModel numberModel = data.get(position);

        holder.setListenerClickNumber(listener);
        holder.bind(numberModel);
        holder.setParent(view);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

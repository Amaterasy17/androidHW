package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NumbersFragment.ListenerClickNumber {

    public void listenerOnClick(int number) {
        NumberModel numberModel = new NumberModel(number);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_view) == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_view, OneNumberFragment.class, null)
                    .commit();
        } else {
            Fragment frag = fragmentManager.findFragmentById(R.id.fragment_view);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction
                    .remove(frag)
                    .add(R.id.fragment_view, new OneNumberFragment())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commitNow();
        }

        OneNumberFragment fragment = (OneNumberFragment) fragmentManager.findFragmentById(R.id.fragment_view);
        View oneNumber = findViewById(R.id.one_number);
        TextView text = oneNumber.findViewById(R.id.number_text);
        text.setText(String.valueOf(numberModel.number));
        text.setTextColor(numberModel.color);
    }

    protected void ChangeView(NumberModel numberModel) {
        TextView text = findViewById(R.id.number_text);
        text.setText(String.valueOf(numberModel.number));
        text.setTextColor(numberModel.color);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            if (getSupportFragmentManager().findFragmentById(R.id.fragment_view) == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_view, NumbersFragment.class, null)
                        .commit();
            }

        }
    }
}
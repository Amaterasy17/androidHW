package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.one_number, OneNumberFragment.class, null)
                    .commit();
        }
    }
}
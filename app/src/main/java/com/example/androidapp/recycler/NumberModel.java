package com.example.androidapp.recycler;

import android.graphics.Color;

public class NumberModel {
    public int color;
    public int number;

    public NumberModel(int number) {
        if (number % 2 == 0) {
            this.color = Color.RED;
        } else {
            this.color = Color.BLUE;
        }

        this.number = number;
    }
}

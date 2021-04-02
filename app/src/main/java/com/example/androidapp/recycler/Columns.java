package com.example.androidapp.recycler;

import android.content.Context;

public class Columns {
    public Columns() {

    }

    public int getNumberColumns(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return 4;
        }
        return 3;
    }
}

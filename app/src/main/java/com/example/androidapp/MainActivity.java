package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recycler);
        Columns numberColumn = new Columns();

        recyclerView.setLayoutManager(new GridLayoutManager(this, numberColumn.getNumberColumns(this)));

        NumberAdapter adapter = new NumberAdapter();
        recyclerView.setAdapter(adapter);

        Button button = findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Numbers.getInstance().addNumber();
                adapter.notifyItemInserted(Numbers.getInstance().getLastNumber() - 1);
            }
        });
    }
}
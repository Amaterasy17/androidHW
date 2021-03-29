package com.example.androidapp;


import java.util.ArrayList;

public class Numbers {
    private static Numbers sInstance;
    public ArrayList<NumberModel> numbers;

    public Numbers() {
        this.numbers = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            NumberModel numberModel = new NumberModel(i + 1);
            this.numbers.add(numberModel);
        }
    }

    public int getLastNumber() {
        return numbers.size();
    }

    public void addNumber() {
        NumberModel numberModel = new NumberModel(getLastNumber() + 1);
        sInstance.numbers.add(numberModel);
    }

    public synchronized static Numbers getInstance() {
        if (sInstance == null) {
            sInstance = new Numbers();
        }
        return sInstance;
    }

    public ArrayList<NumberModel> getData() {
        return this.numbers;
    }
}

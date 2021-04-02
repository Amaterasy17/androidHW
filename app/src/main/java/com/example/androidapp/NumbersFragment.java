package com.example.androidapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumbersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumbersFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ListenerClickNumber listenerClickNumber;

    public NumbersFragment() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ListenerClickNumber) {
            listenerClickNumber = (ListenerClickNumber) context;
        } else {
            throw new IllegalStateException("must implement ListenerClickNumber interface");
        }
    }

    public interface ListenerClickNumber {
        public void listenerOnClick(int number);
    }

    @Override
    public void onDestroy() {
        listenerClickNumber = null;
        super.onDestroy();
    }

    public static NumbersFragment newInstance(String param1, String param2) {
        NumbersFragment fragment = new NumbersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numbers, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        Columns numberColumn = new Columns();

        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), numberColumn.getNumberColumns(container.getContext())));

        NumberAdapter adapter = new NumberAdapter(container, listenerClickNumber);
        recyclerView.setAdapter(adapter);

        Button button = view.findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Numbers.getInstance().addNumber();
                adapter.notifyItemInserted(Numbers.getInstance().getLastNumber() - 1);
            }
        });



        return view;
    }
}
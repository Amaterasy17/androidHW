package com.example.androidapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidapp.MainActivity;
import com.example.androidapp.R;
import com.example.androidapp.recycler.NumberModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OneNumberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneNumberFragment extends Fragment {

    public static final String STATE = "state";
    private TextView numberText;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OneNumberFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OneNumberFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OneNumberFragment newInstance(String param1, String param2) {
        OneNumberFragment fragment = new OneNumberFragment();
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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE, numberText.getText().toString());
    }

    private void restoreState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            String string = savedInstanceState.getString(STATE);
            int number = Integer.parseInt(string);
            NumberModel numberModel = new NumberModel(number);
            numberText.setText(string);
            numberText.setTextColor(numberModel.color);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_number, container, false);
        TextView currentNumber = view.findViewById(R.id.number);
        this.numberText = view.findViewById(R.id.number_text);
        restoreState(savedInstanceState);

        Button back = view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(container.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
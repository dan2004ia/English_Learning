package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class WordOfDayFragment extends Fragment {

    private TextView tvWord, tvMeaning;


    public WordOfDayFragment() {
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word_of_day, container, false);
        tvWord = view.findViewById(R.id.tvWordOfDay);
        tvMeaning = view.findViewById(R.id.tvMeaning);


         tvWord.setText("Word of the Day: Cloud - غيمة");
        tvMeaning.setText("Learn this word and try to use it today!");


        return view;
    }
}

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class LearningActivity extends AppCompatActivity {

    private List<Word> wordList;
    private int currentIndex = 0;

    private TextView textEnglish, textArabic;
    private ImageView imageWord;
    private Button btnNext;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);


        textEnglish = findViewById(R.id.textEnglish);
        textArabic = findViewById(R.id.textArabic);
        imageWord = findViewById(R.id.imageWord);
        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);

         wordList = new ArrayList<>();
        wordList.add(new Word("Cloud", "غيمة", R.drawable.cloud));
        wordList.add(new Word("School", "مدرسة", R.drawable.school));
        wordList.add(new Word("Tree", "شجرة", R.drawable.tree));
        wordList.add(new Word("Laptop", "لابتوب", R.drawable.laptop));
        wordList.add(new Word("Door", "باب", R.drawable.door));


         showWord(currentIndex);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex < wordList.size()) {
                    showWord(currentIndex);
                } else {
                     Intent intent = new Intent(LearningActivity.this, HomeActivity2.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

         btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearningActivity.this, HomeActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }

    private void showWord(int index) {
        Word word = wordList.get(index);
        textEnglish.setText(word.getEnglish());
        textArabic.setText(word.getArabic());
        imageWord.setImageResource(word.getImageResId());
    }
}

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity2 extends AppCompatActivity {

    Button btnStartLearning, btnWordList, btnQuickTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        btnStartLearning = findViewById(R.id.btnStartLearning);
        btnWordList = findViewById(R.id.btnWordList);
        btnQuickTest = findViewById(R.id.btnQuiz);

         btnStartLearning.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity2.this, LearningActivity.class);
            startActivity(intent);
        });

         btnWordList.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity2.this, WordListActivity.class);
            startActivity(intent);
        });

         btnQuickTest.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity2.this, QuizActivity.class);
            startActivity(intent);
        });

         Button btnAbout = findViewById(R.id.btnAboutApp);
        btnAbout.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity2.this, AboutActivity.class);
            startActivity(intent);
        });

        ImageView ImageIcon = findViewById(R.id.imageIcon);
        ImageIcon.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity2.this, SettingActivity.class);
            startActivity(intent);
        });

        WordOfDayFragment fragment = new WordOfDayFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentWordContainer, fragment)
                .commit();


    }
}

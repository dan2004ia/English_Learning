package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ResultsActivity extends AppCompatActivity {

    TextView tvCorrect, tvWrong, tvAttempts;
    Button btnRetry, btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        tvCorrect = findViewById(R.id.tvCorrect);
        tvWrong = findViewById(R.id.tvWrong);
        tvAttempts = findViewById(R.id.tvAttempts);
        btnRetry = findViewById(R.id.btnRetry);
        btnHome = findViewById(R.id.btnHome);

        int correct = getIntent().getIntExtra("CORRECT", 0);
        int wrong = getIntent().getIntExtra("WRONG", 0);
        int attempts = getIntent().getIntExtra("ATTEMPTS", 0);

        tvCorrect.setText("إجابات صحيحة: " + correct);
        tvWrong.setText("إجابات خاطئة: " + wrong);
        tvAttempts.setText("عدد المحاولات: " + attempts);

        btnRetry.setOnClickListener(v -> {
            Intent intent = new Intent(ResultsActivity.this, QuizActivity.class);
            startActivity(intent);
            finish();
        });

        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(ResultsActivity.this, HomeActivity2.class);
            startActivity(intent);
            finish();
        });
    }
}

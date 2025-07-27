package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityWordListBinding;

public class HomeActivity2 extends AppCompatActivity {

    Button btnStartLearning, btnWordList, btnQuickTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        btnStartLearning = findViewById(R.id.btnStartLearning);
        btnWordList = findViewById(R.id.btnWordList);
        btnQuickTest = findViewById(R.id.btnQuiz);


        btnStartLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity2.this, LearningActivity.class);
                startActivity(intent);
            }
        });


//        btnWordList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity2.this,WordListActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        btnQuickTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity2.this, QuizActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}

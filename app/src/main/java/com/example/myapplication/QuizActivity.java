package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity{

    private TextView textQuestion;
    private RadioGroup optionsGroup;
    private RadioButton option1, option2, option3, option4;
    private Button btnCheck, btnNext;

    private List<com.example.myapplication.Question> questionList;
    private int currentQuestionIndex = 0;
    private boolean answered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize);

        // ربط العناصر بالواجهة
        textQuestion = findViewById(R.id.test_question);
        optionsGroup = findViewById(R.id.option_group);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        btnCheck = findViewById(R.id.btn_check);
        btnNext = findViewById(R.id.btnNext);

        // تجهيز الأسئلة
        prepareQuestions();
        showQuestion();

        // عند الضغط على "تحقق"
        btnCheck.setOnClickListener(v -> {
            if (!answered) {
                int selectedId = optionsGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(this, "Please choose an answer !", Toast.LENGTH_SHORT).show();
                } else {
                    checkAnswer(selectedId);
                    answered = true;
                }
            }
        });

        // عند الضغط على "التالي"
        btnNext.setOnClickListener(v -> {
            currentQuestionIndex++;
            if (currentQuestionIndex < questionList.size()) {
                showQuestion();
                answered = false;
            } else {
                Toast.makeText(this, "The test is over !", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }


    private void prepareQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new com.example.myapplication.Question("cloud", "طاولة", "شجرة", "غيمة", "مدرسة", 1));
        questionList.add(new com.example.myapplication.Question("table", "قلم", "طاولة", "بيت", "ممحاة", 2));
        questionList.add(new com.example.myapplication.Question("laptop", "كتاب", "لابتوب", "تلفاز", "هاتف", 3));
    }

    // عرض السؤال الحالي
    private void showQuestion() {
        com.example.myapplication.Question q = questionList.get(currentQuestionIndex);
        textQuestion.setText(q.getWord());
        option1.setText(q.getOption1());
        option2.setText(q.getOption2());
        option3.setText(q.getOption3());
        option4.setText(q.getOption4());
        optionsGroup.clearCheck();
    }

    // التحقق من الإجابة
    private void checkAnswer(int selectedId) {
        com.example.myapplication.Question q = questionList.get(currentQuestionIndex);
        int correctOptionId = q.getCorrectOptionIndex();

        RadioButton selectedRadio = findViewById(selectedId);
        int selectedIndex = optionsGroup.indexOfChild(selectedRadio) + 1;

        if (selectedIndex == correctOptionId) {
            Toast.makeText(this, "Correct Answer 🎉", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong Answer ❌", Toast.LENGTH_SHORT).show();
        }
    }
}

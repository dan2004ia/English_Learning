package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class QuizActivity extends AppCompatActivity {

    private TextView tvQuestionNumber, tvQuestion, tvScore;
    private Button btnOption1, btnOption2, btnOption3, btnOption4;
    private ArrayList<Question> questionList;
    private int currentIndex = 0;
    private int score = 0;
    private final int NEXT_DELAY_MS = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize);

        tvQuestionNumber = findViewById(R.id.tvQuestionNumber);
        tvQuestion = findViewById(R.id.tvQuestion);
        tvScore = findViewById(R.id.tvScore);
        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);
        btnOption3 = findViewById(R.id.btnOption3);
        btnOption4 = findViewById(R.id.btnOption4);

        initQuestions();
        showQuestion(currentIndex);
        updateScore();
        setOptionListeners();
    }

    private void initQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new Question("What is the meaning of 'Home'?",
                Arrays.asList("منزل", "هاتف", "حديقة", "مدرسة"), 0));
        questionList.add(new Question("What is the meaning of 'Door'?",
                Arrays.asList("كتاب", "شباك", "باب", "بيت"), 2));
        questionList.add(new Question("What is the meaning of 'Cloud'?",
                Arrays.asList("سماء", "نجمة", "غيمة", "نافذة"), 2));
        questionList.add(new Question("What is the meaning of 'School'?",
                Arrays.asList("سيارة", "جامعة", "مكتبة", "مدرسة"), 3));
        questionList.add(new Question("What is the meaning of 'Laptop'?",
                Arrays.asList("سيارة", "هاتف", "تلفاز", "لابتوب"), 3));
    }

    private void showQuestion(int index) {
        Question q = questionList.get(index);
        tvQuestionNumber.setText("السؤال " + (index + 1) + " / " + questionList.size());
        tvQuestion.setText(q.getQuestion());

        btnOption1.setText(q.getOptions().get(0));
        btnOption2.setText(q.getOptions().get(1));
        btnOption3.setText(q.getOptions().get(2));
        btnOption4.setText(q.getOptions().get(3));

        resetOptionButtons();
        enableOptions(true);
    }

    private void resetOptionButtons() {
        Button[] buttons = {btnOption1, btnOption2, btnOption3, btnOption4};
        for (Button b : buttons) {
            b.setEnabled(true);
            b.setBackgroundResource(R.drawable.option_button);
            b.setTextColor(getResources().getColor(android.R.color.white));
        }
    }

    private void enableOptions(boolean enable) {
        btnOption1.setEnabled(enable);
        btnOption2.setEnabled(enable);
        btnOption3.setEnabled(enable);
        btnOption4.setEnabled(enable);
    }

    private void setOptionListeners() {
        btnOption1.setOnClickListener(v -> handleAnswer(0, btnOption1));
        btnOption2.setOnClickListener(v -> handleAnswer(1, btnOption2));
        btnOption3.setOnClickListener(v -> handleAnswer(2, btnOption3));
        btnOption4.setOnClickListener(v -> handleAnswer(3, btnOption4));
    }

    private void handleAnswer(final int selectedIndex, final Button selectedBtn) {
        enableOptions(false);
        Question q = questionList.get(currentIndex);
        int correct = q.getCorrectIndex();

        if (selectedIndex == correct) {
            score++;
            selectedBtn.setBackgroundResource(R.drawable.option_button_correct);
        } else {
            selectedBtn.setBackgroundResource(R.drawable.option_button_wrong);
            Button[] buttons = {btnOption1, btnOption2, btnOption3, btnOption4};
            buttons[correct].setBackgroundResource(R.drawable.option_button_correct);
        }

        updateScore();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            currentIndex++;
            if (currentIndex < questionList.size()) {
                showQuestion(currentIndex);
            } else {
                showResult();
            }
        }, NEXT_DELAY_MS);
    }


    private void updateScore() {
        tvScore.setText("النتيجة: " + score + " / " + questionList.size());
    }

    private void showResult() {
        int correct = score;
        int wrong = questionList.size() - score;
        int attempts = questionList.size();

        Intent intent = new Intent(QuizActivity.this, ResultsActivity.class);
        intent.putExtra("CORRECT", correct);
        intent.putExtra("WRONG", wrong);
        intent.putExtra("ATTEMPTS", attempts);
        startActivity(intent);
        finish();
    }

    private static class Question {
        private final String question;
        private final ArrayList<String> options;
        private final int correctIndex;

        public Question(String question, java.util.List<String> options, int correctIndex) {
            this.question = question;
            this.options = new ArrayList<>(options);
            this.correctIndex = correctIndex;
        }

        public String getQuestion() { return question; }
        public ArrayList<String> getOptions() { return options; }
        public int getCorrectIndex() { return correctIndex; }
    }
}

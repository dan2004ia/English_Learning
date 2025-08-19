package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class WordListActivity extends AppCompatActivity {

    private ListView listView;
    private WordAdapter adapter;
    private List<Word> wordList;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

         listView = findViewById(R.id.listViewWords);
        btnBack = findViewById(R.id.btnBack);

        wordList = new ArrayList<>();
        wordList.add(new Word("Cloud", "غيمة", R.drawable.cloud));
        wordList.add(new Word("Table", "طاولة", R.drawable.table));
        wordList.add(new Word("Laptop", "لابتوب", R.drawable.laptop));
        wordList.add(new Word("School", "مدرسة", R.drawable.school));
        wordList.add(new Word("Tree", "شجرة", R.drawable.tree));

         adapter = new WordAdapter(this, wordList);
        listView.setAdapter(adapter);

         btnBack.setOnClickListener(v -> finish());
    }

     @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

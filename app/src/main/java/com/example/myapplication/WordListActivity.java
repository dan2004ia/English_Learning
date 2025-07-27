package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WordListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WordAdapter adapter;
    private List<Word> wordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        recyclerView = findViewById(R.id.recyclerViewWords);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        wordList = new ArrayList<>();

        wordList.add(new Word("Cloud", "غيمة", R.drawable.cloud));
        wordList.add(new Word("Table", "طاولة", R.drawable.table));
        wordList.add(new Word("Laptop", "لابتوب", R.drawable.laptop));
        wordList.add(new Word("School", "مدرسة", R.drawable.school));
        wordList.add(new Word("Tree", "شجرة", R.drawable.tree));

        adapter = new WordAdapter(this,wordList);
        recyclerView.setAdapter(adapter);
    }
}

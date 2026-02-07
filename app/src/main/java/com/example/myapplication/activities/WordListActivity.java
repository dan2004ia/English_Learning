package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.R;
import com.example.myapplication.models.Word;
import com.example.myapplication.adapters.WordAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class WordListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WordAdapter adapter;
    private List<Word> wordList;
    private DatabaseHelper dbHelper;
    private FloatingActionButton add_Word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

         recyclerView = findViewById(R.id.recyclerViewWords);
         ImageButton btnBack = findViewById(R.id.btnBack);
         add_Word=findViewById(R.id.add_Word);
        dbHelper = new DatabaseHelper(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

         loadWords();

        add_Word.setOnClickListener(v -> {
            Intent intent = new Intent(WordListActivity.this, AddWordActivity.class);
            startActivity(intent);
        });

         btnBack.setOnClickListener(v -> finish());
    }

     private void loadWords() {
        wordList = dbHelper.getAllWords();

         if (wordList.isEmpty()) {
            dbHelper.addWord(new Word("Cloud", "غيمة", R.drawable.cloud));
            dbHelper.addWord(new Word("Table", "طاولة", R.drawable.table));
            dbHelper.addWord(new Word("Laptop", "لابتوب", R.drawable.laptop));
            wordList = dbHelper.getAllWords();
        }

        adapter = new WordAdapter(wordList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

         loadWords();
    }
}

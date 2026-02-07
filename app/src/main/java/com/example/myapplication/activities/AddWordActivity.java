package com.example.myapplication.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.R;
import com.example.myapplication.models.Word;

public class AddWordActivity extends AppCompatActivity {

    private EditText etEng, etAra;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        etEng = findViewById(R.id.etEnglishWord);
        etAra = findViewById(R.id.etArabicMeaning);
        Button btnSave = findViewById(R.id.btnSaveWord);
        ImageButton btnBack = findViewById(R.id.btnCancel);
        db = new DatabaseHelper(this);
        btnSave.setOnClickListener(v -> {
            String e = etEng.getText().toString().trim().toLowerCase();
            String a = etAra.getText().toString().trim();

            if (!e.isEmpty() && !a.isEmpty()) {


                int imageRes = getResources().getIdentifier(e, "drawable", getPackageName());

                 if (imageRes == 0) {
                    imageRes = R.drawable.laptop;
                }
                // --------------------------------------------------

                db.addWord(new Word(e, a, imageRes));
                Toast.makeText(this, "Saved with matching image!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });



        btnBack.setOnClickListener(v -> finish());
    }
}


package com.example.myapplication.activities;

import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class AboutActivity extends AppCompatActivity {

    private ImageButton btnBackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btnBackHome = findViewById(R.id.btnBack);
        btnBackHome.setOnClickListener(v -> finish());
    }
}





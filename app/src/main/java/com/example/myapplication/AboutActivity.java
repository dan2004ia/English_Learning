
package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    private ImageButton btnBackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

         btnBackHome = findViewById(R.id.btnBack);
        btnBackHome.setOnClickListener(v -> finish());
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}


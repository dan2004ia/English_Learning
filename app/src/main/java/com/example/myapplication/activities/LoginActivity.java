package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email_et, password_et;
    private Button login_btn;
    private TextView tv_signup_prompt;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_et = findViewById(R.id.email_et);
        password_et = findViewById(R.id.password_et);
        login_btn = findViewById(R.id.login_btn);
        tv_signup_prompt = findViewById(R.id.tv_signup_prompt);

        mAuth = FirebaseAuth.getInstance();

         login_btn.setOnClickListener(v -> {
            String email = email_et.getText().toString().trim();
            String password = password_et.getText().toString().trim();

            if (!email.isEmpty() && !password.isEmpty()) {
                 mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(this, "Welcome Back!", Toast.LENGTH_SHORT).show();
                                 startActivity(new Intent(this, HomeActivity2.class));
                                finish();
                            } else {
                                Toast.makeText(this, "Login Failed! Check your data.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

         tv_signup_prompt.setOnClickListener(v -> {
            startActivity(new Intent(this, SignUpActivity.class));
        });
    }
}
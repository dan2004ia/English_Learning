package com.example.myapplication.activities;

import android.content.Intent; // <-- (مهم) قم بإضافة هذا السطر
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText et_email, et_password;
    private Button btn_signup_login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btn_signup_login = findViewById(R.id.btn_signup_login);

        mAuth = FirebaseAuth.getInstance();

        btn_signup_login.setOnClickListener(v -> {
            String email = et_email.getText().toString().trim();
            String password = et_password.getText().toString().trim();

            if (!email.isEmpty() && password.length() >= 6) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, task -> {
                             if (task.isSuccessful()) {
                                 Toast.makeText(this, "Registration Successful! Welcome!", Toast.LENGTH_SHORT).show();

                                 Intent intent = new Intent(SignUpActivity.this, HomeActivity2.class);

                                 intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                                 startActivity(intent);

                                 finish();

                            } else {
                                 Toast.makeText(this, "Error: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            } else {
                Toast.makeText(this, "Enter valid Email and 6+ char Password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

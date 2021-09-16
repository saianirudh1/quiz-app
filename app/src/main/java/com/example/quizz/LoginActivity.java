package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.SignInButton;

public class LoginActivity extends AppCompatActivity {

    EditText userEmail, userPassword;
    TextView forgotPassword, signUp;
    Button signIn;
    SignInButton googleSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = findViewById(R.id.editTextUserEmail);
        userPassword = findViewById(R.id.editTextUserPassword);
        forgotPassword = findViewById(R.id.textViewForgotPassword);
        signIn = findViewById(R.id.buttonUserLogin);
        googleSignIn = findViewById(R.id.buttonUserGoogleLogin);
        signUp = findViewById(R.id.textViewSignUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signUpIntent);
            }
        });
    }
}
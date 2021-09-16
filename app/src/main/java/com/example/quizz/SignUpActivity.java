package com.example.quizz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    EditText signUpEmail, signUpPassword;
    Button signUp;
    ProgressBar signUpProgress;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpEmail = findViewById(R.id.editTextSignUpEmail);
        signUpPassword = findViewById(R.id.editTextSignUpPassword);
        signUp = findViewById(R.id.buttonSignUp);
        signUpProgress = findViewById(R.id.progressBarSignUp);

        signUpProgress.setVisibility(View.INVISIBLE);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = signUpEmail.getText().toString();
                String password = signUpPassword.getText().toString();

                if (!isInputValid(email, password)) {
                    return;
                }

                signUpProgress.setVisibility(View.VISIBLE);
                addUser(email, password);
            }
        });
    }

    private boolean isInputValid(String email, String password) {
        if (email.isEmpty() || !email.contains("@")) {
            Toast.makeText(SignUpActivity.this, getResources().getText(R.string.invalid_email).toString(), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.isEmpty() || password.length() <= 5) {
            Toast.makeText(SignUpActivity.this, getResources().getText(R.string.invalid_password).toString(), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void addUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            signUp.setClickable(false);
                            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                            startActivity(intent);
                            signUpProgress.setVisibility(View.INVISIBLE);
                            finish();
                        } else {
                            Toast.makeText(SignUpActivity.this, getResources().getText(R.string.sign_up_failed).toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
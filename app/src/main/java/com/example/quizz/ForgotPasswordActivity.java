package com.example.quizz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText forgotEmail;
    Button forgotButton;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        forgotEmail = findViewById(R.id.editTextForgot);
        forgotButton = findViewById(R.id.buttonForgot);

        String email = forgotEmail.getText().toString();
        resetPassword(email);

    }

    private void resetPassword(String email){
        mAuth.sendPasswordResetEmail(email).
                addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ForgotPasswordActivity.this, "Sent an email to reset your password", Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(ForgotPasswordActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
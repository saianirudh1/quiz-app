package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class QuizzActivity extends AppCompatActivity {

    TextView time, correct, wrong;
    TextView question, a, b, c, d;
    Button next, finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        time = findViewById(R.id.textViewTimeCounter);
        correct = findViewById(R.id.textViewCorrectAnswerCount);
        wrong = findViewById(R.id.textViewWrongAnswerCount);

        question = findViewById(R.id.textViewQuestion);
        a = findViewById(R.id.textViewA);
        b = findViewById(R.id.textViewB);
        c = findViewById(R.id.textViewC);
        d = findViewById(R.id.textViewD);

        next = findViewById(R.id.buttonNext);
        finish = findViewById(R.id.buttonFinish);
    }
}
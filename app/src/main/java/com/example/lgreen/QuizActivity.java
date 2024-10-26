package com.example.lgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView textQuestion;
    private RadioGroup radioGroup;
    private RadioButton radioOption1, radioOption2;
    private ImageView backIcon;  // Declare backIcon
    private int currentQuestionIndex = 0;

    private String[] questions = {
            "Question 1: Which of the following is a renewable energy source?",
            "Question 2: What can be recycled?"
    };

    private String[][] options = {
            {"Solar energy", "Coal"},
            {"Glass", "Plastic"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textQuestion = findViewById(R.id.text_question);
        radioGroup = findViewById(R.id.radio_group);
        radioOption1 = findViewById(R.id.radio_option1);
        radioOption2 = findViewById(R.id.radio_option2);
        backIcon = findViewById(R.id.back_icon);  // Initialize backIcon

        loadQuestion();

        // Handle back icon click
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goHome();
            }
        });
    }

    public void goHome() {
        Intent intent = new Intent(QuizActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void goBack(View view) {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            loadQuestion();
        } else {
            Toast.makeText(this, "You are at the first question!", Toast.LENGTH_SHORT).show();
        }
    }

    public void answerQuestion(View view) {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select an answer!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (currentQuestionIndex < questions.length - 1) {
            currentQuestionIndex++;
            loadQuestion();
        } else {
            Toast.makeText(this, "You have reached the end of the quiz!", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.length) {
            textQuestion.setText(questions[currentQuestionIndex]);
            radioOption1.setText(options[currentQuestionIndex][0]);
            radioOption2.setText(options[currentQuestionIndex][1]);
            radioGroup.clearCheck();  // Clear previous selection
        }
    }
}

package com.example.lgreen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Tìm TextView bằng ID
        TextView loginTextView = findViewById(R.id.textViewLogin);

        // Thiết lập sự kiện onClickListener
        loginTextView.setOnClickListener(v -> {
            // Tạo Intent để điều hướng đến LoginActivity
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent); // Bắt đầu LoginActivity
        });
    }
}

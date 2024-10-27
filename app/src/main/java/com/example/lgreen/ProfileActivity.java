package com.example.lgreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    // Declare ImageViews and EditTexts
    ImageView edtUsername, edtPass, edtMobile, edtEmail, edtAddress, edtGender;
    EditText etUsername, etPassword, etMobile, etEmail, etAddress,etGender;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ImageView back_gift = findViewById(R.id.back_gift);
        back_gift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        // Enable immersive mode
        enableImmersiveMode();

        // Initialize EditTexts
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etMobile = findViewById(R.id.etMobile);
        etEmail = findViewById(R.id.etEmail);
        etAddress = findViewById(R.id.etAddress);
        etGender = findViewById(R.id.etGender);
        // Initialize ImageViews (edit icons)
        edtUsername = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPass);
        edtMobile = findViewById(R.id.edtMobile);
        edtEmail = findViewById(R.id.edtEmail);
        edtAddress = findViewById(R.id.edtAddress);
        edtGender = findViewById(R.id.edtGender);

        // Set click listeners for each edit icon
        edtUsername.setOnClickListener(v -> {
            etUsername.setEnabled(true);
            etUsername.requestFocus();
        });

        edtPass.setOnClickListener(v -> {
            etPassword.setEnabled(true);
            etPassword.requestFocus();
        });

        edtMobile.setOnClickListener(v -> {
            etMobile.setEnabled(true);
            etMobile.requestFocus();
        });

        edtEmail.setOnClickListener(v -> {
            etEmail.setEnabled(true);
            etEmail.requestFocus();
        });

        edtAddress.setOnClickListener(v -> {
            etAddress.setEnabled(true);
            etAddress.requestFocus();
        });

        edtGender.setOnClickListener(v -> {
            edtGender.setEnabled(true);
            edtGender.requestFocus();
        });
    }

    // Method to enable immersive mode
    private void enableImmersiveMode() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            enableImmersiveMode();
        }
    }
}

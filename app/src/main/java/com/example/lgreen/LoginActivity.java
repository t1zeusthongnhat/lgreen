package com.example.lgreen;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity
{
    EditText editTextPassword;
    ImageView ivShowHidePassword;
    TextView tvSignUpNow;
    boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextPassword = findViewById(R.id.editTextTextPassword);
        ivShowHidePassword = findViewById(R.id.ivShowHidePassword);
        tvSignUpNow = findViewById(R.id.tvSignUpNow);  // Thêm TextView "Sign up now"

        // Xử lý sự kiện ẩn/hiện mật khẩu
        ivShowHidePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    // Ẩn mật khẩu
                    editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    ivShowHidePassword.setImageResource(R.drawable.baseline_remove_red_eye_24);
                } else {
                    // Hiển thị mật khẩu
                    editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                    ivShowHidePassword.setImageResource(R.drawable.baseline_remove_red_eye_24);
                }
                // Di chuyển con trỏ về cuối
                editTextPassword.setSelection(editTextPassword.length());
                isPasswordVisible = !isPasswordVisible;
            }
        });

        // Xử lý sự kiện khi nhấn vào "Sign up now"
        tvSignUpNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến màn hình đăng ký (RegisterActivity)
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}

package com.example.lgreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileActivity extends AppCompatActivity {
    private Button editProfileButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        EdgeToEdge.enable(this);

        LinearLayout homeLayout = findViewById(R.id.homeLayout);

        // Tìm FloatingActionButton bằng ID
        FloatingActionButton circleHomeButton = findViewById(R.id.circle_home);

        // Thiết lập sự kiện click
        circleHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo một Intent để mở HomeActivity
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout scan_trash_bottom = findViewById(R.id.scan_trash_bottom);

        scan_trash_bottom.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, TrashScanActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editProfileButton = findViewById(R.id.btnEdit);
        editProfileButton.setOnClickListener(view -> showEditProfileDialog());
    }

    private void showEditProfileDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.edit_profile_dialog, null);
        builder.setView(dialogLayout);
        builder.setTitle("Edit Profile");
        builder.setPositiveButton("Save", (dialog, which) -> {
            EditText editPassword = dialogLayout.findViewById(R.id.editPassword);
            EditText editMobile = dialogLayout.findViewById(R.id.editMobile);
            EditText editTel = dialogLayout.findViewById(R.id.editTel);
            EditText editAddress = dialogLayout.findViewById(R.id.editAddress);
            EditText editUsername = dialogLayout.findViewById(R.id.editUsername);

            // Handle save logic here
        });
        builder.setNegativeButton("Cancel", null);

        AlertDialog dialog = builder.create();
        dialog.getWindow().setDimAmount(0.5f); // Set dim amount for background
        dialog.show();
    }
}

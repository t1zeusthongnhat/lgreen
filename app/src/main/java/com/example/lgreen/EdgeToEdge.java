package com.example.lgreen;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;

import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class EdgeToEdge {
    public static void enable(Activity activity) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowCompat.setDecorFitsSystemWindows(window, false);
            window.getDecorView().setOnApplyWindowInsetsListener((view, windowInsets) -> {
                WindowInsetsCompat insets = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
                view.setPadding(0, insets.getInsets(WindowInsetsCompat.Type.systemBars()).top, 0, insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
                return windowInsets;
            });
        } else {
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            );
        }
    }
}
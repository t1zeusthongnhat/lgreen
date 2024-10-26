package com.example.lgreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView iconMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize UI components
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        iconMenu = findViewById(R.id.iconMenu);

        // Handle iconMenu click to open or close the Drawer
        iconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        // Handle item selection in NavigationView (Drawer Menu)
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                // Log selection for debugging
                Log.d(TAG, "MenuItem selected: " + item.getTitle());

                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        if (id == R.id.nav_home) {
                            Log.d(TAG, "Navigating to HomeActivity");
                            startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                        } else if (id == R.id.nav_profile) {
                            Log.d(TAG, "Navigating to ProfileActivity");
                            startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                        } else if (id == R.id.nav_settings) {
                            Log.d(TAG, "Navigating to DictionaryActivity");
                            startActivity(new Intent(HomeActivity.this, DictionaryActivity.class));
                        } else if (id == R.id.nav_logout) {
                            Log.d(TAG, "Logging out");
                            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }

                        // Close Drawer after item selection
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                });

                return true;
            }
        });

        // Set up other button actions in HomeActivity
        setupOtherButtons();
    }


    // Hàm thiết lập các sự kiện cho các nút khác

    private void setupOtherButtons() {
        ImageView notice = findViewById(R.id.iconBell);
        AppCompatButton scan = findViewById(R.id.scan_trash_layout);
        AppCompatButton play = findViewById(R.id.btnLearnPlay);
        AppCompatButton btnGift = findViewById(R.id.btn_gift);
        ImageView dict = findViewById(R.id.garbage_dictionary_layout);
        LinearLayout profile = findViewById(R.id.userLayout);
        LinearLayout scanbottom = findViewById(R.id.scan_trash_bottom);
        ImageView profileUser = findViewById(R.id.userImage);
        LinearLayout mygift = findViewById(R.id.mygift);

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, NoticeFormActivity.class));
            }
        });
        mygift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MyGiftActivity.class));
            }
        });
        btnGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, GiftActivity.class));
            }
        });
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, TrashScanActivity.class));
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, QuizActivity.class));
            }
        });
        dict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, DictionaryActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            }
        });
        profileUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            }
        });
        scanbottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, TrashScanActivity.class));
            }
        });
    }

    // Xử lý khi nhấn nút Back, nếu Drawer đang mở thì đóng nó
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

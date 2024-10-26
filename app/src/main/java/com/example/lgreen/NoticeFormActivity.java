package com.example.lgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NoticeFormActivity extends AppCompatActivity {
    ImageView backHome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_list);

        backHome = findViewById(R.id.back_notify);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoticeFormActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        setupNotificationClicks();
    }

    private void setupNotificationClicks() {
        LinearLayout notice1 = findViewById(R.id.notice_1);
        LinearLayout notice2 = findViewById(R.id.notice_2);
        LinearLayout notice3 = findViewById(R.id.notice_3);

        notice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(1, "Tiêu đề Thông báo 1", "Nội dung thông báo đầu tiên...", "Hà Nội, Việt Nam", R.drawable.th_milk);
            }
        });


        notice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(2, "Notification Title 2", "Notification content for the second notification...", "Cầu Giấy, Hà Nội", R.drawable.coca);
            }
        });

        notice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(3, "Notification Title 3", "Notification content for the third notification...", "Hải Dương", R.drawable.paper);
            }
        });
    }

    private void openDetailActivity(int id, String title, String content, String address, int imageResId) {
        Intent intent = new Intent(NoticeFormActivity.this, NoticeDetailActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("title", title);
        intent.putExtra("content", content);
        intent.putExtra("address", address);
        intent.putExtra("imageResId", imageResId);
        startActivity(intent);
    }
}
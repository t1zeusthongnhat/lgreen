package com.example.lgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class DictionaryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText editText;
    private ImageView sendButton;
    private MessageAdapter messageAdapter;
    private List<Message> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.message_text_text);
        sendButton = findViewById(R.id.send_btn);

        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(messageAdapter);

        ImageView btnback = findViewById(R.id.back_dictionary);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DictionaryActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = editText.getText().toString().trim();
                if (!question.isEmpty()) {
                    // Thêm câu hỏi vào danh sách
                    messageList.add(new Message(question, true));
                    messageAdapter.notifyItemInserted(messageList.size() - 1);
                    recyclerView.scrollToPosition(messageList.size() - 1);

                    // Xóa nội dung EditText
                    editText.setText("");

                    // Hiển thị câu trả lời giả lập
                    getAnswer(question);
                }
            }
        });
    }

    private void getAnswer(String question) {
        // Thêm câu trả lời giả lập sau khi hỏi
        String answer = "This is a sample answer for: " + question;
        messageList.add(new Message(answer, false));
        messageAdapter.notifyItemInserted(messageList.size() - 1);
        recyclerView.scrollToPosition(messageList.size() - 1);
    }
}
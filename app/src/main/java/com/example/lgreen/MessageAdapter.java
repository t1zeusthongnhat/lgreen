package com.example.lgreen;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private List<Message> messageList;

    // Constructor
    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.messageContent.setText(message.getContent());

        RelativeLayout.LayoutParams iconParams = (RelativeLayout.LayoutParams) holder.icon.getLayoutParams();
        RelativeLayout.LayoutParams messageParams = (RelativeLayout.LayoutParams) holder.messageContent.getLayoutParams();

        // Điều chỉnh giao diện và biểu tượng dựa trên user/bot
        if (message.isUser()) {
            holder.icon.setImageResource(R.drawable.icon_user);
            holder.messageContent.setBackgroundResource(R.drawable.user_message_background);

            // Đặt icon và text sang bên phải
            iconParams.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
            iconParams.addRule(RelativeLayout.ALIGN_PARENT_START, 0);
            messageParams.addRule(RelativeLayout.START_OF, R.id.icon);
            messageParams.addRule(RelativeLayout.END_OF, 0);

        } else {
            holder.icon.setImageResource(R.drawable.bot);
            holder.messageContent.setBackgroundResource(R.drawable.bot_message_background);

            // Đặt icon và text sang bên trái
            iconParams.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE);
            iconParams.addRule(RelativeLayout.ALIGN_PARENT_END, 0);
            messageParams.addRule(RelativeLayout.END_OF, R.id.icon);
            messageParams.addRule(RelativeLayout.START_OF, 0);
        }
        holder.icon.setLayoutParams(iconParams);
        holder.messageContent.setLayoutParams(messageParams);
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView messageContent;
        ImageView icon;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            messageContent = itemView.findViewById(R.id.messageContent);
            icon = itemView.findViewById(R.id.icon);
        }
    }
}

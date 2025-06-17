package com.moutamid.misshelper.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.misshelper.R;
import com.moutamid.misshelper.activities.NotificationActivity;
import com.moutamid.misshelper.model.NotificationModel;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private List<NotificationModel> itemList;

    public NotificationAdapter(List<NotificationModel> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotificationModel item = itemList.get(position);
        holder.notification_details.setText(item.getNotificationDetails());
        holder.notification_title.setText(item.getNotificationTitle());
        holder.notification_time.setText(item.getNotificationTime());
        holder.icon.setImageResource(item.getIcon());


        holder.icon.setBackgroundTintList(ContextCompat.getColorStateList(holder.itemView.getContext(), item.getColorResId()));
        holder.delete_notification.setOnClickListener(v -> {
            itemList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, itemList.size());

            if (itemList.isEmpty()) {
                NotificationActivity.viewEmpty.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView notification_title;
        TextView notification_details;
        TextView notification_time, delete_notification;
        ImageView icon;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            notification_details = itemView.findViewById(R.id.notification_details);
            notification_title = itemView.findViewById(R.id.notification_title);
            notification_time = itemView.findViewById(R.id.notification_time);
            delete_notification = itemView.findViewById(R.id.delete_notification);
            icon = itemView.findViewById(R.id.icon);

        }
    }
}

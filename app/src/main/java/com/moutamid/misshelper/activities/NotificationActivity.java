package com.moutamid.misshelper.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.misshelper.R;
import com.moutamid.misshelper.adapter.NotificationAdapter;
import com.moutamid.misshelper.model.NotificationModel;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {
    public static RecyclerView recyclerViewNew;
    List<NotificationModel> newList = new ArrayList<>();
    NotificationAdapter notificationAdapter;
    public static LinearLayout viewEmpty;
    ImageView back_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        back_icon = findViewById(R.id.back_icon);
        viewEmpty = findViewById(R.id.viewEmpty);
        recyclerViewNew = findViewById(R.id.recyclerViewNew);
        newList.clear();
        newList.add(new NotificationModel("Application sent", R.drawable.profile, "Your application for Housemaid has been submitted successfully. Stay tuned for updates.", "23 minutes ago", R.color.light_blue));
        newList.add(new NotificationModel("New Job Posted:\n" +
                "House Maid Needed", R.drawable.profile, "A new vacancy for House Maid has just been added. Apply now to secure your spot before it fills!", "1 hour ago", R.color.pink));
        newList.add(new NotificationModel("Application sent", R.drawable.profile, "Your application for Lady Driver has been submitted successfully. Stay tuned for updates.", "2 hours ago", R.color.light_blue));
        newList.add(new NotificationModel("Document Expiry Alert", R.drawable.alert, "Your health certificate is about to expire. Please upload the updated document to avoid delays in your application process.", "5 hours ago", R.color.red));
        recyclerViewNew.setVisibility(View.VISIBLE);
        recyclerViewNew.setLayoutManager(new LinearLayoutManager(this));
        notificationAdapter = new NotificationAdapter(newList);
        recyclerViewNew.setAdapter(notificationAdapter);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
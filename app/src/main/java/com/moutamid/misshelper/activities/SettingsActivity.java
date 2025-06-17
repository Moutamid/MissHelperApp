package com.moutamid.misshelper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.moutamid.misshelper.R;
import com.moutamid.misshelper.bottomsheets.ContactUsBottomSheet;
import com.moutamid.misshelper.bottomsheets.LogoutBottomSheet;

public class SettingsActivity extends AppCompatActivity {
    RelativeLayout change_password, contact_support, logout, dark_mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        contact_support = findViewById(R.id.contact_support);
        change_password = findViewById(R.id.change_password);
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogoutBottomSheet bottomSheet = new LogoutBottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "ContactUsBottomSheet");


            }
        });
        contact_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactUsBottomSheet bottomSheet = new ContactUsBottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "ContactUsBottomSheet");


            }
        });
        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, NewPasswordActivity.class));
            }
        });

    }
}
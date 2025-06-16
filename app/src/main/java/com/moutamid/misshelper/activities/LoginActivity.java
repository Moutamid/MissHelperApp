package com.moutamid.misshelper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.moutamid.misshelper.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        
        setContentView(R.layout.activity_login);

    }

    public void forgot_password(View view) {
        startActivity(new Intent(this, ForgotPassowrdActivity.class));
    }


    public void sign_up(View view) {
        startActivity(new Intent(this, WelcomeActivity.class));


    }
}
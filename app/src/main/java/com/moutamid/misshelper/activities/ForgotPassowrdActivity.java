package com.moutamid.misshelper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.moutamid.misshelper.R;

public class ForgotPassowrdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.activity_forgot_passowrd);
    }

    public void login(View view) {
        startActivity(new Intent(this, WelcomeActivity.class));
    }

    public void sendCode(View view) {
        startActivity(new Intent(this, OTPActivity.class));

    }
}
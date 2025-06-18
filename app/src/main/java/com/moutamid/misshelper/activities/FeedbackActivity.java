package com.moutamid.misshelper.activities;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.moutamid.misshelper.R;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ImageView[] emojis = new ImageView[5];
        TextView[] labels = new TextView[5];

        int[] emojiIds = {
                R.id.emoji1, R.id.emoji2, R.id.emoji3, R.id.emoji4, R.id.emoji5
        };

        int[] labelIds = {
                R.id.text1, R.id.text2, R.id.text3, R.id.text4, R.id.text5
        };

        for (int i = 0; i < 5; i++) {
            final int index = i;
            emojis[i] = findViewById(emojiIds[i]);
            labels[i] = findViewById(labelIds[i]);

            emojis[i].setOnClickListener(v -> {
                for (int j = 0; j < 5; j++) {
                    if (j == index) {
                        // Selected item
                        emojis[j].setColorFilter(Color.WHITE); // icon color
                        emojis[j].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(getString(R.color.app_color)))); // background
                        labels[j].setVisibility(View.VISIBLE);
                    } else {
                        // Reset others
                        emojis[j].setColorFilter(null); // reset tint
                        emojis[j].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#388E8DD0"))); // default color
                        labels[j].setVisibility(View.INVISIBLE);
                    }
                }
            });
        }
    }


    public void submit(View view) {
    }
}
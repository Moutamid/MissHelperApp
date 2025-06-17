package com.moutamid.misshelper.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.misshelper.model.Item;
import com.moutamid.misshelper.R;
import com.moutamid.misshelper.adapter.RecentsSearchAdapter;
import com.moutamid.misshelper.adapter.SearchedItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecentSearchesActivity extends AppCompatActivity {

    public static RecyclerView recyclerView;
    public static RecyclerView recyclerViewNew;
    public static LinearLayout viewEmpty;
    RecentsSearchAdapter adapter;
    SearchedItemAdapter newAdapter;
    EditText editTextSearch;
    List<String> itemList = new ArrayList<>();
    List<Item> newList = new ArrayList<>();
    public static TextView recent_search, clear;
    ImageView back_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_searches);
        viewEmpty = findViewById(R.id.viewEmpty);
        back_icon = findViewById(R.id.back_icon);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewNew = findViewById(R.id.recyclerViewNew);
        editTextSearch = findViewById(R.id.editTextSearch);
        recent_search = findViewById(R.id.recent_search);
        clear = findViewById(R.id.clear);
        itemList.add("Jobs for driver");
        itemList.add("ladydriver");
        itemList.add("housemaid");
        itemList.add("driver");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecentsSearchAdapter(itemList);
        recyclerView.setAdapter(adapter);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        adapter.setItemClickListener(position -> {
            recyclerView.setVisibility(View.GONE);
            newList.clear();
            newList.add(new Item("Jobs for Driver", R.drawable.profile, "Must have a valid license with minimum 2 years of experience."));
            newList.add(new Item("Lady Driver", R.drawable.profile, "Safe and reliable driver for children."));
            recyclerViewNew.setVisibility(View.VISIBLE);
            recyclerViewNew.setLayoutManager(new LinearLayoutManager(this));
            newAdapter = new SearchedItemAdapter( newList, this);
            recyclerViewNew.setAdapter(newAdapter);
        });

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filterList(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }
}

package com.moutamid.misshelper.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.misshelper.R;
import com.moutamid.misshelper.activities.RecentSearchesActivity;

import java.util.ArrayList;
import java.util.List;

public class RecentsSearchAdapter extends RecyclerView.Adapter<RecentsSearchAdapter.ViewHolder> {

    private List<String> stringList;
    private List<String> fullList;
    private String filter = "";

    public RecentsSearchAdapter(List<String> stringList) {
        this.stringList = new ArrayList<>(stringList);
        this.fullList = new ArrayList<>(stringList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recent_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = stringList.get(position);
        TextView textView = holder.textViewString;

        if (filter.isEmpty()) {
            textView.setText(item);
        } else {
            int start = item.toLowerCase().indexOf(filter.toLowerCase());
            if (start >= 0) {
                SpannableStringBuilder builder = new SpannableStringBuilder(item);
                builder.setSpan(new StyleSpan(Typeface.BOLD), start, start + filter.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                builder.setSpan(new ForegroundColorSpan(Color.BLACK), start, start + filter.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                textView.setText(builder);
            } else {
                textView.setText(item);
            }
        }

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewString;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewString = itemView.findViewById(R.id.textViewString);
            itemView.setOnClickListener(v -> {
                // Handle click event
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(getAdapterPosition());
                }
            });  }

    }

    // Filter method
    public void filterList(String text) {
        filter = text.trim();

        if (filter.isEmpty()) {
            stringList = new ArrayList<>(fullList);
        } else {
            List<String> newList = new ArrayList<>();
            for (String item : fullList) {
                if (item.toLowerCase().contains(filter.toLowerCase())) {
                    newList.add(item);
                }
            }
            stringList = newList;
        }
        notifyDataSetChanged();
        if (stringList.isEmpty()) {
           RecentSearchesActivity.viewEmpty.setVisibility(View.VISIBLE);
            RecentSearchesActivity.recyclerView.setVisibility(View.GONE);
            RecentSearchesActivity.recyclerViewNew.setVisibility(View.GONE);
            RecentSearchesActivity.recent_search.setVisibility(View.GONE);
            RecentSearchesActivity.clear.setVisibility(View.GONE);
        } else {
            RecentSearchesActivity.viewEmpty.setVisibility(View.GONE);
            RecentSearchesActivity.recyclerView.setVisibility(View.VISIBLE);
            RecentSearchesActivity.recyclerViewNew.setVisibility(View.GONE);
            RecentSearchesActivity.recent_search.setVisibility(View.VISIBLE);
            RecentSearchesActivity.clear.setVisibility(View.VISIBLE);
        }

    }
    public interface ItemClickListener {
        void onItemClick(int position);
    }

    private static ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}

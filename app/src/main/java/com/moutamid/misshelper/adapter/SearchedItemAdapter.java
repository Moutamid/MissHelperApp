package com.moutamid.misshelper.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.misshelper.R;
import com.moutamid.misshelper.activities.JobDetailsActivity;
import com.moutamid.misshelper.model.Item;

import java.util.List;

public class SearchedItemAdapter extends RecyclerView.Adapter<SearchedItemAdapter.ViewHolder> {

    private List<Item> itemList;
    Context context;

    public SearchedItemAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.job_title.setText(item.getName());
        holder.job_details.setText(item.getDetails());
        holder.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, JobDetailsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView job_title;
        TextView job_details, details;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            job_title = itemView.findViewById(R.id.job_title);
            job_details = itemView.findViewById(R.id.job_details);
            details = itemView.findViewById(R.id.details);
        }
    }
}

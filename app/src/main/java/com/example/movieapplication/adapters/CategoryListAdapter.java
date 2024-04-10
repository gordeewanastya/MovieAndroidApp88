package com.example.movieapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.movieapplication.R;
import com.example.movieapplication.activities.DetailActivity;
import com.example.movieapplication.domain.GenresItem;
import com.example.movieapplication.domain.ListFilm;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {
    ArrayList<GenresItem> items;
    Context context;

    public CategoryListAdapter(ArrayList<GenresItem> items) {
        this.items = items;
    }

    @NonNull
    @NotNull
    @Override
    public CategoryListAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoryListAdapter.ViewHolder holder, int position) {
        holder.titleText.setText(items.get(position).getName());


        holder.itemView.setOnClickListener(view -> {

        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleText;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.TitleText);
        }
    }
}

package com.example.movieapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.movieapplication.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ActorsListAdapter_2 extends RecyclerView.Adapter<ActorsListAdapter_2.ViewHolder> {
    List<Integer> images;
    Context context;

    public ActorsListAdapter_2(List<Integer> images) {
        this.images = images;
    }

    @NonNull
    @NotNull
    @Override
    public ActorsListAdapter_2.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_actors,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ActorsListAdapter_2.ViewHolder holder, int position) {
        Glide.with(context)
                .load(images.get(position))
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView pic;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.itemImages);
        }
    }
}

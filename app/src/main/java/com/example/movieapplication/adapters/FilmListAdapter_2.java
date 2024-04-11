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
import com.example.movieapplication.domain.Film;
import com.example.movieapplication.domain.ListFilm;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FilmListAdapter_2 extends RecyclerView.Adapter<FilmListAdapter_2.ViewHolder> {
    ArrayList<Film> items;
    Context context;

    public FilmListAdapter_2(ArrayList<Film> items) {
        this.items = items;
    }

    @NonNull
    @NotNull
    @Override
    public FilmListAdapter_2.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_film,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FilmListAdapter_2.ViewHolder holder, int position) {
        holder.titleText.setText(items.get(position).getTitle());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transform(new CenterCrop(),new RoundedCorners(30));

        Glide.with(context)
                .load(items.get(position).getPoster())
                .apply(requestOptions)
                .into(holder.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("id",items.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleText;
        ImageView pic;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.titleText);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
package com.rujira.retrofitfetchdataservicealbums.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rujira.retrofitfetchdataservicealbums.Model.Album;
import com.rujira.retrofitfetchdataservicealbums.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<Album> albumList;

    public MyAdapter(Context context, List<Album> albumList) {
        this.context = context;
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt_user_id.setText(albumList.get(position).getUserId());
        holder.txt_id.setText(albumList.get(position).getId());
        holder.txt_title.setText(albumList.get(position).getTitle().toString());
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_user_id, txt_id, txt_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_user_id = (TextView) itemView.findViewById(R.id.txt_user_id);
            txt_id = (TextView) itemView.findViewById(R.id.txt_id);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);

        }
    }
}

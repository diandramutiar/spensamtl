package com.diandra.spensamtl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {
    Context context;
    List<Berita> list;

    public BeritaAdapter(Context context, List<Berita> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_berita,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textJudulBerita.setText(list.get(position).getJudul());
        Picasso.with(context).load(list.get(position).getImage()).into(holder.imageBerita);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity compatActivity = (AppCompatActivity) v.getContext();
                DetailBeritaFragment detailBeritaFragment = new DetailBeritaFragment();
                Bundle bundle = new Bundle();
                bundle.putString("url", list.get(position).getLink());
                detailBeritaFragment.setArguments(bundle);
                compatActivity.getFragmentManager().beginTransaction().replace(R.id.container,detailBeritaFragment).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textJudulBerita;
        public ImageView imageBerita;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            textJudulBerita = itemView.findViewById(R.id.txt_judulberita);
            imageBerita = itemView.findViewById(R.id.img_berita);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}

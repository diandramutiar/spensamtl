package com.diandra.spensamtl;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

class DetailListBeritaAdapter extends RecyclerView.Adapter<DetailListBeritaAdapter.ViewHolder> {

    private Context context;
    private List<DetailListBerita> list;

    public DetailListBeritaAdapter(Context context, List<DetailListBerita> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_detail_berita,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textKonten.setText(list.get(position).getKonten());
        holder.textJudul.setText(list.get(position).getJudul());
        Picasso.with(context).load(list.get(position).getGambar()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textJudul;
        public TextView textKonten;
        public ImageView imageView;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            textJudul = itemView.findViewById(R.id.txt_judulberita);
            textKonten = itemView.findViewById(R.id.txt_isiberita);
            imageView = itemView.findViewById(R.id.img_berita);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}

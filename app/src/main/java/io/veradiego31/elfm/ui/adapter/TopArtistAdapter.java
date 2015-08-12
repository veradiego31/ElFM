package io.veradiego31.elfm.ui.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.veradiego31.elfm.R;
import io.veradiego31.elfm.domain.Artista;

public class TopArtistAdapter extends RecyclerView.Adapter<TopArtistAdapter.TopArtistViewHolder>{

    ArrayList<Artista> artistas;
    Context context;

    public TopArtistAdapter(Context context) {
        this.context = context;
        this.artistas = new ArrayList<>();
    }

    @Override
    public TopArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_top_artist, parent, false);

        return new TopArtistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopArtistViewHolder holder, int position) {
        Artista currentArtist = artistas.get(position);
        holder.setArtistName(currentArtist.getName());

        if(currentArtist.getUrlMediumImage() != null){
            holder.setArtistImage(currentArtist.getUrlMediumImage());
        }else {
            holder.setArtistImageDefault();
        }
    }

    @Override
    public int getItemCount() {
        return artistas.size();
    }

    public void addAll(@NonNull ArrayList<Artista> artistas){
        if(artistas == null){
            throw new NullPointerException("Este item no puede ser nulo");
        }
        this.artistas.addAll(artistas);
        notifyDataSetChanged();
    }

    public class TopArtistViewHolder extends RecyclerView.ViewHolder {

        TextView artistName;
        ImageView artistImage;
        TextView artistPlayCount;
        TextView artistListeners;

        public TopArtistViewHolder(View itemView) {
            super(itemView);

            artistName = (TextView) itemView.findViewById(R.id.text_name);
            artistImage = (ImageView) itemView.findViewById(R.id.img_top_artist);
            artistListeners = (TextView) itemView.findViewById(R.id.txt_listencount);
            artistPlayCount = (TextView) itemView.findViewById(R.id.txt_playcount);

        }

        public  void setArtistName(String name){
            artistName.setText(name);
        }
        public void setArtistImage(String urlImage){
            Picasso.with(context)
                    .load(urlImage)
                    .placeholder(R.drawable.artist_img)
                    .into(artistImage);

        }

        public void setArtistImageDefault(){
            Picasso.with(context)
                    .load(R.drawable.artist_img)
                    .into(artistImage);
        }

        public void setArtistPlayCount(String playCount){
            artistPlayCount.setText(playCount);
        }

        public void setArtistListeners(String listeners){
            artistListeners.setText(listeners);
        }
    }
}

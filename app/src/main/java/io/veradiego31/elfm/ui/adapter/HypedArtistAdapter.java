package io.veradiego31.elfm.ui.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.veradiego31.elfm.R;
import io.veradiego31.elfm.domain.Artista;

public class HypedArtistAdapter extends RecyclerView.Adapter<HypedArtistAdapter.HypedArtistViewHolder>{

    ArrayList<Artista> artistas;
    Context context;

    public HypedArtistAdapter(Context context) {
        this.context = context;
        this.artistas = new ArrayList<>();
    }

    @Override
    public HypedArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                            .inflate(R.layout.item_hyped_artist, parent, false);

        return new HypedArtistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HypedArtistViewHolder holder, int position) {
            Artista currentArtist = artistas.get(position);
            holder.setArtistName(currentArtist.getName());
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

    public class HypedArtistViewHolder extends RecyclerView.ViewHolder {

        TextView artistName;
        ImageView artistImage;

        public HypedArtistViewHolder(View itemView) {
            super(itemView);

            artistName = (TextView) itemView.findViewById(R.id.text_name);
            artistImage = (ImageView) itemView.findViewById(R.id.img_artist);


        }

        public  void setArtistName(String name){
            artistName.setText(name);
        }
    }


}

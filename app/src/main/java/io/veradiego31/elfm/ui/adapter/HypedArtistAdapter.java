package io.veradiego31.elfm.ui.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.veradiego31.elfm.R;

public class HypedArtistAdapter extends RecyclerView.Adapter<HypedArtistAdapter.HypedArtistViewHolder>{

    Context context;

    public HypedArtistAdapter(Context context) {
        this.context = context;
    }

    @Override
    public HypedArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_hyped_artist, parent, false);

        return null;
    }

    @Override
    public void onBindViewHolder(HypedArtistViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HypedArtistViewHolder extends RecyclerView.ViewHolder {

        TextView artistName;
        ImageView artistImage;

        public HypedArtistViewHolder(View itemView) {
            super(itemView);
        }
    }


}

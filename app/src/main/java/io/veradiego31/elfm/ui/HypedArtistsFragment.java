package io.veradiego31.elfm.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.veradiego31.elfm.R;


public class HypedArtistsFragment extends Fragment {
    public static final String LOG_TAG = HypedArtistsFragment.class.getName();
    private RecyclerView mHypedArtistLists;
    public static final int NUM_COLUMNS = 2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_hyped_artists, container, false);
        mHypedArtistLists = (RecyclerView) root.findViewById(R.id.hyped_artists_lists);
        setupArtistList();
        return root;
    }

    private void setupArtistList(){
        mHypedArtistLists.setLayoutManager(new GridLayoutManager(getActivity(), NUM_COLUMNS));
    }
}

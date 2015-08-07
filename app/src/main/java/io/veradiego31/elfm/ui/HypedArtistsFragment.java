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
import io.veradiego31.elfm.io.LastFmApiAdapter;
import io.veradiego31.elfm.io.model.HypedArtistisResponse;
import io.veradiego31.elfm.ui.adapter.HypedArtistAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class HypedArtistsFragment extends Fragment implements Callback<HypedArtistisResponse> {
    public static final String LOG_TAG = HypedArtistsFragment.class.getName();
    private RecyclerView mHypedArtistLists;
    public static final int NUM_COLUMNS = 2;

    private HypedArtistAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new HypedArtistAdapter(getActivity());
    }

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
        mHypedArtistLists.setAdapter(adapter);
        mHypedArtistLists.addItemDecoration(new ItemOffSetDecoration(getActivity(), R.integer.offset));

    }

    @Override
    public void onResume() {
        super.onResume();

        LastFmApiAdapter.getApiService().getHypedArtists(this);
    }

    @Override
    public void success(HypedArtistisResponse hypedArtistisResponse, Response response) {
        adapter.addAll(hypedArtistisResponse.getArtists());
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
}

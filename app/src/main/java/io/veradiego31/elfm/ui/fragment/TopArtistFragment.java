package io.veradiego31.elfm.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.veradiego31.elfm.R;
import io.veradiego31.elfm.io.LastFmApiAdapter;
import io.veradiego31.elfm.io.model.TopArtistResponse;
import io.veradiego31.elfm.ui.adapter.TopArtistAdapter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopArtistFragment extends Fragment {


    private RecyclerView artistList;
    private TopArtistAdapter topArtistAdapter;
    public TopArtistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topArtistAdapter = new TopArtistAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_top_artist, container, false);
        artistList = (RecyclerView) view.findViewById(R.id.top_artists_list);
        setupArtistList();
        return view;
    }

    private void setupArtistList(){
        artistList.setLayoutManager(new LinearLayoutManager(getActivity()));
        artistList.setAdapter(topArtistAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        LastFmApiAdapter.getApiService()
                .getTopArtists()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TopArtistResponse>() {
                    @Override
                    public void call(TopArtistResponse topArtistResponse) {
                        topArtistAdapter.addAll(topArtistResponse.getArtists());
                    }
                });
    }
}

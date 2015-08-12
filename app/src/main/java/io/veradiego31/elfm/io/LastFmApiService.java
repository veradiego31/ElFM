package io.veradiego31.elfm.io;


import io.veradiego31.elfm.io.model.HypedArtistisResponse;
import io.veradiego31.elfm.io.model.TopArtistResponse;
import retrofit.Callback;
import retrofit.http.GET;
import rx.Observable;

public interface LastFmApiService {

    @GET(ApiConstants.URL_HYPED_ARTISTS)
    void getHypedArtists( Callback<HypedArtistisResponse> serverResponse);

    @GET(ApiConstants.URL_TOP_ARTISTS)
    Observable<TopArtistResponse> getTopArtists();

}

package io.veradiego31.elfm.io;


import io.veradiego31.elfm.io.model.HypedArtistisResponse;
import retrofit.Callback;
import retrofit.http.GET;

public interface LastFmApiService {

    @GET(ApiConstants.URL_HYPED_ARTISTS)
    void getHypedArtists( Callback<HypedArtistisResponse> serverResponse);


}

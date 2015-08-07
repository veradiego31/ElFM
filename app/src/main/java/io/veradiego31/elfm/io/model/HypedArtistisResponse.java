package io.veradiego31.elfm.io.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import io.veradiego31.elfm.domain.Artista;


public class HypedArtistisResponse {

    @SerializedName(JsonKeys.ARTISTS_RESULT)
    HypedArtistsResult results;

    public ArrayList<Artista> getArtists(){

        return results.artistas;
    }

    private class HypedArtistsResult{

        @SerializedName(JsonKeys.ARTISTS_ARRAY)
        ArrayList<Artista> artistas;
    }
}

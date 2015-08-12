package io.veradiego31.elfm.io.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import io.veradiego31.elfm.domain.Artista;

public class TopArtistResponse {

    @SerializedName(JsonKeys.ARTISTS_RESULT)
    HypedArtistsResult results;

    public ArrayList<Artista> getArtists(){

        return results.artistas;
    }

    public void setArtists(ArrayList<Artista> artists){
        this.results.artistas = artists;
    }

    private class HypedArtistsResult{

        @SerializedName(JsonKeys.ARTISTS_ARRAY)
        ArrayList<Artista> artistas;
    }
}

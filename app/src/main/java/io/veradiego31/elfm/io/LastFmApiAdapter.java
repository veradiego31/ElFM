package io.veradiego31.elfm.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.veradiego31.elfm.io.deserializer.HypedArtistsDeserializer;
import io.veradiego31.elfm.io.deserializer.TopArtistisDeserializer;
import io.veradiego31.elfm.io.model.HypedArtistisResponse;
import io.veradiego31.elfm.io.model.TopArtistResponse;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;


public class LastFmApiAdapter {

    private static LastFmApiService API_SERVICE;

    public static LastFmApiService getApiService(){

        if(API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstants.URL_BASE_)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .setConverter(buildLastFmApiGsonConverter())
                    .build();

            API_SERVICE = adapter.create(LastFmApiService.class);

        }

        return API_SERVICE;
    }

    private static GsonConverter buildLastFmApiGsonConverter(){

        Gson gsonConv = new GsonBuilder()
                .registerTypeAdapter(HypedArtistisResponse.class, new HypedArtistsDeserializer())
                .registerTypeAdapter(TopArtistResponse.class, new TopArtistisDeserializer())
                .create();

        return new GsonConverter(gsonConv);
    }
}

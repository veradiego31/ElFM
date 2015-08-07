package io.veradiego31.elfm.io;

import retrofit.RestAdapter;


public class LastFmApiAdapter {

    private static LastFmApiService API_SERVICE;

    public static LastFmApiService getApiService(){

        if(API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder().setEndpoint(ApiConstants.URL_BASE_).
                    setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();

            API_SERVICE = adapter.create(LastFmApiService.class);

        }

        return API_SERVICE;
    }
}

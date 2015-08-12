package io.veradiego31.elfm.io;


public class ApiConstants {

    public static final String API_KEY = "522d7a8b23e0c101b8da976b05ccc1ac";

    public static final String URL_BASE_= "http://ws.audioscrobbler.com";

    public static final String PATH_VERSION = "/2.0";

    public static final String PARAM_METHOD = "method";
    public static final String PARAM_FORMAT = "format";
    public static final String PARAM_API_KEY = "api_key";

    public static final String VALUE_JSON = "json";
    public static final String VALUE_HYPED_ARTIST_METHOD = "chart.gethypedartist";
    public static final String VALUE_TOP_ARTIST_METHOD = "chart.gettopartists";

    public static final String URL_HYPED_ARTISTS =  PATH_VERSION + "?" + PARAM_API_KEY + "="+ API_KEY + "&" +
            PARAM_METHOD + "=" + VALUE_HYPED_ARTIST_METHOD + "&"+
            PARAM_FORMAT + "=" + VALUE_JSON;

    public static final String URL_TOP_ARTISTS =  PATH_VERSION + "?" + PARAM_API_KEY + "="+ API_KEY + "&" +
            PARAM_METHOD + "=" + VALUE_TOP_ARTIST_METHOD + "&"+
            PARAM_FORMAT + "=" + VALUE_JSON;




}

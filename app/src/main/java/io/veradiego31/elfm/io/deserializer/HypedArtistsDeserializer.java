package io.veradiego31.elfm.io.deserializer;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import io.veradiego31.elfm.domain.Artista;
import io.veradiego31.elfm.io.model.HypedArtistisResponse;
import io.veradiego31.elfm.io.model.JsonKeys;

public class HypedArtistsDeserializer implements JsonDeserializer<HypedArtistisResponse>{

    @Override
    public HypedArtistisResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


        Gson gson = new Gson();
        HypedArtistisResponse response = gson.fromJson(json, HypedArtistisResponse.class);

        //obtener primero el objeto Artists
        JsonObject artistResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.ARTISTS_RESULT);
        //obtener el array de Artists
        JsonArray artistArray = artistResponseData.getAsJsonArray(JsonKeys.ARTISTS_ARRAY);
        //convertir el JsonArray de Artist a Objetos de la clase Artist
        response.setArtists(extractArtistFromJsonArray(artistArray));


        return response;

    }


    private ArrayList<Artista>  extractArtistFromJsonArray(JsonArray array){
        ArrayList<Artista> artistas = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            JsonObject artistData = array.get(i).getAsJsonObject();

            Artista artista =  new Artista();
            //obtener el nombre
            String name = artistData.get(JsonKeys.ARTISTS_NAME).getAsString();
            //obtener las imagenes
            JsonArray imagesArray =  artistData.getAsJsonArray(JsonKeys.ARTISTS_IMAGES);

            String[] images = extractArtistImagesFromJsonArray(imagesArray);

            //Artista con toda la informacion seteada
            artista.setName(name);
            artista.setUrlMediumImage(images[0]);
            artista.setUrlLargeImage(images[1]);

            artistas.add(artista);



        }

        return artistas;

    }

    private String[] extractArtistImagesFromJsonArray(JsonArray imagesArray){
        String[] images = new String[2];

        for (int i = 0; i < imagesArray.size(); i++) {
            JsonObject imageData = imagesArray.get(i).getAsJsonObject();

            String size = imageData.get(JsonKeys.IMAGES_SIZE).getAsString();
            String url = imageData.get(JsonKeys.IMAGES_URL).getAsString();

            if (url.isEmpty())
                url = null;
            else
                url = url.replaceAll("\\/", "/");


            if (size.matches(JsonKeys.IMAGE_MEDIUM)){
                images[0] = url;
            }
            else if (size.matches(JsonKeys.IMAGE_LARGE)){
                images[1] = url;
            }

        }

        return images;
    }

}

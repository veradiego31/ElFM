package io.veradiego31.elfm.domain;

import com.google.gson.annotations.SerializedName;

import io.veradiego31.elfm.io.model.JsonKeys;

public class Artista {

    @SerializedName(JsonKeys.ARTISTS_NAME)
    String name;

    String urlMediumImage;
    String urlLargeImage;

    String playCount;
    String listeners;

    public String getPlayCount() {
        return playCount;
    }

    public void setPlayCount(String playCount) {
        this.playCount = playCount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getUrlMediumImage() {
        return urlMediumImage;
    }

    public void setUrlMediumImage(String urlMediumImage) {
        this.urlMediumImage = urlMediumImage;
    }

    public String getUrlLargeImage() {
        return urlLargeImage;
    }

    public void setUrlLargeImage(String urlLargeImage) {
        this.urlLargeImage = urlLargeImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artista(String name) {
        this.name = name;
    }

    public Artista() {
    }
}

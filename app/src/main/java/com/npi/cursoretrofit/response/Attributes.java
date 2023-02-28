
package com.npi.cursoretrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("synopsis")
    @Expose
    private String synopsis;
    @SerializedName("titles")
    @Expose
    private Titles titles;
    @SerializedName("posterImage")
    @Expose
    private PosterImage posterImage;

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Titles getTitles() {
        return titles;
    }

    public void setTitles(Titles titles) {
        this.titles = titles;
    }

    public PosterImage getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(PosterImage posterImage) {
        this.posterImage = posterImage;
    }

}

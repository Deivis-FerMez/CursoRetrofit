
package com.npi.cursoretrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PosterImage {

    @SerializedName("small")
    @Expose
    private String small;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

}

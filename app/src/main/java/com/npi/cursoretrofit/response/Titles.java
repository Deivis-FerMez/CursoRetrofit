
package com.npi.cursoretrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Titles {

    @SerializedName("en")
    @Expose
    private String en;
    @SerializedName("en_jp")
    @Expose
    private String enJp;
    @SerializedName("en_us")
    @Expose
    private String enUs;

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getEnJp() {
        return enJp;
    }

    public void setEnJp(String enJp) {
        this.enJp = enJp;
    }

    public String getEnUs() {
        return enUs;
    }

    public void setEnUs(String enUs) {
        this.enUs = enUs;
    }

}

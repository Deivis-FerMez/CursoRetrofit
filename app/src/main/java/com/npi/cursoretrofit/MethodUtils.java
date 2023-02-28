package com.npi.cursoretrofit;

import com.npi.cursoretrofit.response.Titles;

public class MethodUtils {
    public static String getTitle(Titles titles){
        String title = "No title found";

        if (titles.getEnUs() != null){
            title = titles.getEnUs();
        } else if (titles.getEn() != null){
            title = titles.getEn();
        } else if (titles.getEnJp() != null){
            title = titles.getEnJp();
        }

        try {
            if (title.isEmpty()){
                title = "No title found";
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            title = "No title found";
        }

        return title;
    }
}

package com.npi.cursoretrofit;

public class StringUtils {
    public enum ARTICLES{
        ANIME,
        MANGA
    }

    public final static String FILTER_ANIME_ARTICLES_URL = "anime?page[limit]=20&page[offset]=0&filter[text]=";
    public final static String FILTER_MANGA_ARTICLES_URL = "manga?page[limit]=20&page[offset]=0&filter[text]=";
}

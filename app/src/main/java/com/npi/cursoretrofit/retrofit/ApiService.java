package com.npi.cursoretrofit.retrofit;

import com.npi.cursoretrofit.response.ArticleData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {

    @GET("anime?page[limit]=20&page[offset]=0")
    Call<ArticleData> getAnimeArticle();

    @GET("manga?page[limit]=20&page[offset]=0")
    Call<ArticleData> getMangaArticle();

    @GET
    Call<ArticleData> getFilterAnimeArticle(@Url String url);

    @GET
    Call<ArticleData> getFilterMangaArticle(@Url String url);
}

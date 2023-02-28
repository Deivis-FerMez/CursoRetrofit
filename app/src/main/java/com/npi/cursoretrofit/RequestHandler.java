package com.npi.cursoretrofit;

import android.content.Context;
import android.util.Log;

import com.npi.cursoretrofit.response.ArticleData;
import com.npi.cursoretrofit.retrofit.ApiClient;
import com.npi.cursoretrofit.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestHandler {

    private Context context;
    private ApiClient apiClient = ApiClient.getInstance();
    private ApiService apiService = apiClient.getApiService();

    private RequestListener requestListener;

    RequestHandler(Context context,RequestListener requestListener){
    this.context = context;
    this.requestListener = requestListener;
    }

    public void getArticles(StringUtils.ARTICLES articlesType){

        Call<ArticleData> call = apiService.getAnimeArticle();
        if (articlesType == StringUtils.ARTICLES.ANIME){
            call = apiService.getAnimeArticle();
        }else if (articlesType == StringUtils.ARTICLES.MANGA){
            call = apiService.getMangaArticle();
        }

        call.enqueue(new Callback<ArticleData>() {
            @Override
            public void onResponse(Call<ArticleData> call, Response<ArticleData> response) {
                if (response.isSuccessful() && response.code() == 200){
                    /*for (int x = 0; x<response.body().getData().size();x++){
                        Log.e("retrofitResponse",response.body().getData().get(x).getId());
                    }*/
                    if (articlesType == StringUtils.ARTICLES.ANIME){
                        requestListener.animeResponse(response.body());
                    }else if (articlesType == StringUtils.ARTICLES.MANGA){
                        requestListener.mangaResponse(response.body());
                    }
                    //requestListener.animeResponse(response.body());
                }else{
                    Log.e("retrofitResponse",response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ArticleData> call, Throwable t) {
                Log.e("retrofitResponse",t.getMessage());
            }
        });
    }

    public void getFilterArticles(StringUtils.ARTICLES articlesType, String searchText){
        //        Call<ArticleData> call = apiService.getAnimeArticle();  // sin filtro
        Call<ArticleData> call = apiService.getFilterAnimeArticle(StringUtils.FILTER_ANIME_ARTICLES_URL + searchText);
        if (articlesType == StringUtils.ARTICLES.ANIME){
//            call = apiService.getAnimeArticle(); /// sin filtro
            call = apiService.getFilterAnimeArticle(StringUtils.FILTER_ANIME_ARTICLES_URL + searchText);
        }else if (articlesType == StringUtils.ARTICLES.MANGA){
//            call = apiService.getMangaArticle(); // sin filtro
            call = apiService.getFilterMangaArticle(StringUtils.FILTER_MANGA_ARTICLES_URL + searchText);
        }

        call.enqueue(new Callback<ArticleData>() {
            @Override
            public void onResponse(Call<ArticleData> call, Response<ArticleData> response) {
                if (response.isSuccessful() && response.code() == 200){
                    /*for (int x = 0; x<response.body().getData().size();x++){
                        Log.e("retrofitResponse",response.body().getData().get(x).getId());
                    }*/
                    if (articlesType == StringUtils.ARTICLES.ANIME){
                        requestListener.animeResponse(response.body());
                    }else if (articlesType == StringUtils.ARTICLES.MANGA){
                        requestListener.mangaResponse(response.body());
                    }
                    //requestListener.animeResponse(response.body());
                }else{
                    Log.e("retrofitResponse",response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ArticleData> call, Throwable t) {
                Log.e("retrofitResponse",t.getMessage());
            }
        });
    }

    public interface RequestListener{
        void animeResponse(ArticleData articleData);
        void mangaResponse(ArticleData articleData);
    }
}

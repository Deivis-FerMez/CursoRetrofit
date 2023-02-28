package com.npi.cursoretrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.npi.cursoretrofit.Fragments.AnimeFragment;
import com.npi.cursoretrofit.Fragments.MangaFragment;
import com.npi.cursoretrofit.adapter.FragmentViewPagerAdapter;
import com.npi.cursoretrofit.response.ArticleData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy, RequestHandler.RequestListener {

    private AnimeFragment animeFragment = AnimeFragment.getInstance();
    private MangaFragment mangaFragment = MangaFragment.getInstance();
    private List<Fragment> fragmentList = new ArrayList<>();

    private RequestHandler requestHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 articlesViewPager = findViewById(R.id.articles_viewpager);
        TabLayout tabs = findViewById(R.id.tab_layout);

        fragmentList.add(animeFragment);
        fragmentList.add(mangaFragment);

        FragmentViewPagerAdapter fragmentViewPagerAdapter = new FragmentViewPagerAdapter(fragmentList,this);

        articlesViewPager.setAdapter(fragmentViewPagerAdapter);

        new TabLayoutMediator(tabs, articlesViewPager,this).attach();

        requestHandler = new RequestHandler(this,this);

        requestHandler.getArticles(StringUtils.ARTICLES.ANIME);
    }

    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        switch (position){
            case 0:{
                tab.setText("Anime");
                break;
            }
            case 1:{
                tab.setText("Manga");
                break;
            }
        }
    }

    @Override
    public void animeResponse(ArticleData articleData) {
        /*for (int x = 0; x<articleData.getData().size();x++){
            Log.e("ResponseActivity",articleData.getData().get(x).getId());
        }*/
        animeFragment.initializeAnimeData(articleData);
        //requestHandler.getArticles(StringUtils.ARTICLES.MANGA);
    }

    public void callMangaData(){
        requestHandler.getArticles(StringUtils.ARTICLES.MANGA);
    }

    @Override
    public void mangaResponse(ArticleData articleData) {
        mangaFragment.initializeMangaData(articleData);
    }

    public void animeFIlterSearch(StringUtils.ARTICLES articlesType,String searchText){
        requestHandler.getFilterArticles(articlesType,searchText);
    }

    public void getAnimeArticles(){
        requestHandler.getArticles(StringUtils.ARTICLES.ANIME);
    }

    public void getMangaArticles(){
        requestHandler.getArticles(StringUtils.ARTICLES.MANGA);
    }
}
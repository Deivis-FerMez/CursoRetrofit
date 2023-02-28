package com.npi.cursoretrofit.Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.npi.cursoretrofit.MainActivity;
import com.npi.cursoretrofit.R;
import com.npi.cursoretrofit.StringUtils;
import com.npi.cursoretrofit.adapter.ArticleRecyclerViewAdapter;
import com.npi.cursoretrofit.response.ArticleData;


public class AnimeFragment extends Fragment implements SearchView.OnQueryTextListener {

    private static AnimeFragment instance;

    private View view;
    private ArticleRecyclerViewAdapter articleAdapter;
    private RecyclerView animeRecyclerView;
    private SearchView animeSearchView;

    private AnimeFragment() {

    }

    public static AnimeFragment getInstance(){
        if (instance == null){
            instance = new AnimeFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_anime, container, false);

        animeRecyclerView = view.findViewById(R.id.anime_recycler_view);
        animeSearchView = view.findViewById(R.id.anime_search_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        animeRecyclerView.setLayoutManager(gridLayoutManager);

        animeSearchView.setOnQueryTextListener(this);

        return view;
    }

    public void initializeAnimeData(ArticleData articleData){
        articleAdapter = new ArticleRecyclerViewAdapter(getActivity(),articleData);
        animeRecyclerView.setAdapter(articleAdapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText != null){
            if (!newText.isEmpty()){
//                Log.e("SearchText",newText);
                ((MainActivity)getActivity()).animeFIlterSearch(StringUtils.ARTICLES.ANIME,newText);
            }else {
                ((MainActivity)getActivity()).getAnimeArticles();
            }
        }
        return true;
    }
}
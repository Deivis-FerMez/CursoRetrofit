package com.npi.cursoretrofit.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.npi.cursoretrofit.Fragments.AnimeFragment;
import com.npi.cursoretrofit.Fragments.MangaFragment;

import java.util.List;

public class FragmentViewPagerAdapter extends FragmentStateAdapter {

    private List<Fragment> mfragmentList;

    public FragmentViewPagerAdapter(@NonNull List<Fragment> fragmentList ,@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

        this.mfragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment frag = AnimeFragment.getInstance();

        switch (position){
            case 0: {
                frag = AnimeFragment.getInstance();
                break;
            }
            case 1:{
                frag = MangaFragment.getInstance();
                break;
            }
        }

        return frag;
    }

    @Override
    public int getItemCount() {
        return mfragmentList.size();
    }
}

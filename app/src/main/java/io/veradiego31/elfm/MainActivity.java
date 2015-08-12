package io.veradiego31.elfm;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import io.veradiego31.elfm.ui.adapter.PagerAdapter;
import io.veradiego31.elfm.ui.fragment.HypedArtistsFragment;
import io.veradiego31.elfm.ui.fragment.TopArtistFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        if(toolbar != null)
            setSupportActionBar(toolbar);

        setupViewPager();


      /*  if(savedInstanceState== null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, new HypedArtistsFragment())
                    .commit();
        }*/



    }

    private void setupViewPager(){
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), buildFragments()));
        tabLayout.setupWithViewPager(viewPager);
    }

    private ArrayList<Fragment> buildFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();
        HypedArtistsFragment hypedArtistsFragment = new HypedArtistsFragment();
        TopArtistFragment topArtistFragment =  new TopArtistFragment();

        fragments.add(hypedArtistsFragment);
        fragments.add(topArtistFragment);

        return fragments;
    }

}

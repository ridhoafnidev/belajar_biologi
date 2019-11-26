package com.dicoding.tapembelajaranbiologi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.dicoding.tapembelajaranbiologi.R;
import com.dicoding.tapembelajaranbiologi.adapter.AlatBahanPagerAdapter;
import com.dicoding.tapembelajaranbiologi.fragment.AlatFragment;
import com.dicoding.tapembelajaranbiologi.fragment.BahanFragment;
import com.google.android.material.tabs.TabLayout;

public class AlatBahanActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alat_bahan);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        AlatBahanPagerAdapter adapter = new AlatBahanPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new AlatFragment(), "Alat");
        adapter.addFragment(new BahanFragment(), "Bahan");

        viewPager.setAdapter(adapter);
    }
}

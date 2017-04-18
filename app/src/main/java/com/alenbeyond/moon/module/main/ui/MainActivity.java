package com.alenbeyond.moon.module.main.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.alenbeyond.moon.R;
import com.alenbeyond.moon.base.adapter.MoonFragmentPagerAdapter;
import com.alenbeyond.moon.base.view.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_content)
    ViewPager mVpContent;
    @BindView(R.id.navigation)
    BottomNavigationView mNavigationView;

    private String[] mTitles;
    private MenuItem mMenuItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createView(R.layout.activity_main);
        initTitleBar(false, getString(R.string.home));
        mTitles = new String[]{getString(R.string.home), getString(R.string.discover), getString(R.string.collect)};
        initView();
    }

    private void initView() {

        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_home:
                        mVpContent.setCurrentItem(0);
                        changeTitle(mTitles[0]);
                        break;
                    case R.id.item_office:
                        mVpContent.setCurrentItem(1);
                        changeTitle(mTitles[1]);
                        break;
                    case R.id.item_me:
                        mVpContent.setCurrentItem(2);
                        changeTitle(mTitles[2]);
                        break;
                }
                return false;
            }
        });

        mVpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mMenuItem = mNavigationView.getMenu().getItem(position);
                mMenuItem.setChecked(true);
                changeTitle(mTitles[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        MoonFragmentPagerAdapter adapter = new MoonFragmentPagerAdapter(getFragmentManager(), mTitles);
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new DiscoverFragment());
        adapter.addFragment(new CollectFragment());
        mVpContent.setOffscreenPageLimit(3);
        mVpContent.setAdapter(adapter);
    }
}

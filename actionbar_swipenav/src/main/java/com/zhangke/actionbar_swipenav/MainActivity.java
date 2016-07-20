package com.zhangke.actionbar_swipenav;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity  implements ActionBar.TabListener{

    private ViewPager viewPager;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar=getActionBar();
        viewPager=(ViewPager)findViewById(R.id.pager);
        FragmentPagerAdapter adapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment=new DummyFragment();
                Bundle args=new Bundle();
                args.putInt(DummyFragment.ARG_SECTION_NUMBER,position+1);
                fragment.setArguments(args);
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch(position){
                    case 0:
                        return  "第一页";
                    case 1:
                        return "第二页";
                    case 2:
                        return "第三页";
                }
                return null;
            }
        };

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for(int i=0;i<adapter.getCount();i++){
            actionBar.addTab(actionBar.newTab().setText(adapter.getPageTitle(i)).setTabListener(this));
        }
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {}

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}
}

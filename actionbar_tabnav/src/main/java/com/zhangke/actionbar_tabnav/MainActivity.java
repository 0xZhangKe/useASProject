package com.zhangke.actionbar_tabnav;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity implements ActionBar.TabListener {

    private static final String SELECTED_ITEM="selected_item";
    private static final int NUMBER=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int n=NUMBER;
        final ActionBar actionBar=getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("第一页").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("第二页").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("第三页").setTabListener(this));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState.containsKey(SELECTED_ITEM)){
            getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(SELECTED_ITEM));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM,getActionBar().getSelectedNavigationIndex());
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        Fragment fragment=new DummyFragment();
        Bundle args=new Bundle();
        args.putInt(DummyFragment.ARG_SECTION_NUMBER,tab.getPosition()+1);
        fragment.setArguments(args);
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.container,fragment);
        ft.commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {}

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}
}

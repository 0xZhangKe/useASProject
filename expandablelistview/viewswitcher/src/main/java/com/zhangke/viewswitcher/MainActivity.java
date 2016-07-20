package com.zhangke.viewswitcher;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ViewSwitcher;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static final int NUMBER_PER_SCREEN=12;
    public static class DataItem{
        public String dataName;
        public Drawable drawable;
    }
    private ArrayList<DataItem> items=new ArrayList<DataItem>();
    private int screenNo=-1;
    private int screenCount;
    ViewSwitcher witcher;
    LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

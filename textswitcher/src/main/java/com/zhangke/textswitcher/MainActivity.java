package com.zhangke.textswitcher;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {


    private TextSwitcher textSwitcher;
    private String[] strs=new String[]{
            "第一行代码",
            "疯狂Java讲义",
            "疯狂Android讲义",
            "Android开发艺术探索"
    };
    private int curStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSwitcher=(TextSwitcher)findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv=new TextView(MainActivity.this);
                tv.setTextSize(40);
                tv.setTextColor(Color.MAGENTA);
                return tv;
            }
        });
        next(null);
    }

    public void next(View source){
        textSwitcher.setText(strs[curStr++ % strs.length]);
    }
}

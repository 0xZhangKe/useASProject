package com.zhangke.AutoCompleteTextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoTv;
    private MultiAutoCompleteTextView mutoTv;
    private String[] books=new String[]{
            "第一行代码",
            "Android 编程权威指南",
            "疯狂 Java 讲义",
            "疯狂 Android 讲义",
            "Android 编程权威指南"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,books);
        autoTv=(AutoCompleteTextView)findViewById(R.id.autotv_auto);
        autoTv.setAdapter(aa);
        mutoTv=(MultiAutoCompleteTextView)findViewById(R.id.multiautoyv_mauto);
        mutoTv.setAdapter(aa);
        mutoTv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}

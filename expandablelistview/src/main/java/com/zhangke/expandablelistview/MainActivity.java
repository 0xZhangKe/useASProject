package com.zhangke.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.zhangke.expandablelistview.util.MyExpandableListAdapter;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyExpandableListAdapter adapter=new MyExpandableListAdapter(this);
        expandableListView=(ExpandableListView)findViewById(R.id.expandable);
        expandableListView.setAdapter(adapter);
    }
}

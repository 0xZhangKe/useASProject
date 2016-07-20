package com.zhangke.stackview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private StackView stackView;
    private int[] imageIds=new int[]{
            R.drawable.img04,R.drawable.img05,
            R.drawable.img06,R.drawable.img07,
            R.drawable.img08
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stackView=(StackView)findViewById(R.id.stackview);
        List<Map<String,Object>> listItems=
                new ArrayList<Map<String,Object>>();
        for(int i=0;i<imageIds.length;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("image",imageIds[i]);
            listItems.add(map);
        }
        SimpleAdapter adapter=new SimpleAdapter(this,
                listItems,
                R.layout.cell,
                new String[]{"image"},
                new int[]{R.id.cell_img});
        stackView.setAdapter(adapter);
    }
}

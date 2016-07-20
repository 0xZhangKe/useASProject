package com.zhangke.grifview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private ImageView imgView;
    private int[] imageIds=new int[]{
            R.drawable.b1,R.drawable.b2,R.drawable.b3,
            R.drawable.b4,R.drawable.b5,R.drawable.b6,
            R.drawable.b7,R.drawable.b8,R.drawable.b9,
            R.drawable.b10,R.drawable.b11,R.drawable.b12
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String,Object>> data=new ArrayList<Map<String,Object>> ();
        for(int i=0;i<imageIds.length;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("image",imageIds[i]);
            data.add(map);
        }
        imgView=(ImageView)findViewById(R.id.imageview);
        SimpleAdapter adapter=new SimpleAdapter(this,
                data,
                R.layout.cell,
                new String[]{"image"},
                new int[]{R.id.cell_img});
        gridView=(GridView)findViewById(R.id.girdview_01);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imgView.setImageResource(imageIds[position]);
            }
        });
    }
}

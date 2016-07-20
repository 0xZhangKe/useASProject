package com.zhangke.imageswitcher;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private int[] imageIds=new int[]{
            R.drawable.img01,R.drawable.img02,R.drawable.img03,
            R.drawable.img04,R.drawable.img05,R.drawable.img06,
            R.drawable.img07,R.drawable.img08,R.drawable.img09,
            R.drawable.img10,R.drawable.img11,R.drawable.img12,
    };
    private ImageSwitcher switcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<imageIds.length;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("image",imageIds[i]);
            listItems.add(map);
        }
        switcher=(ImageSwitcher)findViewById(R.id.switcher);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ImageSwitcher.LayoutParams.WRAP_CONTENT,
                        ImageSwitcher.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        SimpleAdapter adapter=new SimpleAdapter(
                this,
                listItems,
                R.layout.cell,
                new String[]{"image"},
                new int[]{R.id.cell_img}
        );
        GridView grid=(GridView)findViewById(R.id.gridView);
        grid.setAdapter(adapter);
        grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switcher.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {  }
        });
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switcher.setImageResource(imageIds[position]);
            }
        });
    }
}

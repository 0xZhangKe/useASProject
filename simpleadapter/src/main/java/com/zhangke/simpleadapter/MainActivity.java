package com.zhangke.simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] names=new String[]
            {"李白","李清照","汉武帝","曹操"};
    private String[] descs=new String[]
            {"空前绝后的诗人","文艺女青年","听名字就霸气","很厉害的政治家"};
    private int[] imageIds=new int[]
            {R.drawable.libai,R.drawable.liqingzhao,
            R.drawable.hanwudi,R.drawable.caocao};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> listItems=
                new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("header",imageIds[i]);
            listItem.put("personName",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.simple_item,
                new String[]{"personName","header","desc"},new int[]{R.id.name,R.id.header,R.id.desc});
        ListView listView=(ListView)findViewById(R.id.listview);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,names[position]+"被点击了",Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,names[position]+"被选中了",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this,"啥都没选",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

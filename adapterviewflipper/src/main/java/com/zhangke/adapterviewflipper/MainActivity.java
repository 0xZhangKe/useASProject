package com.zhangke.adapterviewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] imageIds = new int[]{
            R.drawable.img01, R.drawable.img02, R.drawable.img03,
            R.drawable.img04, R.drawable.img05, R.drawable.img06,
            R.drawable.img07, R.drawable.img08, R.drawable.img09,
            R.drawable.img10, R.drawable.img11, R.drawable.img12,
    };
    private AdapterViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper = (AdapterViewFlipper) findViewById(R.id.flipper);
        MyAdapter adapter=new MyAdapter();
        flipper.setAdapter(adapter);
    }

    public void prev(View source){
        flipper.showPrevious();
        flipper.stopFlipping();
    }

    public void next(View source){
        flipper.showNext();
        flipper.stopFlipping();
    }

    public void auto(View source){
        flipper.startFlipping();
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView=new ImageView(MainActivity.this);
            imageView.setImageResource(imageIds[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            return imageView;
        }

        @Override
        public int getCount() {
            return imageIds.length;
        }
    }
}

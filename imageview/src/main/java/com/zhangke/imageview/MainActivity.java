package com.zhangke.imageview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int[] images=new int[]{
                R.drawable.one,
                R.drawable.two,
                R.drawable.three,
                R.drawable.four,
                R.drawable.five
    };

    private int currentImg=2;
    private int alpna=255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button plus=(Button)findViewById(R.id.btn_plus);
        final Button minus=(Button)findViewById(R.id.btn_minus);
        final ImageView image1=(ImageView)findViewById(R.id.imageView1);
        final ImageView image2=(ImageView)findViewById(R.id.imageView2);
        final Button next=(Button)findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1.setImageResource(images[++currentImg%images.length]);
            }
        });
        View.OnClickListener listener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(v==plus){
                    alpna+=20;
                }
                if(v==minus){
                    alpna-=20;
                }
                if(alpna>=255){
                    alpna=255;
                }
                if(alpna<=0){
                    alpna=0;
                }
                image1.setImageAlpha(alpna);
            }
        };
        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        image1.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                BitmapDrawable bitmapDrawable=(BitmapDrawable)image1.getDrawable();
                Bitmap bitmap=bitmapDrawable.getBitmap();
                double scale=1.0*bitmap.getHeight()/image1.getHeight();
                int x=(int)(event.getX()*scale);
                int y=(int)(event.getY()*scale);
                if(x+120>bitmap.getWidth()){
                    x=bitmap.getWidth()-120;
                }
                if(y+120>bitmap.getHeight()){
                    y=bitmap.getHeight()-120;
                }
                image2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                image2.setAlpha(alpna);
                return false;
            }
        });
    }
}

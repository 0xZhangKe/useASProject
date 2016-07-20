package com.zhangke.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SimpleBtnOnClick(View source){
        Toast toast=Toast.makeText(MainActivity.this,"简单的Toast",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void WithImgBtnOnClick(View source){
        Toast toast=new Toast(MainActivity.this);
        toast.setGravity(Gravity.CENTER,0,0);
        ImageView image=new ImageView(MainActivity.this);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(200,150);
       // params.setMarginStart(110);
        image.setLayoutParams(params);
        image.setImageResource(R.drawable.img04);

        LinearLayout ll=new LinearLayout(MainActivity.this);
        ll.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        ll.setGravity(Gravity.CENTER_HORIZONTAL);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(image);

        TextView tv=new TextView(MainActivity.this);
        tv.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        tv.setText("带图片的Toast");
        tv.setTextSize(20);
        ll.addView(tv);

        toast.setView(ll);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}

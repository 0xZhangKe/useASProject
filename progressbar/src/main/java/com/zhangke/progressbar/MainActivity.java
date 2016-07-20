package com.zhangke.progressbar;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

    private int[] data=new int[100];
    private int hasData=0;
    private int status=0;
    private ProgressBar bar1,bar2;
    private Button btnShow,btnClose;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0x11){
                bar1.setProgress(status);
                bar2.setProgress(status);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);

        bar1 = (ProgressBar)findViewById(R.id.bar);
        bar2 = (ProgressBar)findViewById(R.id.bar2);
        btnShow = (Button)findViewById(R.id.btn_show);
        btnClose = (Button)findViewById(R.id.btn_close);
        new Thread(new Runnable(){
            @Override
            public void run() {
                while(status<100){
                    status=doWork();
                    mHandler.sendEmptyMessage(0x11);
                }
            }
        }).start();
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarIndeterminateVisibility(true);
                setProgressBarVisibility(true);
                setProgress(4500);
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarIndeterminateVisibility(false);
                setProgressBarVisibility(false);
            }
        });
    }

    private int doWork(){
        data[hasData++]=(int)(Math.random()*100);
        try {
            Thread.sleep(100);
        } catch(java.lang.InterruptedException e){
            e.printStackTrace();
        }
        return hasData;
    }
}

package com.zhangke.popupwindow;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends Activity {

    private TextView tvData,tvTime;
    private static final int MAX_PROGRESS=100;
    private int[] data=new int[50];
    private int progressStatus=0;
    private int hasData=0;
    private ProgressDialog pd1,pd2;
    private Handler mHandler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0x123){
                pd2.setProgress(progressStatus);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvData=(TextView)findViewById(R.id.main_tv_date);
        tvTime=(TextView)findViewById(R.id.main_tv_time);
    }

    public void ShowPopupWindow(View view){
        View root=this.getLayoutInflater().inflate(R.layout.popup_window,null);
        final PopupWindow popup=new PopupWindow(root,560,720);
        popup.showAtLocation(findViewById(R.id.main_popup_btn), Gravity.CENTER,20,20);
        root.findViewById(R.id.popup_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
    }

    public void ShowDialoActivity(View v){
        Intent intent=new Intent(MainActivity.this,DialogActivity.class);
        startActivity(intent);
    }

    public void ShowDatePickerDialog(View v){
        Calendar c=Calendar.getInstance();
        new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                tvData.setText("日期："+year+"-"+monthOfYear+"-"+dayOfMonth);
            }
        }
        ,c.get(Calendar.YEAR)
        ,c.get(Calendar.MONTH)
        ,c.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void ShowTimePickerDialog(View v){
        Calendar c=Calendar.getInstance();
        new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvTime.setText("时间："+hourOfDay+":"+minute);
                    }
                }
                ,c.get(Calendar.HOUR_OF_DAY)
                ,c.get(Calendar.MINUTE)
                ,true).show();
    }

    public void showSpinner(View v){
        ProgressDialog.show(MainActivity.this,"任务执行中","任务执行中，请等待",false,true);
    }

    public void showIndeterminate(View v){
        pd1=new ProgressDialog(MainActivity.this);
        pd1.setTitle("任务正在执行");
        pd1.setMessage("任务正在执行，请稍等...");
        pd1.setCancelable(true);
        pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd1.setIndeterminate(true);
        pd1.show();
    }

    public void showProgress(View v){
        progressStatus=0;
        hasData=0;
        pd2=new ProgressDialog(MainActivity.this);
        pd2.setMax(MAX_PROGRESS);
        pd2.setTitle("任务执行百分比");
        pd2.setCancelable(false);
        pd2.setMessage("耗时任务的完成百分比");
        pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd2.setIndeterminate(false);
        pd2.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatus<MAX_PROGRESS){
                    progressStatus=MAX_PROGRESS * doWork()/data.length;
                    mHandler.sendEmptyMessage(0x123);
                }
                if(progressStatus>=MAX_PROGRESS){
                    pd2.dismiss();
                }
            }
        }).start();
    }

    public int doWork(){
        data[hasData++]=(int)(Math.random()*100);

        try {
            Thread.sleep(100);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        return hasData;
    }

}

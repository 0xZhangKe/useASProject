package com.zhangke.alertdialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ShowListDialog(View source){
        final String[] strArray=new String[]{"第一行代码","Android编程权威指南",
                "Android开发艺术探索","Android群英传","颈椎康复训练"};
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Simple List Dialog").setIcon(getResources().getDrawable(R.drawable.ico)).
        setItems(strArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, strArray[which], Toast.LENGTH_SHORT).show();
            }
        });
        setPositionButton(builder);
        setNeutralButton(builder);
        setNegaiveButton(builder).create().show();
    }

    public void ShowSingleChoiceDialog(View source){
        final String[] strArray=new String[]{"第一行代码","Android编程权威指南",
                "Android开发艺术探索","Android群英传","颈椎康复训练"};
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Simple List Dialog").setIcon(getResources().getDrawable(R.drawable.ico));
        builder.setSingleChoiceItems(strArray, 3, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Your's choice is:"+strArray[which], Toast.LENGTH_SHORT).show();
            }
        });
        setPositionButton(builder);
        setNeutralButton(builder);
        setNegaiveButton(builder).create().show();
    }

    public void ShowMultiChoiceDialog(View source){
        final String[] strArray=new String[]{"第一行代码","Android编程权威指南",
                "Android开发艺术探索","Android群英传","颈椎康复训练"};
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Simple List Dialog").setIcon(getResources().getDrawable(R.drawable.ico));
        builder.setMultiChoiceItems(strArray, new boolean[]{true,true,false,false,false},
                new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(MainActivity.this, "Your's choice is:"+strArray[which], Toast.LENGTH_SHORT).show();
            }
        });
        setPositionButton(builder);
        setNeutralButton(builder);
        setNegaiveButton(builder).create().show();
    }

    public void ShowAdapterDialog(View view){
        final String[] strArray=new String[]{"第一行代码","Android编程权威指南",
                "Android开发艺术探索","Android群英传","颈椎康复训练"};
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Simple List Dialog").setIcon(getResources().getDrawable(R.drawable.ico));
        builder.setAdapter(new ArrayAdapter<String>(MainActivity.this, R.layout.dialog_items, strArray), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Your's choice is:"+strArray[which], Toast.LENGTH_SHORT).show();
            }
        });
        setPositionButton(builder);
        setNeutralButton(builder);
        setNegaiveButton(builder).create().show();
    }

    public void FinishActivity(View view){
        MainActivity.this.finish();
    }

    private AlertDialog.Builder setPositionButton(AlertDialog.Builder builder){
        return builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private AlertDialog.Builder setNegaiveButton(AlertDialog.Builder builder){
        return builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private AlertDialog.Builder setNeutralButton(AlertDialog.Builder builder) {
        return builder.setNeutralButton("Details", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "nothing", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

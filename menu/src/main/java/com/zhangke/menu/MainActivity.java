package com.zhangke.menu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int FONT_10=0x111;
    private final int FONT_12=0x112;
    private final int FONT_14=0x113;
    private final int FONT_16=0x114;
    private final int FONT_18=0x115;

    private final int PLAN_ITEM=0x11b;

    private final int FONT_RED=0x116;
    private final int FONT_BLUE=0x117;
    private final int FONT_GREEN=0x118;

    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit=(EditText)findViewById(R.id.et);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu fontMenu=menu.addSubMenu("字体大小");
        fontMenu.setIcon(R.drawable.ico);
        fontMenu.setHeaderIcon(R.drawable.ico);
        fontMenu.setHeaderTitle("选择字大小");
        fontMenu.add(0,FONT_10,0,"10号字体");
        fontMenu.add(0,FONT_12,0,"12号字体");
        fontMenu.add(0,FONT_14,0,"14号字体");
        fontMenu.add(0,FONT_16,0,"16号字体");
        fontMenu.add(0,FONT_18,0,"18号字体");

        menu.add(0,PLAN_ITEM,0,"普通菜单项");

        SubMenu colorMenu=menu.addSubMenu("字体颜色");
        colorMenu.setIcon(R.drawable.ico);
        colorMenu.setHeaderTitle("选择文字颜色");
        colorMenu.add(0,FONT_RED,0,"红色");
        colorMenu.add(0,FONT_BLUE,0,"蓝色");
        colorMenu.add(0,FONT_GREEN,0,"绿色");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case FONT_10:
                edit.setTextSize(10*2);
                break;
            case FONT_12:
                edit.setTextSize(12*2);
                break;
            case FONT_14:
                edit.setTextSize(14*2);
                break;
            case FONT_16:
                edit.setTextSize(16*2);
                break;
            case FONT_18:
                edit.setTextSize(18*2);
                break;
            case FONT_BLUE:
                edit.setTextColor(Color.BLUE);
                break;
            case FONT_GREEN:
                edit.setTextColor(Color.GREEN);
                break;
            case FONT_RED:
                edit.setTextColor(Color.RED);
                break;
            case PLAN_ITEM:
                Toast toast=Toast.makeText(MainActivity.this,"您点击了普通菜单项",Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }
}

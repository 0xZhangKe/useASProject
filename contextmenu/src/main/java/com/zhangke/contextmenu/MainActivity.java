package com.zhangke.contextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private PopupMenu popup=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(TextView)findViewById(R.id.txt);
        registerForContextMenu(txt);
    }

    public void onPopupButtonClick(View button){
        popup=new PopupMenu(this,button);
        getMenuInflater().inflate(R.menu.opup_menu,popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.popup_menu_item_exit:
                        popup.dismiss();
                        break;
                    default:
                        Toast.makeText(MainActivity.this,"您点击了【"+item.getTitle()+"】菜单项",Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });
        popup.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.context,menu);
        menu.setHeaderIcon(R.drawable.ico);
        menu.setHeaderTitle("选择背景颜色");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.isCheckable()){
            item.setChecked(true);
        }
        switch (item.getItemId()){
            case R.id.font_10:
                txt.setTextSize(10*2);
                break;
            case R.id.font_12:
                txt.setTextSize(12*2);
                break;
            case R.id.font_14:
                txt.setTextSize(14*2);
                break;
            case R.id.font_16:
                txt.setTextSize(16*2);
                break;
            case R.id.font_18:
                txt.setTextSize(18*2);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.BLUE);
                break;
            case R.id.green_font:
                txt.setTextColor(Color.GREEN);
                break;
            case R.id.blue_font:
                txt.setTextColor(Color.RED);
                break;
            case R.id.plan_item:
                Toast toast=Toast.makeText(MainActivity.this,"您点击了普通菜单项",Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        item.setChecked(true);
        switch(item.getItemId()){
            case R.id.red:
                item.setChecked(true);
                txt.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                item.setChecked(true);
                txt.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                item.setChecked(true);
                txt.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }
}

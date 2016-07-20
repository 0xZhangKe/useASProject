package com.zhangke.popupwindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by zk721 on 2016/6/8.
 */
public class DialogActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_activity);
        findViewById(R.id.dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogActivity.this.finish();
            }
        });
    }
}

package com.zhangke.choosedate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText etShow;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private int year,month,day,hour,minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etShow=(EditText)findViewById(R.id.et);
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        timePicker=(TimePicker)findViewById(R.id.timePicker);
        Calendar calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        hour=calendar.get(Calendar.HOUR);
        minute=calendar.get(Calendar.MINUTE);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year=year;
                MainActivity.this.month=monthOfYear;
                MainActivity.this.day=dayOfMonth;
                showDate(year,month,day,hour,minute);
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                MainActivity.this.hour=hourOfDay;
                MainActivity.this.minute=minute;
                showDate(year,month,day,hour,minute);
            }
        });
    }

    private void showDate(int year,int month,int day,
            int hour,int minute){
        etShow.setText("您的购买日期为："+year+"年"+(month+1)+"月"+day+"日"+hour+"时"+minute+"分");
    }
}

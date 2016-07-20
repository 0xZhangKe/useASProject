package com.zhangke.expandablelistview.util;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhangke.expandablelistview.MainActivity;
import com.zhangke.expandablelistview.R;

/**
 * Created by zk721 on 2016/5/28.
 */
public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private int[] logos=new int[]{
            R.drawable.b1,
            R.drawable.b2,
            R.drawable.b3
    };
    private String[] armTypes=new String[]
            {"神族兵种","虫族兵种","人族兵种"};
    private String[][] arms=new String[][]{
            {"狂战士","龙骑士","黑暗圣堂","电兵"},
            {"神犬","刺蛇","飞龙","森林之子"},
            {"铁血勇士","赛亚人","奥特曼"}
    };

    public MyExpandableListAdapter(Context context){
        this.context=context;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return arms[groupPosition][childPosition];
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return arms[groupPosition].length;
    }

    private TextView getTextView(){
        AbsListView.LayoutParams lp=new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView textView=new TextView(context);
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
        textView.setPadding(36,0,0,0);
        textView.setTextSize(20);
        return textView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView textView=getTextView();
        textView.setText(getChild(groupPosition,childPosition).toString());
        return textView;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return armTypes[groupPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public int getGroupCount() {
        return armTypes.length;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LinearLayout ll=new LinearLayout(context);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ImageView logo=new ImageView(context);
        logo.setImageResource(logos[groupPosition]);
        ll.addView(logo);
        TextView tv=getTextView();
        tv.setText(getGroup(groupPosition).toString());
        ll.addView(tv);
        return ll;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

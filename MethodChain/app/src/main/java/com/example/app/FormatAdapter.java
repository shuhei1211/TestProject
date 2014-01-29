package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.androidquery.AQuery;

import java.util.List;

/**
 * BaseAdapter
 */
public abstract class FormatAdapter extends BaseAdapter {

    List<TestData> mList;
    Context mContext;
    LayoutInflater mInflater;
    AQuery aq;

    private FormatAdapter(List<TestData> mList, Context mContext, LayoutInflater mInflater, AQuery aq) {
        this.mList = mList;
        this.mContext = mContext;
        this.mInflater = mInflater;
        this.aq = aq;
    }

    private class ViewHolder {
        int position;
        TextView textView;
        CheckBox checkBox;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public TestData getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
//            convertView = getLayoutInflater().inflate(R.layout.item_openrange_list_image, null);
            holder = new ViewHolder();
//            holder.textView = (TextView) convertView.findViewById(R.id.item_openrange_list_text);
//            holder.checkBox = (CheckBox) convertView.findViewById(R.id.item_openrange_list_checkbox);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

//            AQuery aq = new AQuery(convertView);

        holder.position = position;
        TestData item = getItem(position);

        aq = new AQuery(convertView);
        aq.id(holder.textView);
        aq.id(holder.checkBox);

        return convertView;
    }
}

class TestData {

}

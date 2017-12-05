package com.example.cookie;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainLV1Adapter extends BaseAdapter {

    private ArrayList<Pattern> ListPattern = new ArrayList<Pattern>();

    public MainLV1Adapter() {
    }


    @Override
    public int getCount() {
        return ListPattern.size();
    }

    @Override
    public Object getItem(int position) {
        return ListPattern.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_pattern, parent, false);

        }

        TextView dateTextview = (TextView) convertView.findViewById(R.id.pat_date_output);
        TextView methodTextview = (TextView) convertView.findViewById(R.id.pat_method_output);
        TextView contentTextview = (TextView) convertView.findViewById(R.id.pat_content_output);
        TextView sum1Textview = (TextView) convertView.findViewById(R.id.pat_sum1_output);
        TextView sum2Textview = (TextView) convertView.findViewById(R.id.pat_sum2_output);

        Pattern pat = ListPattern.get(position);

        dateTextview.setText(pat.getPat년월일());
        methodTextview.setText(pat.getPat결제종류());
        contentTextview.setText(pat.getPat사용내역());
        sum1Textview.setText(pat.getPat수입액());
        sum2Textview.setText(pat.getPat수입액());

        return convertView;
    }

    public void addItem(String date, String method, String content, String sum1, String sum2) {

        Pattern pat = new Pattern();

        pat.setdate(date);
        pat.setpay(method);
        pat.setPat사용내역(content);
        pat.setPat수입액(sum1);

    }
}




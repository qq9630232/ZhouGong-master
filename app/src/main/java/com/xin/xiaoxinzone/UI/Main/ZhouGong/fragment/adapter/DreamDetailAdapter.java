package com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xin.xiaoxinzone.Entity.DreamBean;
import com.xin.xiaoxinzone.R;

import java.util.List;

/**
 * Created by Administrator on 2016/3/28.
 */
public class DreamDetailAdapter extends BaseAdapter {

    private List<DreamBean.ResultEntity> list ;

    public DreamDetailAdapter(List<DreamBean.ResultEntity> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dream_detail_item_layout, null, false);
        final TextView textView = (TextView) view.findViewById(R.id.dream_detail_item_text);
        textView.setText(list.get(position).getTitle());

        return view;
    }
}

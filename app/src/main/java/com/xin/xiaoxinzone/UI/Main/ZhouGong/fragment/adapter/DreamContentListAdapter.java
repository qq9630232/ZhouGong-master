package com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xin.xiaoxinzone.Base.BaseRecycleViewAdapter;
import com.xin.xiaoxinzone.R;

/**
 * Created by SDC on 2019/3/21.
 */

public class DreamContentListAdapter extends BaseRecycleViewAdapter<DreamContentListAdapter.ViewHolder> {
    private Context context;
    private String[] list ;

    public DreamContentListAdapter(Context context, String[] list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.content_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(list[position].toString());
    }

    @Override
    public int getAdapterItemCount() {
        if(list != null && list.length != 0){
            return list.length;
        }else {
            return 0;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView mTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.content_item_title);
        }
    }
}

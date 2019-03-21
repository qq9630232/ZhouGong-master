package com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xin.xiaoxinzone.Base.BaseRecycleViewAdapter;
import com.xin.xiaoxinzone.Entity.DreamBean;
import com.xin.xiaoxinzone.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDC on 2019/3/21.
 */

public class DreamContentAdapter extends BaseRecycleViewAdapter<DreamContentAdapter.ViewHolder> {
    private Context context;
    private List<DreamBean.ResultEntity> list = new ArrayList<>();

    public DreamContentAdapter(Context context, List<DreamBean.ResultEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dream_content_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(list.get(position).getTitle());
        String[] strings = list.get(position).getList();

        DreamContentListAdapter dreamContentAdapter = new DreamContentListAdapter(context,strings);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        holder.mRv.setLayoutManager(manager);
        holder.mRv.setAdapter(dreamContentAdapter);
    }

    @Override
    public int getAdapterItemCount() {
        return list.size()==0?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView mTitle;
        private RecyclerView mRv;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.content_item_title);
            mRv = (RecyclerView) itemView.findViewById(R.id.content_item_rv);
        }
    }
}

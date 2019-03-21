package com.xin.xiaoxinzone.UI.Main.constellation.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xin.xiaoxinzone.R;
import com.xin.xiaoxinzone.model.Fortune;

import java.util.List;

/**
 * @author llq
 * @time 2018/6/15  15:48.
 * @faction 左侧菜单适配器
 * @description
 * @modify
 */
public class LeftMenuAdapter extends RecyclerView.Adapter<LeftMenuAdapter.LeftMenuViewHolder> {
    private List<Fortune> fortuneList;
    private OnItemClickListener onItemClickListener;

    public LeftMenuAdapter(List<Fortune> fortuneList) {
        this.fortuneList = fortuneList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public LeftMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left, parent, false);
        return new LeftMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LeftMenuViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        if (fortuneList.get(position) != null) {
            holder.mIvIconItemLeft.setImageResource(fortuneList.get(position).getIcon());
            holder.mTvNameItemLeft.setText(fortuneList.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.setOnItemClickListener(position);
                }
            });
            if (fortuneList.get(position).isChoose()) {
                holder.itemView.setBackgroundColor(Color.argb(127, 255, 255, 255));
            } else {
                holder.itemView.setBackgroundColor(Color.argb(0, 255, 255, 255));
            }
        }
    }

    @Override
    public int getItemCount() {
        return fortuneList == null ? 0 : fortuneList.size();
    }

    class LeftMenuViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIvIconItemLeft;
        private TextView mTvNameItemLeft;

        LeftMenuViewHolder(View itemView) {
            super(itemView);
            mIvIconItemLeft = (ImageView) itemView.findViewById(R.id.iv_icon_item_left);
            mTvNameItemLeft = (TextView) itemView.findViewById(R.id.tv_name_item_left);
        }
    }

    public interface OnItemClickListener {
        void setOnItemClickListener(int position);
    }
}

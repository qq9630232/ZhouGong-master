package com.xin.xiaoxinzone.UI.Main.constellation.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xin.xiaoxinzone.R;
import com.xin.xiaoxinzone.data.Data;
import com.xin.xiaoxinzone.model.WeekModal;

import java.util.List;

/**
 * @author llq
 * @time 2018/6/20  15:10.
 * @faction
 * @description
 * @modify
 */
public class WeekAdapter extends RecyclerView.Adapter<WeekAdapter.WeekViewHolder> {
    private List<WeekModal> weekModalList;
    private Context context;

    public WeekAdapter(List<WeekModal> weekModalList, Context context) {
        this.weekModalList = weekModalList;
        this.context = context;
    }

    @Override
    public WeekViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_week, parent, false);
        return new WeekViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeekViewHolder holder, int position) {
        if (weekModalList.get(position) != null) {
            holder.mCvItemWeek.setCardBackgroundColor(context.getResources().getColor(Data.getCardViewBgColor()[position]));
            holder.mTvTitleItemWeek.setText(weekModalList.get(position).getTitle());
            holder.mTvContentItemWeek.setText(weekModalList.get(position).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return weekModalList == null ? 0 : weekModalList.size();
    }

    class WeekViewHolder extends RecyclerView.ViewHolder {
        private CardView mCvItemWeek;
        private TextView mTvTitleItemWeek;
        private TextView mTvContentItemWeek;

        WeekViewHolder(View itemView) {
            super(itemView);
            mCvItemWeek = (CardView) itemView.findViewById(R.id.cv_item_week);
            mTvTitleItemWeek = (TextView) itemView.findViewById(R.id.tv_title_item_week);
            mTvContentItemWeek = (TextView) itemView.findViewById(R.id.tv_content_item_week);
        }
    }
}

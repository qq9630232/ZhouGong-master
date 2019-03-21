package com.xin.xiaoxinzone.UI.Main.constellation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.xin.xiaoxinzone.R;
import com.xin.xiaoxinzone.Utils.FortuneHttp;
import com.xin.xiaoxinzone.Utils.PercentUtils;
import com.xin.xiaoxinzone.Widget.customView.CustomPieChart;
import com.xin.xiaoxinzone.model.PieDataModel;
import com.xin.xiaoxinzone.model.TodayData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 今天或者明天的界面
 */
public class DayFragment extends Fragment {
    private static final String ARG_PARAM1 = "fortune";
    private static final String ARG_PARAM2 = "time";

    private List<PieDataModel> pieDataModelList;
    private CustomPieChart mCpcMain;
    private TextView mTvAllMain;
    private TextView mTvHealthMain;
    private TextView mTvLoveMain;
    private TextView mTvMoneyMain;
    private TextView mTvWorkMain;
    private TextView mTvColorMain;
    private TextView mTvNumMain;
    private TextView mTvFortuneMain;
    private TextView mTvTodayContent;

    private String fortune, time;

    public static DayFragment newInstance(String param1, String param2) {
        DayFragment fragment = new DayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fortune = getArguments().getString(ARG_PARAM1);
            time = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day, container, false);
        initView(view);
        initList();
        if (!TextUtils.isEmpty(fortune) && !TextUtils.isEmpty(time)) {
            Log.i("FragmentDay", fortune + "+++" + time);
            getDataFromJuHe(fortune, time);
        }
        return view;
    }

    /**
     * 初始化控件
     *
     * @param view 布局
     */
    private void initView(View view) {
        mCpcMain = (CustomPieChart) view.findViewById(R.id.cpc_main);
        mTvAllMain = (TextView) view.findViewById(R.id.tv_all_main);
        mTvHealthMain = (TextView) view.findViewById(R.id.tv_health_main);
        mTvLoveMain = (TextView) view.findViewById(R.id.tv_love_main);
        mTvMoneyMain = (TextView) view.findViewById(R.id.tv_money_main);
        mTvWorkMain = (TextView) view.findViewById(R.id.tv_work_main);
        mTvColorMain = (TextView) view.findViewById(R.id.tv_color_main);
        mTvNumMain = (TextView) view.findViewById(R.id.tv_num_main);
        mTvFortuneMain = (TextView) view.findViewById(R.id.tv_fortune_main);
        mTvTodayContent = (TextView) view.findViewById(R.id.tv_today_content);
    }

    /**
     * 初始化列表
     */
    private void initList() {
        pieDataModelList = new ArrayList<>();
    }

    /**
     * 从聚合网站获取星座运势的数据
     */
    private void getDataFromJuHe(final String fortune, final String time) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final String s = FortuneHttp.getFortune(fortune, time);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.i("response", "run: " + s);
                            TodayData todayData = new Gson().fromJson(s, TodayData.class);
                            initData(todayData);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 填充数据
     *
     * @param todayData 数据对象
     */
    private void initData(TodayData todayData) {
        if (todayData != null) {
            if (pieDataModelList != null && pieDataModelList.size() > 0) {
                pieDataModelList.clear();
            }
            PieDataModel all = new PieDataModel();
            all.setName("工作指数");
            all.setData(PercentUtils.getPercent(todayData.getWork()));
            all.setColor(getResources().getColor(R.color.red));
            pieDataModelList.add(all);

            PieDataModel health = new PieDataModel();
            health.setName("财运指数");
            health.setData(PercentUtils.getPercent(todayData.getMoney()));
            health.setColor(getResources().getColor(R.color.orange));
            pieDataModelList.add(health);

            PieDataModel love = new PieDataModel();
            love.setName("爱情指数");
            love.setData(PercentUtils.getPercent(todayData.getLove()));
            love.setColor(getResources().getColor(R.color.yellow));
            pieDataModelList.add(love);

            PieDataModel money = new PieDataModel();
            money.setName("健康指数");
            money.setData(PercentUtils.getPercent(todayData.getHealth()));
            money.setColor(getResources().getColor(R.color.green));
            pieDataModelList.add(money);

            PieDataModel work = new PieDataModel();
            work.setName("综合指数");
            work.setData(PercentUtils.getPercent(todayData.getAll()));
            work.setColor(getResources().getColor(R.color.blue));
            pieDataModelList.add(work);

            mCpcMain.setPieDataModelList(pieDataModelList);

            mTvAllMain.setText(todayData.getAll());
            mTvHealthMain.setText(todayData.getHealth());
            mTvLoveMain.setText(todayData.getLove());
            mTvMoneyMain.setText(todayData.getMoney());
            mTvWorkMain.setText(todayData.getWork());

            mTvNumMain.setText(String.valueOf(todayData.getNumber()));
            mTvColorMain.setText(todayData.getColor());
            mTvFortuneMain.setText(todayData.getQFriend());
            mTvTodayContent.setText(todayData.getSummary());
        }
    }
}

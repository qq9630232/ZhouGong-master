package com.xin.xiaoxinzone.UI.Main.constellation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.xin.xiaoxinzone.R;
import com.xin.xiaoxinzone.UI.Main.constellation.adapter.WeekAdapter;
import com.xin.xiaoxinzone.Utils.FortuneHttp;
import com.xin.xiaoxinzone.data.Data;
import com.xin.xiaoxinzone.model.MonthDataModel;
import com.xin.xiaoxinzone.model.WeekDataModel;
import com.xin.xiaoxinzone.model.WeekModal;
import com.xin.xiaoxinzone.model.YearDataModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeekFragment extends Fragment {
    private static final String ARG_PARAM1 = "fortune";
    private static final String ARG_PARAM2 = "time";

    private RecyclerView mRvWeek;
    private List<WeekModal> weekModalList;
    private WeekAdapter weekAdapter;

    private String fortune, time;

    public static WeekFragment newInstance(String param1, String param2) {
        WeekFragment fragment = new WeekFragment();
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
        View view = inflater.inflate(R.layout.fragment_week, container, false);
        initView(view);
        initList();
        initAdapter();
        if (!TextUtils.isEmpty(fortune) && !TextUtils.isEmpty(time)) {
            Log.i("FragmentWeek", fortune + "+++" + time);
            getDataFromJuHe(fortune, time);
            //testAdapter();
        }

        return view;
    }

    /**
     * 初始化控件
     *
     * @param view 布局
     */
    private void initView(View view) {
        mRvWeek = (RecyclerView) view.findViewById(R.id.rv_week);
    }

    /**
     * 初始化列表
     */
    private void initList() {
        weekModalList = new ArrayList<>();
    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        weekAdapter = new WeekAdapter(weekModalList, getActivity());
        mRvWeek.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvWeek.setAdapter(weekAdapter);
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
                            initData(s);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initData(String response) {
        if (!TextUtils.isEmpty(response)) {
            if (weekModalList != null && weekModalList.size() > 0) {
                weekModalList.clear();
            }
            if (TextUtils.equals(time, Data.getTime()[2])) {
                WeekDataModel weekDataModel = new Gson().fromJson(response, WeekDataModel.class);
                if (weekDataModel != null) {
                    if (!TextUtils.isEmpty(weekDataModel.getHealth())) {
                        WeekModal weekModal = new WeekModal();
                        weekModal.setTitle("健康");
                        weekModal.setContent(weekDataModel.getHealth());
                        weekModalList.add(weekModal);
                    }
                    if (weekDataModel.getJob() != null) {
                        WeekModal weekModal = new WeekModal();
                        weekModal.setTitle("工作");
                        weekModal.setContent((String) weekDataModel.getJob());
                        weekModalList.add(weekModal);
                    }
                    if (!TextUtils.isEmpty(weekDataModel.getLove())) {
                        WeekModal weekModal = new WeekModal();
                        weekModal.setTitle("爱情");
                        weekModal.setContent(weekDataModel.getLove());
                        weekModalList.add(weekModal);
                    }
                    if (!TextUtils.isEmpty(weekDataModel.getMoney())) {
                        WeekModal weekModal = new WeekModal();
                        weekModal.setTitle("财运");
                        weekModal.setContent(weekDataModel.getMoney());
                        weekModalList.add(weekModal);
                    }
                    if (!TextUtils.isEmpty(weekDataModel.getWork())) {
                        WeekModal weekModal = new WeekModal();
                        weekModal.setTitle("工作");
                        weekModal.setContent(weekDataModel.getWork());
                        weekModalList.add(weekModal);
                    }
                }

            } else if (TextUtils.equals(time, Data.getTime()[3])) {
                MonthDataModel monthDataModel = new Gson().fromJson(response, MonthDataModel.class);
                if (monthDataModel != null) {
                    if (!TextUtils.isEmpty(monthDataModel.getAll())) {
                        WeekModal weekModal = new WeekModal();
                        weekModal.setTitle("综合");
                        weekModal.setContent(monthDataModel.getAll());
                        weekModalList.add(weekModal);
                    }
                    if (!TextUtils.isEmpty(monthDataModel.getHealth())) {
                        WeekModal weekModal = new WeekModal();
                        weekModal.setTitle("健康");
                        weekModal.setContent(monthDataModel.getHealth());
                        weekModalList.add(weekModal);
                    }
                    if (!TextUtils.isEmpty(monthDataModel.getLove())) {
                        WeekModal weekModal = new WeekModal();
                        weekModal.setTitle("爱情");
                        weekModal.setContent(monthDataModel.getLove());
                        weekModalList.add(weekModal);
                    }
                    if (!TextUtils.isEmpty(monthDataModel.getMoney())) {
                        WeekModal weekModal = new WeekModal();
                        weekModal.setTitle("财运");
                        weekModal.setContent(monthDataModel.getMoney());
                        weekModalList.add(weekModal);
                    }
                    if (!TextUtils.isEmpty(monthDataModel.getWork())) {
                        WeekModal weekModal = new WeekModal();
                        weekModal.setTitle("工作");
                        weekModal.setContent(monthDataModel.getWork());
                        weekModalList.add(weekModal);
                    }
                }

            } else if (TextUtils.equals(time, Data.getTime()[4])) {
                YearDataModel yearDataModel = new Gson().fromJson(response, YearDataModel.class);
                if (yearDataModel != null) {
                    if (yearDataModel.getMima().getText() != null && yearDataModel.getMima().getText().size() > 0) {
                        if (!TextUtils.isEmpty(yearDataModel.getMima().getText().get(0))) {
                            WeekModal weekModal = new WeekModal();
                            weekModal.setTitle("综合");
                            weekModal.setContent(yearDataModel.getMima().getText().get(0));
                            weekModalList.add(weekModal);
                        }
                    }
                    if (yearDataModel.getCareer() != null && yearDataModel.getCareer().size() > 0) {
                        if (!TextUtils.isEmpty(yearDataModel.getCareer().get(0))) {
                            WeekModal weekModal = new WeekModal();
                            weekModal.setTitle("事业");
                            weekModal.setContent(yearDataModel.getCareer().get(0));
                            weekModalList.add(weekModal);
                        }
                    }
                    if (yearDataModel.getLove() != null && yearDataModel.getLove().size() > 0) {
                        if (!TextUtils.isEmpty(yearDataModel.getLove().get(0))) {
                            WeekModal weekModal = new WeekModal();
                            weekModal.setTitle("爱情");
                            weekModal.setContent(yearDataModel.getLove().get(0));
                            weekModalList.add(weekModal);
                        }
                    }
                    if (yearDataModel.getHealth() != null && yearDataModel.getHealth().size() > 0) {
                        if (!TextUtils.isEmpty(yearDataModel.getHealth().get(0))) {
                            WeekModal weekModal = new WeekModal();
                            weekModal.setTitle("健康");
                            weekModal.setContent(yearDataModel.getHealth().get(0));
                            weekModalList.add(weekModal);
                        }
                    }
                    if (yearDataModel.getFinance() != null && yearDataModel.getFinance().size() > 0) {
                        if (!TextUtils.isEmpty(yearDataModel.getFinance().get(0))) {
                            WeekModal weekModal = new WeekModal();
                            weekModal.setTitle("财运");
                            weekModal.setContent(yearDataModel.getFinance().get(0));
                            weekModalList.add(weekModal);
                        }
                    }
                }
            }
            weekAdapter.notifyDataSetChanged();
        }
    }
}

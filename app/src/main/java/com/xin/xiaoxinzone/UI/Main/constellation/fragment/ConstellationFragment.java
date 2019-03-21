package com.xin.xiaoxinzone.UI.Main.constellation.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.xin.xiaoxinzone.Base.BaseFragment;
import com.xin.xiaoxinzone.R;
import com.xin.xiaoxinzone.UI.Main.constellation.adapter.LeftMenuAdapter;
import com.xin.xiaoxinzone.Widget.customView.CustomFab;
import com.xin.xiaoxinzone.data.Data;
import com.xin.xiaoxinzone.model.Fortune;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDC on 2019/3/21.
 */

public class ConstellationFragment extends BaseFragment {
//    private ImageButton mIbLeftHead;
//    /**
//     * 今日运势
//     */
//    private TextView mTvContentHead;
    private ConstraintLayout mClContainerMain;
    private CustomFab mCfMain;
    private ConstraintLayout mClContentMain;
    private ImageView mIvLeft;
    private RecyclerView mRvLeft;
    private ConstraintLayout mClLeft;
    private DrawerLayout mDlMain;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    private LeftMenuAdapter leftMenuAdapter;
    private List<Fortune> fortuneList;

    private String fortune;//选中的星座名称
    private String time;//时间
    @Override
    protected void initData() {

        fortune = Data.getLeftMenuFortuneName()[0];
        time = Data.getTime()[0];
        showFragment();
    }

    @Override
    protected void initView() {

//        mIbLeftHead = (ImageButton) view.findViewById(R.id.ib_left_head);
//        mTvContentHead = (TextView) view.findViewById(R.id.tv_content_head);
        mClContainerMain = (ConstraintLayout) view.findViewById(R.id.cl_container_main);
        mCfMain = (CustomFab) view.findViewById(R.id.cf_main);
        mClContentMain = (ConstraintLayout) view.findViewById(R.id.cl_content_main);
        mIvLeft = (ImageView) view.findViewById(R.id.iv_left);
        mRvLeft = (RecyclerView) view.findViewById(R.id.rv_left);
        mClLeft = (ConstraintLayout) view.findViewById(R.id.cl_left);
        mDlMain = (DrawerLayout) view.findViewById(R.id.dl_main);
        initList();
        initLeftMenu();
        initAdapter();
        initLeftData();
        initFabMenu();
//        mIbLeftHead.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
    }
    /**
     * 初始化列表
     */
    private void initList() {
        fortuneList = new ArrayList<>();
    }

    /**
     * 初始化左侧菜单
     */
    private void initLeftMenu() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDlMain, 0, 0) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDlMain.setScrimColor(Color.TRANSPARENT);
        mDlMain.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public void onStart() {
        super.onStart();
//        EventBus.getDefault().register(this);

    }

//    public void onMessageEvent(MessageEvent event) {
//        /* Do something */
//        if(event!=null){
//            boolean send = event.isSend();
//            if(send==true){
//                openLeftLayout(view);
//            }
//        }
//    };
    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }

    /**
     * 对左侧菜单的开关方法
     *
     *
     */
    public void openLeftLayout( ) {
        if (mDlMain.isDrawerOpen(mClLeft)) {
            mDlMain.closeDrawer(mClLeft);
        } else {
            mDlMain.openDrawer(mClLeft);
        }
    }

    /**
     * 初始化左侧菜单的适配器
     */
    private void initAdapter() {
        leftMenuAdapter = new LeftMenuAdapter(fortuneList);
        mRvLeft.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvLeft.setAdapter(leftMenuAdapter);
        leftMenuAdapter.setOnItemClickListener(new LeftMenuAdapter.OnItemClickListener() {
            @Override
            public void setOnItemClickListener(int position) {
                if (!TextUtils.equals(fortune, Data.getLeftMenuFortuneName()[position])) {
                    fortune = Data.getLeftMenuFortuneName()[position];
                    for (Fortune fortune : fortuneList) {
                        fortune.setChoose(false);
                    }
                    fortuneList.get(position).setChoose(true);
                    leftMenuAdapter.notifyDataSetChanged();
                    mCfMain.setFabMenuIcon(Data.getLeftMenuFortuneIcon()[position]);
                    showFragment();
                }
                if (mDlMain.isDrawerOpen(mClLeft)) {
                    mDlMain.closeDrawer(mClLeft);
                }
            }
        });
    }

    /**
     * 初始化左侧菜单数据
     */
    private void initLeftData() {
        if (fortuneList != null && fortuneList.size() > 0) {
            fortuneList.clear();
        }
        String[] name = Data.getLeftMenuFortuneName();
        int[] icon = Data.getLeftMenuFortuneIcon();
        for (int i = 0; i < name.length; i++) {
            Fortune fortune = new Fortune();
            fortune.setName(name[i]);
            fortune.setIcon(icon[i]);
            fortuneList.add(fortune);
        }
        if (fortuneList != null && fortuneList.size() > 0) {
            fortuneList.get(0).setChoose(true);
        }
        leftMenuAdapter.notifyDataSetChanged();
    }

    /**
     * 初始化Fab系列按钮的点击事件
     */
    private void initFabMenu() {
        mCfMain.setOnWhichFab(new CustomFab.OnWhichFab() {
            @Override
            public void setOnWhichFab(int position) {
                if (!TextUtils.equals(time, Data.getTime()[position])) {
//                    mTvContentHead.setText(Data.getHeadContent()[position]);
                    time = Data.getTime()[position];
                    showFragment();
                }
            }
        });
    }


    /**
     * 显示fragment
     */
    private void showFragment() {
        @SuppressLint("CommitTransaction") FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (TextUtils.equals(time, Data.getTime()[0]) || TextUtils.equals(time, Data.getTime()[1])) {
            transaction.replace(R.id.cl_container_main, DayFragment.newInstance(fortune, time));
        } else {
            transaction.replace(R.id.cl_container_main, WeekFragment.newInstance(fortune, time));
        }
        transaction.commit();
    }
    @Override
    protected void initListener() {

    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_constellation_layout;
    }

    @Override
    protected void onClickListener(View v) {

    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        view = View.inflate(getActivity(), R.layout.fragment_constellation_layout, null);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        // TODO:OnCreateView Method has been created, run FindViewById again to generate code
//        initView(view);
//        return view;
//    }
}

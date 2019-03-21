package com.xin.xiaoxinzone.Widget.customView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.xin.xiaoxinzone.R;


/**
 * @author llq
 * @time 2018/6/19  10:22.
 * @faction 悬浮系列按钮
 * @description
 * @modify
 */
public class CustomFab extends LinearLayout implements View.OnClickListener {
    private FloatingActionButton mFabToday;
    private FloatingActionButton mFabTomorrow;
    private FloatingActionButton mFabWeek;
    private FloatingActionButton mFabMonth;
    private FloatingActionButton mFabYear;
    private FloatingActionButton mFabMenu;

    private OnWhichFab onWhichFab;//按钮点击事件接口

    private boolean isOpen = false;//开关

    public CustomFab(Context context) {
        super(context);
        initLayout(context);
        initView();
        initListener();
        init();
    }

    public CustomFab(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
        initView();
        initListener();
        init();
    }

    public CustomFab(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
        initView();
        initListener();
        init();
    }

    private void initLayout(Context context) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.view_custom_fab, this, true);
    }

    private void initView() {
        mFabToday = (FloatingActionButton) findViewById(R.id.fab_today);
        mFabTomorrow = (FloatingActionButton) findViewById(R.id.fab_tomorrow);
        mFabWeek = (FloatingActionButton) findViewById(R.id.fab_week);
        mFabMonth = (FloatingActionButton) findViewById(R.id.fab_month);
        mFabYear = (FloatingActionButton) findViewById(R.id.fab_year);
        mFabMenu = (FloatingActionButton) findViewById(R.id.fab_menu);
    }

    private void initListener() {
        mFabToday.setOnClickListener(this);
        mFabTomorrow.setOnClickListener(this);
        mFabWeek.setOnClickListener(this);
        mFabMonth.setOnClickListener(this);
        mFabYear.setOnClickListener(this);
        mFabMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_today:
                onWhichFab.setOnWhichFab(0);
                break;
            case R.id.fab_tomorrow:
                onWhichFab.setOnWhichFab(1);
                break;
            case R.id.fab_week:
                onWhichFab.setOnWhichFab(2);
                break;
            case R.id.fab_month:
                onWhichFab.setOnWhichFab(3);
                break;
            case R.id.fab_year:
                onWhichFab.setOnWhichFab(4);
                break;
            case R.id.fab_menu:
                if (isOpen) {
                    hideFab();
                    isOpen = false;
                } else {
                    showFab();
                    isOpen = true;
                }
                break;
        }
    }

    /**
     * 对外接口
     * 用于按钮的点击事件
     */
    public interface OnWhichFab {
        void setOnWhichFab(int position);
    }

    public void setOnWhichFab(OnWhichFab fab) {
        this.onWhichFab = fab;
    }

    /**
     * 对外接口
     * 用于设置菜单按钮的图标
     *
     * @param icon 图标
     */
    public void setFabMenuIcon(int icon) {
        mFabMenu.setImageResource(icon);
    }

    private void init() {
        isOpen = false;
        hideFab();
    }

    private void showFab() {
        mFabToday.setVisibility(VISIBLE);
        mFabTomorrow.setVisibility(VISIBLE);
        mFabWeek.setVisibility(VISIBLE);
        mFabMonth.setVisibility(VISIBLE);
        mFabYear.setVisibility(VISIBLE);
    }

    private void hideFab() {
        mFabToday.setVisibility(GONE);
        mFabTomorrow.setVisibility(GONE);
        mFabWeek.setVisibility(GONE);
        mFabMonth.setVisibility(GONE);
        mFabYear.setVisibility(GONE);
    }
}

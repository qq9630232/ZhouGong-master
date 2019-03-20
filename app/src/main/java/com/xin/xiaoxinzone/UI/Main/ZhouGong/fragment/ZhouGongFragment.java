package com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.xin.xiaoxinzone.Base.BaseFragment;
import com.xin.xiaoxinzone.R;
import com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.adapter.DreamGridViewAdapter;

/**
 * Created by SDC on 2019/3/20.
 */

public class ZhouGongFragment extends BaseFragment implements View.OnClickListener {
    /**
     * 搜索
     */
    private Button mSearchBtn;
    /**
     * 搜索梦，如：蛇
     */
    private EditText mSearchEdt;
    private GridView mJiemengGrid;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mSearchBtn = (Button) view.findViewById(R.id.search_btn);
        mSearchBtn.setOnClickListener(this);
        mSearchEdt = (EditText) view.findViewById(R.id.search_edt);
        mJiemengGrid = (GridView) view.findViewById(R.id.jiemeng_grid);
        mJiemengGrid.setAdapter(new DreamGridViewAdapter());
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_zg_layout;
    }

    @Override
    protected void onClickListener(View v) {

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.search_btn:
                String mSearchData = mSearchEdt.getText().toString().trim();

                break;
        }
    }
}

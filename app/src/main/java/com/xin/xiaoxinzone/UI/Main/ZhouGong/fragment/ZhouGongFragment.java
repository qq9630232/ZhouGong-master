package com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.xin.xiaoxinzone.Base.BaseFragment;
import com.xin.xiaoxinzone.R;
import com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.activity.DreamListActivity;
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
    private String mData = "";
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
        mJiemengGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mData =  "";

                switch (position){
                    case 0:
                        mData="人";
                        break;
                    case 1:
                        mData="动物";

                        break;
                    case 2:
                        mData="树";

                        break;
                    case 3:
                        mData="东西";
                        break;
                    case 4:
                        mData="运动";
                        break;
                    case 5:
                        mData="生活";
                        break;
                    case 6:
                        mData="打雷";
                        break;
                    case 7:
                        mData="鬼";
                        break;
                    case 8:
                        mData="建筑";
                        break;
                    case 9:
                        mData="恶梦";
                        break;
                }
                launch(mData);
            }
        });
    }

    private void launch(String data) {
        Intent intent = new Intent(getContext(), DreamListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("data",data);
        intent.putExtras(bundle);
        startActivity(intent);
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
                launch(mSearchData);
                break;
        }
    }
}

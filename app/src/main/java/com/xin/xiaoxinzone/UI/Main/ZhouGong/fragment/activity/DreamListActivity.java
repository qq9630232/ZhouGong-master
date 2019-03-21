package com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.activity;

import android.accounts.NetworkErrorException;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xin.xiaoxinzone.Base.BaseFragmentActivity;
import com.xin.xiaoxinzone.Entity.DreamBean;
import com.xin.xiaoxinzone.Http.ServiceFactory;
import com.xin.xiaoxinzone.Params.Constant;
import com.xin.xiaoxinzone.Params.Urls;
import com.xin.xiaoxinzone.R;
import com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.adapter.DreamDetailAdapter;
import com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.service.ZhouGongService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DreamListActivity extends BaseFragmentActivity implements View.OnClickListener {

    private ImageView mDreamDetailTitleBack;
    /**
     * 周公解梦
     */
    private TextView mDreamDetailTitleImg;
    private RelativeLayout mDreamDetailAppTitle;
    private GridView mDreamDetailGridView;
    private List<DreamBean.ResultEntity> dataList = new ArrayList<>();
    private DreamDetailAdapter adapter;
    /**
     * 加载文本笑话
     */
    public void loadDream(String data) {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("q",data);
        ServiceFactory.getInstance()
                .createService(Urls.baseHeadNewsUrl, ZhouGongService.class)
                .getSearchDream(objectObjectHashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DreamBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof NullPointerException){
                            Toast.makeText(DreamListActivity.this,"没有获取到想看的数据",Toast.LENGTH_SHORT).show();
                        }else if (e instanceof NetworkErrorException ||
                                e instanceof RuntimeException){
                            Toast.makeText(DreamListActivity.this,"网络离家出走了",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(DreamListActivity.this,"获取数据失败",Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onNext(DreamBean dreamBeanResult) {
                        if (Constant.LOAD_HEAD_NEWS_SUCCESS_CODE == dreamBeanResult.getError_code()){
                            List<DreamBean.ResultEntity> result = dreamBeanResult.getResult();
                            dataList.addAll(result);
                            adapter.notifyDataSetChanged();
                        }
                    }
                });

    }
    @Override
    protected void initData() {
        String mData = getIntent().getExtras().getString("data");
        adapter = new DreamDetailAdapter(dataList);
        mDreamDetailGridView.setAdapter(adapter);
        loadDream(mData);


    }
    @Override
    protected void initView() {
        mDreamDetailTitleBack = (ImageView) findViewById(R.id.dream_detail_title_back);
        mDreamDetailTitleBack.setOnClickListener(this);
        mDreamDetailTitleImg = (TextView) findViewById(R.id.dream_detail_title_img);
        mDreamDetailAppTitle = (RelativeLayout) findViewById(R.id.dream_detail_appTitle);
        mDreamDetailGridView = (GridView) findViewById(R.id.dream_detail_gridView);
        mDreamDetailGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DreamListActivity.this,DreamDetailsActivity.class);
                intent.putExtra("title",dataList.get(position).getTitle());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int setContentView() {
        return R.layout.activity_dream_list;
    }

    @Override
    protected void onClickListener(View v) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.dream_detail_title_back:
                finish();
                break;
        }
    }
}

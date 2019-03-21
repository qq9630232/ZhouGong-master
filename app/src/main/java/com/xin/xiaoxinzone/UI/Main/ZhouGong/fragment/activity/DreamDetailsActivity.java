package com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.activity;

import android.accounts.NetworkErrorException;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
import com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.adapter.DreamContentAdapter;
import com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.service.ZhouGongService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DreamDetailsActivity extends BaseFragmentActivity implements View.OnClickListener {

    private String title;
    private ImageView mDreamDetailTitleBack;
    private TextView mDreamDetailTitle;
    private RelativeLayout mDreamDetailAppTitle;
    private RecyclerView mDreamDetailsRv;
    private List<DreamBean.ResultEntity> list = new ArrayList<>();
    private DreamContentAdapter dreamContentAdapter;

    /**
     * 加载文本笑话
     */
    public void loadDream(String data) {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("q", data);
        objectObjectHashMap.put("full", 1);
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
                        if (e instanceof NullPointerException) {
                            Toast.makeText(DreamDetailsActivity.this, "没有获取到想看的数据", Toast.LENGTH_SHORT).show();
                        } else if (e instanceof NetworkErrorException ||
                                e instanceof RuntimeException) {
                            Toast.makeText(DreamDetailsActivity.this, "网络离家出走了", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(DreamDetailsActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onNext(DreamBean dreamBeanResult) {
                        if (Constant.LOAD_HEAD_NEWS_SUCCESS_CODE == dreamBeanResult.getError_code()) {
                            List<DreamBean.ResultEntity> result = dreamBeanResult.getResult();
                            list.addAll(result);
                            dreamContentAdapter.notifyDataSetChanged();
                        }
                    }
                });

    }

    @Override
    protected void initData() {
        title = getIntent().getStringExtra("title");
        loadDream(title);
        dreamContentAdapter = new DreamContentAdapter(this,list );
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mDreamDetailsRv.setLayoutManager(manager);
        mDreamDetailsRv.setAdapter(dreamContentAdapter);
        mDreamDetailTitle.setText(title);
    }

    @Override
    protected void initView() {

        mDreamDetailTitleBack = (ImageView) findViewById(R.id.dream_detail_title_back);
        mDreamDetailTitleBack.setOnClickListener(this);
        mDreamDetailTitle = (TextView) findViewById(R.id.dream_detail_title);
        mDreamDetailAppTitle = (RelativeLayout) findViewById(R.id.dream_detail_appTitle);
        mDreamDetailsRv = (RecyclerView) findViewById(R.id.dream_details_rv);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int setContentView() {
        return R.layout.activity_dream_details;
    }

    @Override
    protected void onClickListener(View v) {

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dream_details);
//        initView();
//    }

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

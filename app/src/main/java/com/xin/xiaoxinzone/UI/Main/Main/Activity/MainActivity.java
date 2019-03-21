package com.xin.xiaoxinzone.UI.Main.Main.Activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.xin.xiaoxinzone.Base.BaseFragmentActivity;
import com.xin.xiaoxinzone.R;
import com.xin.xiaoxinzone.UI.Main.HeadNews.Fragment.HomeHeadNewsFragment;
import com.xin.xiaoxinzone.UI.Main.Main.Model.MainModel;
import com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.ZhouGongFragment;
import com.xin.xiaoxinzone.UI.Main.constellation.fragment.ConstellationFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseFragmentActivity {

    @BindView(R.id.home_head_news_img)
    ImageView mImgHeadNews;
    @BindView(R.id.home_head_news_tv)
    TextView mTvHeadNews;

//    @BindView(R.id.home_me_img)
//    ImageView mImgMe;
//    @BindView(R.id.home_me_tv)
//    TextView mTvMe;
    @BindView(R.id.home_constellation_img)
    ImageView mImgConstellation;
    @BindView(R.id.home_constellation_tv)
    TextView mTvConstellation;
    @BindView(R.id.home_head_dream_img)
    ImageView mImgDream;
    @BindView(R.id.home_head_dream_tv)
    TextView mTvDream;
    @BindView(R.id.ib_left_head)
    ImageButton mIbLeftHead;
    @BindView(R.id.tv_content_head)
    TextView mTvContentHead;
    private FragmentManager manager;

    private MainModel model = new MainModel();

    private List<Fragment> fragmentList = new ArrayList<>();

    private List<TextView> tvList = new ArrayList<>();

    private List<ImageView> imgList = new ArrayList<>();

    public static final int home_dream_tag = 0;

    public static final int home_constellation_tag = 1;

    public static final int home_head_news_tag = 2;
    public static final int home_me_tag = 3;
    private ConstellationFragment constellationFragment;


    @Override
    protected void initData() {
        fragmentList.add(new ZhouGongFragment());
        constellationFragment = new ConstellationFragment();
        fragmentList.add(constellationFragment);

        fragmentList.add(new HomeHeadNewsFragment());
//        fragmentList.add(new HomeMeFragment());

        tvList.add(mTvDream);
        tvList.add(mTvConstellation);
        tvList.add(mTvHeadNews);
//        tvList.add(mTvMe);

        imgList.add(mImgDream);
        imgList.add(mImgConstellation);
        imgList.add(mImgHeadNews);
//        imgList.add(mImgMe);
        mTvContentHead.setText("周公解梦");

    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏
        setStatusStyle(TEXT_STATUS_BAR);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initListener() {

        manager = getSupportFragmentManager();
        //设置页面布局显示
        model.setShowFragment(manager, fragmentList, home_dream_tag, true);
        //设置显示的页面的button样式
        model.setShowFragmentTextStyle(mContext, tvList, imgList, home_dream_tag);

    }

    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onClickListener(View v) {

        switch (v.getId()) {
            case R.id.home_head_news:
                //设置页面布局显示
                model.setShowFragment(manager, fragmentList, home_head_news_tag, false);
                //设置显示的页面的button样式
                model.setShowFragmentTextStyle(mContext, tvList, imgList, home_head_news_tag);
                mTvContentHead.setText("头条新闻");
                mIbLeftHead.setVisibility(View.INVISIBLE);

                break;
            case R.id.home_head_dream:

                //设置页面布局显示
                model.setShowFragment(manager, fragmentList, home_dream_tag, false);
                //设置显示的页面的button样式
                model.setShowFragmentTextStyle(mContext, tvList, imgList, home_dream_tag);
                mTvContentHead.setText("周公解梦");
                mIbLeftHead.setVisibility(View.INVISIBLE);

                break;
            case R.id.home_constellation:

                //设置页面布局显示
                model.setShowFragment(manager, fragmentList, home_constellation_tag, false);
                //设置显示的页面的button样式
                model.setShowFragmentTextStyle(mContext, tvList, imgList, home_constellation_tag);
                mTvContentHead.setText("星座解析");
                mIbLeftHead.setVisibility(View.VISIBLE);
                break;
//            case R.id.home_me:
//
//                //设置页面布局显示
//                model.setShowFragment(manager, fragmentList, home_me_tag, false);
//                //设置显示的页面的button样式
//                model.setShowFragmentTextStyle(mContext, tvList, imgList, home_me_tag);
//                mTvContentHead.setText("我的");
//                mIbLeftHead.setVisibility(View.INVISIBLE);
//
//                break;
            case R.id.ib_left_head:
//                MessageEvent messageEvent = new MessageEvent();
//                messageEvent.setSend(true);
                constellationFragment.openLeftLayout();
//                EventBus.getDefault().postSticky(true);

                break;

        }

    }





}

package com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.service;

import com.xin.xiaoxinzone.Entity.DreamBean;
import com.xin.xiaoxinzone.Params.Constant;
import com.xin.xiaoxinzone.Params.Urls;

import java.util.HashMap;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by SDC on 2019/3/20.
 */

public interface ZhouGongService {
    @GET(Urls.searchUrl + "?key=" + Constant.JU_ZHOU_GONG_SEARCH_KEY)
    Observable<DreamBean> getSearchDream(@QueryMap HashMap<String,Object> map
                                            );
    @GET(Urls.searchUrl + "?key=" + Constant.JU_ZHOU_GONG_CLICK_KEY)
    Observable<DreamBean> getClickDream(@Query("q") String q);
}

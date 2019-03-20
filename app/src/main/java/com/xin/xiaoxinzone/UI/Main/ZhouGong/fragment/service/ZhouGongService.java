package com.xin.xiaoxinzone.UI.Main.ZhouGong.fragment.service;

import com.xin.xiaoxinzone.Entity.Joke;
import com.xin.xiaoxinzone.Entity.Result;
import com.xin.xiaoxinzone.Params.Constant;
import com.xin.xiaoxinzone.Params.Urls;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by SDC on 2019/3/20.
 */

public interface ZhouGongService {
    @GET(Urls.searchUrl + "?key=" + Constant.JU_ZHOU_GONG_SEARCH_KEY)
    Observable<Result<Joke>> getSearchDream(@Query("q") String q,
                                         @Query("full") String full
                                        );
    @GET(Urls.searchUrl + "?key=" + Constant.JU_ZHOU_GONG_CLICK_KEY)
    Observable<Result<Joke>> getClickDream(@Query("q") String q);
}

package com.xin.xiaoxinzone.Utils;

import java.io.IOException;
import java.net.URLEncoder;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author llq
 * @time 2018/6/19  15:52.
 * @faction 网络请求
 * @description
 * @modify
 */
public class FortuneHttp {
    private static final String APP_KEY = "39bb1a72145ce9c36e326c5e437b23d4";//申请的聚合数据的APPKey
    private static final String BASE_URL = "http://web.juhe.cn:8080/constellation/getAll";

    public static String getFortune(String fortune, String time) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = BASE_URL + "?" + "consName=" + URLEncoder.encode(fortune, "utf-8") + "&type=" + time + "&key=" + APP_KEY;
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.body().string();
    }
}

package com.xin.xiaoxinzone.Utils;

/**
 * @author llq
 * @time 2018/6/20  11:46.
 * @faction 百分比工具
 * @description
 * @modify
 */
public class PercentUtils {
    /**
     * 40% --> 40
     *
     * @param data 字符串
     * @return 整数值
     */
    public static int getPercent(String data) {
        String[] a = data.split("%");
        return Integer.parseInt(a[0]);
    }
}

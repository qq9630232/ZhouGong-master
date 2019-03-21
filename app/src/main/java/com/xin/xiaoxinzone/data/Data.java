package com.xin.xiaoxinzone.data;


import com.xin.xiaoxinzone.R;

/**
 * @author llq
 * @time 2018/6/15  16:01.
 * @faction 数据
 * @description
 * @modify
 */
public class Data {
    /**
     * 星座名称
     *
     * @return 字符串数组
     */
    public static String[] getLeftMenuFortuneName() {
        return new String[]{"水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"};
    }

    /**
     * 星座图标
     *
     * @return 整数数组
     */
    public static int[] getLeftMenuFortuneIcon() {
        return new int[]{R.mipmap.aquarius, R.mipmap.pisces, R.mipmap.aries, R.mipmap.taurus, R.mipmap.gemini, R.mipmap.cancer, R.mipmap.leo, R.mipmap.virgo, R.mipmap.libra, R.mipmap.scorpio, R.mipmap.sagittarius, R.mipmap.capricornus};
    }

    /**
     * 请求参数 时间
     *
     * @return 字符串数组
     */
    public static String[] getTime() {
        return new String[]{"today", "tomorrow", "week", "month", "year"};
    }

    /**
     * 标题 对应选择的时间
     *
     * @return 字符串数组
     */
    public static String[] getHeadContent() {
        return new String[]{"今日运势", "明日运势", "本周运势", "本月运势", "本年运势"};
    }

    /**
     * cardView的背景颜色
     *
     * @return 整数数组
     */
    public static int[] getCardViewBgColor() {
        return new int[]{R.color.red, R.color.orange, R.color.yellow, R.color.green, R.color.blue};
    }
}

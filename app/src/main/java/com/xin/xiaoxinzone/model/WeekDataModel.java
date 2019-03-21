package com.xin.xiaoxinzone.model;

/**
 * @author llq
 * @time 2018/6/20  15:54.
 * @faction
 * @description
 * @modify
 */
public class WeekDataModel {


    /**
     * name : 水瓶座
     * weekth : 25
     * date : 2018年06月17日-2018年06月23日
     * health :
     * job : null
     * love : 恋爱：本周你桃花运比较好，而且所处的环境也会有很多机会导致你因为选择多而有点滥情了。
     * money : 财运：本周你的财运很不错，机会也比较多，容易把握的住，所以钱当然也很能赚了。
     * work : 工作：本周你在工作上会有比较重要的事情要去处理，有时候需要同时处理好几件事，会比较忙碌。
     * resultcode : 200
     * error_code : 0
     */

    private String name;
    private int weekth;
    private String date;
    private String health;
    private Object job;
    private String love;
    private String money;
    private String work;
    private String resultcode;
    private int error_code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeekth() {
        return weekth;
    }

    public void setWeekth(int weekth) {
        this.weekth = weekth;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public Object getJob() {
        return job;
    }

    public void setJob(Object job) {
        this.job = job;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}

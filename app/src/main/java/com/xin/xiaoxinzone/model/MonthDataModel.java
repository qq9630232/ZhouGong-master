package com.xin.xiaoxinzone.model;

/**
 * @author llq
 * @time 2018/6/20  15:55.
 * @faction
 * @description
 * @modify
 */
public class MonthDataModel {

    /**
     * date : 2018年06月
     * name : 水瓶座
     * month : 6
     * all : 长途旅行、考试、出版、贸易等变得更加顺利，月初仍有短途旅行的机会，金星进驻家庭宫，会想呆在家里，美化家居环境或者享受悠闲时光，和恋人的沟通变多。日火移位工作宫，忙于工作，办事靠谱，深得领导青睐，即便是国外出差，也很少遇到麻烦。
     * health : 精神有些焦虑，多注意放松。
     * love : 有伴的人，在家或者长途旅行都很好。单身的人，在家会得到身心的放松。
     * money : 不动产方面有进账。
     * work : 工作任务变多，忙忙碌碌，有些敏感，精神有些紧绷，学习、长途旅行、领导的支持，能让你充满信心。
     * happyMagic :
     * resultcode : 200
     * error_code : 0
     */

    private String date;
    private String name;
    private int month;
    private String all;
    private String health;
    private String love;
    private String money;
    private String work;
    private String happyMagic;
    private String resultcode;
    private int error_code;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
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

    public String getHappyMagic() {
        return happyMagic;
    }

    public void setHappyMagic(String happyMagic) {
        this.happyMagic = happyMagic;
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

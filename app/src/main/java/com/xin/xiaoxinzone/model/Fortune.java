package com.xin.xiaoxinzone.model;

/**
 * @author llq
 * @time 2018/6/15  15:54.
 * @faction 左侧菜单的星座实体类
 * @description
 * @modify
 */
public class Fortune {
    private int icon;
    private String name;
    private boolean isChoose;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        isChoose = choose;
    }
}

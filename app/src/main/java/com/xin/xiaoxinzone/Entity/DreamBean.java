package com.xin.xiaoxinzone.Entity;

import java.util.List;

/**
 * Created by Administrator on 2016/3/28.
 */
public class DreamBean {

    private List<ResultEntity> result;
    private String reason;
    private int error_code;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public String getReason() {
        return reason;
    }

    public int getError_code() {
        return error_code;
    }

    public class ResultEntity {
        /**
         * id : 91e3f994eb2f601e5f8940a586e99015
         * des : 梦见死人或死亡不用害怕，不一定是坏事。
         * title : 死人
         */
        private String id;
        private String des;
        private String title;
        private String[] list;

        public String[] getList() {
            return list;
        }

        public void setList(String[] list) {
            this.list = list;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public String getDes() {
            return des;
        }

        public String getTitle() {
            return title;
        }
    }
}

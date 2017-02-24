package com.dbstar.orderdispose.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by wh on 2017/2/23.
 */

public class FilmOrder {

    /**
     * status : {"code":"1","msg":"成功"}
     * data : [{"id":"2001684334","name":"分手合约","createTime":"2017-16-24 02:16:52","roomid":"101","type":"包天计费","money":"48","status":"0"},{"id":"2112919781","name":"分手合约","createTime":"2017-20-24 02:20:53","roomid":"101","type":"包天计费","money":"0","status":"0"}]
     */

    private StatusBean status;
    private List<DataBean> data;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class StatusBean {
        /**
         * code : 1
         * msg : 成功
         */

        private String code;
        private String msg;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public static class DataBean {
        /**
         * id : 2001684334
         * name : 分手合约
         * createTime : 2017-16-24 02:16:52
         * roomid : 101
         * type : 包天计费
         * money : 48
         * status : 0
         */

        private String id;
        private String name;
        private String createTime;
        private String roomid;
        private String type;
        private String money;
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getRoomid() {
            return roomid;
        }

        public void setRoomid(String roomid) {
            this.roomid = roomid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }

    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

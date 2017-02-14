package com.dbstar.orderdispose.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by wh on 2016/12/26.
 */
public class Order {


    /**
     * status : {"code":"1","msg":"成功"}
     * data : [{"number":"ep-1156953625","totalmoney":"53","createdate":"2016-14-23 02:14:37","roomId":"101","ordersNum":"5","mark":"已处理"}]
     */

    private StatusBean status;
    private List<OrderBean> data;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public List<OrderBean> getData() {
        return data;
    }

    public void setData(List<OrderBean> data) {
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

    public static class OrderBean {
        /**
         * number : ep-1156953625
         * totalmoney : 53
         * createdate : 2016-14-23 02:14:37
         * roomId : 101
         * ordersNum : 5
         * mark : 已处理
         */

        private String number;
        private String totalmoney;
        private String createdate;
        private String roomId;
        private String ordersNum;
        private String mark;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getTotalmoney() {
            return totalmoney;
        }

        public void setTotalmoney(String totalmoney) {
            this.totalmoney = totalmoney;
        }

        public String getCreatedate() {
            return createdate;
        }

        public void setCreatedate(String createdate) {
            this.createdate = createdate;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public String getOrdersNum() {
            return ordersNum;
        }

        public void setOrdersNum(String ordersNum) {
            this.ordersNum = ordersNum;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

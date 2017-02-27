package com.dbstar.orderdispose.constant;

/**
 * Created by wh on 2016/12/26.
 */
public class URL {

    //后台IP地址
    public static final String IP = "http://192.168.0.205:8080";
//    public static final String IP = "http://192.168.0.254:8080";
//    public static final String IP = "http://116.231.55.196:9877";
//    192.168.0.254

    //http://192.168.0.232:8080/bar/media/getMediaNewOrder.do
    // 电影未处理订单
    public static final String NewFilmOrder = IP + "/bar/media/getMediaNewOrder.do";
    // 电影已处理订单
    public static final String OldFilmOrder = IP + "/bar/media/getMediaOldOrder.do";
    // 电影订单标记处理完成
    public static final String FilmOrderMark = IP + "/bar/media/getMediaOldOrderStaus.do";

    //点餐已处理订单
    public static final String OldOrder = IP + "/bar/media/getOldOrder.do";

    //点餐未处理订单
    public static final String NewOrder = IP + "/bar/media/getNewOrder.do";

    //点餐订单详情
    public static final String OrderItem = IP + "/bar/media/getOrderItem.do";
    //点餐订单详情-订单号
    public static final String NUMBER = "number";

    //标记已经处理完成
    public static final String OrderMark = IP + "/bar/media/updateMark.do";
    //订单号
    public static final String OrderMarkID = "id";
    //标记订单已经处理完毕
    public static final String OrderMarkFLAG = "flag=0";

    //购物已处理订单
    public static final String ShoppingOldOrder = IP + "/bar/media/getShoppingOldOrder.do";

    //购物未处理订单
    public static final String ShoppingNewOrder = IP + "/bar/media/getShoppingNewOrder.do\n";

    //购物详情
    public static final String ShoppingOrderItem = IP + "/bar/media/getShoppingOrderItem.do";

    //一键送物已处理订单
    public static final String AccessoriesOldOrder = IP + "/bar/media/getAccessoriesOldOrder.do";

    //一键送物未处理订单
    public static final String AccessoriesNewOrder = IP + "/bar/media/getAccessoriesNewOrder.do";


    //一键送物详情
    public static final String AccessoriesOrderItem = IP + "/bar/media/getAccessoriesOrderItem.do";

}

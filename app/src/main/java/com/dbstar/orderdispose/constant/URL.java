package com.dbstar.orderdispose.constant;

/**
 * Created by wh on 2016/12/26.
 */
public class URL {


    //后台IP地址
    public static String IP = "";
//    public static  String IP = "http://192.168.0.254:8080";
//    public static  String IP = "http://116.231.55.196:9877";
//    192.168.0.254

    //http://192.168.0.232:8080/bar/media/getMediaNewOrder.do
    // 电影未处理订单
    public static  String NewFilmOrder = "/bar/media/getMediaNewOrder.do";
    // 电影已处理订单
    public static  String OldFilmOrder = "/bar/media/getMediaOldOrder.do";
    // 电影订单标记处理完成
    public static  String FilmOrderMark = "/bar/media/getMediaOldOrderStaus.do";

    //点餐已处理订单
    public static  String OldOrder = "/bar/media/getOldOrder.do";

    //点餐未处理订单
    public static  String NewOrder = "/bar/media/getNewOrder.do";

    //点餐订单详情
    public static  String OrderItem = "/bar/media/getOrderItem.do";
    //点餐订单详情-订单号
    public static  String NUMBER = "number";

    //标记已经处理完成
    public static  String OrderMark = "/bar/media/updateMark.do";
    //订单号
    public static  String OrderMarkID = "id";
    //标记订单已经处理完毕
    public static  String OrderMarkFLAG = "flag=0";

    //购物已处理订单
    public static  String ShoppingOldOrder = "/bar/media/getShoppingOldOrder.do";

    //购物未处理订单
    public static  String ShoppingNewOrder = "/bar/media/getShoppingNewOrder.do\n";

    //购物详情
    public static  String ShoppingOrderItem = "/bar/media/getShoppingOrderItem.do";

    //一键送物已处理订单
    public static  String AccessoriesOldOrder = "/bar/media/getAccessoriesOldOrder.do";

    //一键送物未处理订单
    public static  String AccessoriesNewOrder = "/bar/media/getAccessoriesNewOrder.do";


    //一键送物详情
    public static  String AccessoriesOrderItem = "/bar/media/getAccessoriesOrderItem.do";

}

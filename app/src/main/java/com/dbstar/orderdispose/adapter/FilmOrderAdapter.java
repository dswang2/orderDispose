package com.dbstar.orderdispose.adapter;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dbstar.orderdispose.MainActivity;
import com.dbstar.orderdispose.R;
import com.dbstar.orderdispose.bean.FilmOrder;
import com.dbstar.orderdispose.bean.Order;
import com.dbstar.orderdispose.constant.URL;
import com.dbstar.orderdispose.utils.HttpUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by dswang on 2016/12/25.
 */

public class FilmOrderAdapter extends RecyclerView.Adapter<FilmOrderAdapter.FilmOrderHolder>{

    private static final String TAG = "dsw_OrderAdapter";
    private final MainActivity mainActivity;

    private boolean flag = false;

    public void setFlag(Boolean flag){
        this.flag = flag;
    }

    private List<FilmOrder.DataBean> datas;
    private int layoutPosition;

    private OnRecyclerViewItemClickListener mOnItemClickListener;
    public  interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data,int position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public FilmOrderAdapter(MainActivity mainActivity,List<FilmOrder.DataBean> datas) {
        this.mainActivity = mainActivity;
        this.datas = datas;
    }

    @Override
    public FilmOrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mainActivity).inflate(R.layout.order_item,parent,false);
        return new FilmOrderHolder(v);
    }

    @Override
    public void onBindViewHolder(final FilmOrderHolder holder, final int position) {
        final FilmOrder.DataBean order = datas.get(position);
        if(order==null){
            return;
        }
        holder.rvitem_tv_filmname.setText(order.getName());
        holder.rvitem_tv_number.setText(order.getId());
        holder.rvitem_tv_createdate.setText(order.getCreateTime());
        holder.rvitem_tv_ordersNum.setText(order.getType());
        holder.rvitem_tv_roomId.setText(order.getRoomid());
        holder.rvitem_tv_totalmoney.setText(order.getMoney());
        //在用户没有点击任何 item 之前，所有item 均不设置背景颜色
        if(true == flag && position == layoutPosition){
            // flag = true 表示已经点击过订单列表，可以设置点击过的 Item 背景色
            // position == layoutPosition 点击位置
            holder.recycler_item.setBackgroundResource(R.drawable.oder_radio_checked);
        }else{
            holder.recycler_item.setBackgroundResource(R.drawable.oder_radio_unchecked);
        }

        holder.recycler_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = true;
                //获取当前点击的位置
                layoutPosition = holder.getLayoutPosition();
                //刷新Recyclerview,改变被点击位置的背景颜色
                notifyDataSetChanged();

                //访问网络 查询 历史订单，更新订单列表
                /**
                 * 发送 订单号 到 MainActivity，在MainActivity中拼接地址，访问网络并更新详情列表
                 */
                //发送到MainActivity，刷新订单详情
                Message msg = new Message();
                Bundle detail = new Bundle();// 存放数据
                detail.putInt("filmDatasIndex",position);
                detail.putString("orderTime",order.getCreateTime());
                detail.putString("orderRoomId",order.getRoomid());
                detail.putString("orderNumber",order.getName());
                msg.setData(detail);
                msg.what = 3;
                mainActivity.getHandler().sendMessage(msg);

            }
        });

    }

    @Override
    public int getItemCount() {
        if(datas==null || datas.isEmpty()){
            return 0;
        }else {
            return datas.size();
        }
    }

    class FilmOrderHolder extends RecyclerView.ViewHolder{
        public LinearLayout recycler_item;  //Recyclerview Item 的线性布局控件
        public TextView rvitem_tv_filmname; //节目名称
        public TextView rvitem_tv_number;   //订单编号
        public TextView rvitem_tv_createdate;   //订单创建时间
        public TextView rvitem_tv_ordersNum;    //订单中的 数量
        public TextView rvitem_tv_roomId;   //房间号码
        public TextView rvitem_tv_totalmoney;   //总价格
        public FilmOrderHolder(View itemView) {
            super(itemView);
            rvitem_tv_filmname = (TextView) itemView.findViewById(R.id.rvitem_tv_filmname);
            rvitem_tv_number = (TextView) itemView.findViewById(R.id.rvitem_tv_number);
            recycler_item = (LinearLayout) itemView.findViewById(R.id.recycler_item);
            rvitem_tv_createdate = (TextView) itemView.findViewById(R.id.rvitem_tv_createdate);
            rvitem_tv_ordersNum = (TextView) itemView.findViewById(R.id.rvitem_tv_ordersNum);
            rvitem_tv_roomId = (TextView) itemView.findViewById(R.id.rvitem_tv_roomId);
            rvitem_tv_totalmoney = (TextView) itemView.findViewById(R.id.rvitem_tv_totalmoney);
        }
    }
}


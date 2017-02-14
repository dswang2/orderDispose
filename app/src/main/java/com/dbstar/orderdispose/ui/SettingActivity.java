package com.dbstar.orderdispose.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.dbstar.orderdispose.MainActivity;
import com.dbstar.orderdispose.MyApplication;
import com.dbstar.orderdispose.R;
import com.dbstar.orderdispose.constant.Constant;

/**
 * Created by wh on 2017/1/6.
 */
public class SettingActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private ToggleButton mSet_tb_print;
    private SharedPreferences sp;
    private SharedPreferences.Editor sp_editor;
    private ToggleButton set_tb_voice;
    private TextView set_tv_count;
    private int print_count = 1;    //打印次数
    private MyApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.settings);

        application = (MyApplication) getApplication();

        Toolbar toolbar = (Toolbar) findViewById(R.id.set_toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.set_drawer_layout);

        //侧滑菜单设置
        NavigationView navView = (NavigationView) findViewById(R.id.set_nav_view);
        navView.setCheckedItem(R.id.set_nav_homepage);//菜单的点击事件
        navView.setNavigationItemSelectedListener(new MyOnNavigationItemSelectedListener());

        //Toolbar左侧的引导按钮
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator((R.drawable.ic_arrow_back));

        }

        sp = this.getSharedPreferences("config", MODE_PRIVATE);
        sp_editor = sp.edit();

        //新订单自动打印
        boolean isPrintAuto = sp.getBoolean(Constant.AUTO_PRINT,false);
        mSet_tb_print = (ToggleButton) findViewById(R.id.set_tb_print);
        mSet_tb_print.setChecked(isPrintAuto);
        mSet_tb_print.setOnCheckedChangeListener(this);

        //新订单语音提示
        boolean isVoiceEnable = sp.getBoolean(Constant.VOICE_ENABLE,false);
        set_tb_voice = (ToggleButton) findViewById(R.id.set_tb_voice);
        set_tb_voice.setChecked(isVoiceEnable);
        set_tb_voice.setOnCheckedChangeListener(this);

        //订单打印重复次数
        Button set_bt_count_up = (Button)findViewById(R.id.set_bt_count_up);
        Button set_bt_count_down = (Button)findViewById(R.id.set_bt_count_down);
        set_bt_count_up.setOnClickListener(this);
        set_bt_count_down.setOnClickListener(this);
        set_tv_count = (TextView)findViewById(R.id.set_tv_count);
        print_count = sp.getInt(Constant.PRINT_COUNT, 1);
        set_tv_count.setText(""+ print_count);


        //保存并返回
        Button set_bt_back = (Button)findViewById(R.id.set_bt_back);
        set_bt_back.setOnClickListener(this);


    }






    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //引导按钮监听
            case android.R.id.home:
                onBackPressed();
                break;
            default:
        }
        return true;
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            //引导按钮监听
            case R.id.set_tb_print:
                Log.d("CompoundButton", "onCheckedChanged: set_tb_print");
                sp_editor.putBoolean(Constant.AUTO_PRINT, isChecked);
                sp_editor.commit();
                application.setIsPrintAuto(isChecked);
                break;
            case R.id.set_tb_voice:
                Log.d("CompoundButton", "onCheckedChanged: set_tb_voice");
                sp_editor.putBoolean(Constant.VOICE_ENABLE, isChecked);
                sp_editor.commit();
                application.setIsVoiceEnable(isChecked);
                break;
            default:
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //引导按钮监听
            case R.id.set_bt_back:
                //保存打印次数
                sp_editor.putInt(Constant.PRINT_COUNT,print_count);
                sp_editor.commit();
                application.setPrint_count(print_count);
                //返回
                onBackPressed();
                break;
            case R.id.set_bt_count_up:
                if ( print_count < Constant.PRINT_MAX_COUNT ) {
                    print_count += 1;

                }
                set_tv_count.setText("" + print_count);
                break;
            case R.id.set_bt_count_down:
                if( print_count > 1 ){
                    print_count -= 1;
                }
                set_tv_count.setText(""+print_count);
                break;
            default:
        }
    }

    private class MyOnNavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case R.id.set_nav_homepage:
                    mDrawerLayout.closeDrawers();
                    openMainActivity();
                    break;
                case R.id.set_nav_settings:
                    //跳转到 连接打印服务 界面
                    mDrawerLayout.closeDrawers();
                    break;
                default:break;
            }
            return true;
        }
    }
}

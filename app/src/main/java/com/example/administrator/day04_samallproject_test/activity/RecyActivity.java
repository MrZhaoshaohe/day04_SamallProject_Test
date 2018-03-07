package com.example.administrator.day04_samallproject_test.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.day04_samallproject_test.R;
import com.example.administrator.day04_samallproject_test.fragment.RecyFragment;
import com.example.administrator.day04_samallproject_test.fragment.ShouCangFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class RecyActivity extends AppCompatActivity {


    private BottomTabBar bottom_tab_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy);

        initView();
        initData();
    }

    private void initData() {

        bottom_tab_bar.init(getSupportFragmentManager())
                .setChangeColor(Color.RED, Color.GRAY)
                .addTabItem("列表",R.mipmap.a,R.mipmap.aa, RecyFragment.class)
                .addTabItem("收藏",R.mipmap.dd,R.mipmap.cc,ShouCangFragment.class)
                .isShowDivider(true);

    }

    private void initView() {
        bottom_tab_bar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
    }
}

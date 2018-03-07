package com.example.administrator.day04_samallproject_test.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.day04_samallproject_test.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_insert;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.set);
        img.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Intent intent =new Intent(MainActivity.this,RecyActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private void initView() {
        btn_insert = (Button) findViewById(R.id.btn_insert);
        img = (ImageView) findViewById(R.id.img);

        btn_insert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_insert:

                Intent intent =new Intent(MainActivity.this,RecyActivity.class);
                startActivity(intent);
                break;
        }
    }
}

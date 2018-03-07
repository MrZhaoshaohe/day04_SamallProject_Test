package com.example.administrator.day04_samallproject_test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.day04_samallproject_test.R;
import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {
//dasdsa
    private ImageView img_info;
    private TextView name_txt;
    private TextView content_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initView();
        initData();
    }

    private void initData() {

        String img = getIntent().getStringExtra("img");
        String name = getIntent().getStringExtra("name");
        String content = getIntent().getStringExtra("content");

        Picasso.with(this).load(img).into(img_info);
        name_txt.setText(name);
        content_txt.setText(content);
    }

    private void initView() {
        img_info = (ImageView) findViewById(R.id.img_info);
        name_txt = (TextView) findViewById(R.id.name_txt);
        content_txt = (TextView) findViewById(R.id.content_txt);
    }
}

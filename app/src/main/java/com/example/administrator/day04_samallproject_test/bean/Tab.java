package com.example.administrator.day04_samallproject_test.bean;

/**
 * Created by Administrator on 2018/3/6.
 */

public class Tab {
    private String name ;
    private Class Fragment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getFragment() {
        return Fragment;
    }

    public void setFragment(Class fragment) {
        Fragment = fragment;
    }

    public Tab(String name, Class fragment) {

        this.name = name;
        Fragment = fragment;
    }
}

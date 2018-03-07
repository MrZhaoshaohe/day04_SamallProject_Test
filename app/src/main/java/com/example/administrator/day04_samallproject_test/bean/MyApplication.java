package com.example.administrator.day04_samallproject_test.bean;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendaodemo.gen.DaoMaster;
import com.example.greendaodemo.gen.DaoSession;

public class MyApplication extends Application {

    public static MyApplication application;

    private DaoSession daoSession;

    public static MyApplication getApplication() {
        return application;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        createDB();
    }

    private void createDB() {
//        创建数据库辅助类对象
        DaoMaster.DevOpenHelper  devOpenHelper=new DaoMaster.DevOpenHelper(this,"greenDao.db");
//        数据库对象
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
//        连接数据库
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}

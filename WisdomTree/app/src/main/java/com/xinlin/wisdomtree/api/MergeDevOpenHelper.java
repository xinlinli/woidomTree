package com.xinlin.wisdomtree.api;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.MyApplication;
import com.anye.greendao.gen.DaoMaster;
import com.anye.greendao.gen.DaoSession;

/**
 * Created by lixinlin on 2018/1/19.
 */

public class MergeDevOpenHelper extends DaoMaster.DevOpenHelper  {

    private static DaoSession daoSession;

    public MergeDevOpenHelper(Context context, String name) {
        super(context, name);
    }

    public MergeDevOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            new UpgradeHelper().upgrade(db, this);
        }
    }

    /**
     * 这个直接拿到session的做法不能满足级联操作，所以有了获得daoMaster的方法
     * @param dbName
     * @return
     */
    public static DaoSession getDaoSession(String dbName) {
        if(daoSession == null){
            MergeDevOpenHelper devOpenHelperDBqianyi = new MergeDevOpenHelper(MyApplication.getmApplication(),dbName);
            DaoMaster daoMaster = new DaoMaster(devOpenHelperDBqianyi.getWritableDb());
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    /**
     * 获得级联效果的及时响应需要新的daoSession,而新的Session需要新的DaoMaster，所以有了这个封装
     * @param dbName
     * @return
     */
    public static DaoMaster getDaoMaster(String dbName) {
        DaoMaster daoMaster = null;
        if(daoSession == null){
            MergeDevOpenHelper devOpenHelperDBqianyi = new MergeDevOpenHelper(MyApplication.getmApplication(),dbName);
            daoMaster = new DaoMaster(devOpenHelperDBqianyi.getWritableDb());
        }
        return daoMaster;
    }



}

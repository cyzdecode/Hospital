package com.cyz.android.hospital.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 陈志 on 2018/11/29.
 */

public class DataBaseHelper extends SQLiteOpenHelper{
    private static String sql = "create table if not exists user(" +
            "u_id integer primary key autoincrement," +
            "u_loginName text not null," +
            "u_passWord text not null)";
    private static String sql1 = "create table if not exists hosregister(" +
            "hosR_id integer primary key autoincrement," +
            "hosR_name text not null," +
            "hosR_sex integer not null," +
            "hosR_age integer not null," +
            "hosR_phone text not null,"+
            "hosR_idCard text not null," +
            "hosR_docname text not null," +
            "hosR_regPrice double not null," +
            "hosR_createTime text not null)";

    //hosR_id hosR_name hosR_idCard hosR_regPrice hosR_phone hosR_sex hosR_age hosR_createTime hosR_docname

    private Context mContent;

//    public DataBaseHelper(Context context) {
//        super(context,"user",null,1);
//        this.mContent = context;
//    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContent = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.cyz.android.hospital.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cyz.android.hospital.entity.User;
import com.cyz.android.hospital.utils.DataBaseHelper;

/**
 * Created by 陈志 on 2018/11/28.
 */

public class UserDataBaseDao {
    private Context context;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;


    public UserDataBaseDao(Context context) {
        this.context = context;
        dataBaseHelper = new DataBaseHelper(context,"user",null,1);
    }
/*
* 查询
* */
    public User getResult(String u_loginName,String u_passWord) {
        database = dataBaseHelper.getWritableDatabase();
        Cursor cur = database.rawQuery("select * from user where u_loginName='"+ u_loginName +"'",null);
        cur.moveToFirst();
        User user = new User();
        user.setU_id(cur.getInt(cur.getColumnIndex("u_id")));
        user.setU_loginName(cur.getString(cur.getColumnIndex("u_loginName")));
        user.setU_passWord(cur.getString(cur.getColumnIndex("u_passWord")));
        database.close();
        if(user.getU_passWord().equals(u_passWord)){
            return user;
        }
        return null;
    }

    /**
     *修改
     */
    public User modifyContent(int id) {
        database = dataBaseHelper.getWritableDatabase();
        Cursor cur = database.rawQuery("select u_loginName,u_passWord from user where u_id='"+ id +"'",null);
        cur.moveToFirst();
        User user = new User();
        user.setU_id(cur.getInt(cur.getColumnIndex("u_id")));
        user.setU_loginName(cur.getString(cur.getColumnIndex("u_loginName")));
        user.setU_passWord(cur.getString(cur.getColumnIndex("u_passWord")));
        database.close();
        return user;
    }

    /**
     *更新
     */
    public void Update(User user) {
        database = dataBaseHelper.getWritableDatabase();
        database.execSQL("update user set u_loginName = '"+ user.getU_loginName() +
                "',u_passWord = '"+ user.getU_passWord() +
                "' where u_id = '" + user.getU_id() + "'" );
        database.close();
    }

    /**
     * 增加
     */
    public void Insert(User user) {
        database = dataBaseHelper.getWritableDatabase();
        database.execSQL("insert into user(u_loginName, u_passWord) values('"
                + user.getU_loginName() +"','"
                + user.getU_passWord() +"')" );
        database.close();
    }

    /**
     * 删除
     */
    public void Delete (int u_id) {
        database = dataBaseHelper.getWritableDatabase();
        database.execSQL("delete from user where u_id = "+ u_id +"");
        database.close();
    }
}

package com.cyz.android.hospital.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cyz.android.hospital.entity.Hosregister;
import com.cyz.android.hospital.utils.DataBaseHelper;

import java.util.ArrayList;

/**
 * Created by 陈志 on 2018/11/29.
 */

public class HosregisterDataBaseDao {
    private Context context;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;
    //构造方法
    public HosregisterDataBaseDao(Context context){
        this.context=context;
        dataBaseHelper = new DataBaseHelper(context,"hos",null,1);
    }

    /**
     * 查询所有
     */
    public ArrayList<Hosregister> getArray() {
        ArrayList<Hosregister> hosregisterList = new ArrayList<>();
        database = dataBaseHelper.getWritableDatabase();
        Cursor cur = database.rawQuery("select hosR_id, hosR_name, hosR_docname, hosR_createTime " +
                "from hosregister",null);
        cur.moveToFirst();
        while(!cur.isAfterLast()){

            Hosregister hosregister = new Hosregister();
            hosregister.setHosR_id(cur.getInt(cur.getColumnIndex("hosR_id")));
            hosregister.setHosR_name(cur.getString(cur.getColumnIndex("hosR_name")));
            hosregister.setHosR_docname(cur.getString(cur.getColumnIndex("hosR_docname")));
            hosregister.setHosR_createTime(cur.getString(cur.getColumnIndex("hosR_createTime")));
            hosregisterList.add(hosregister);
            cur.moveToNext();

        }
        database.close();
        return hosregisterList;
    }

    /**
     * 根据id查询*/
    public Hosregister selectById(int hosR_id) {
        Hosregister hosregister = null;
        database = dataBaseHelper.getWritableDatabase();
        Cursor cur = database.rawQuery("select hosR_id,hosR_name, hosR_sex, hosR_age,  " +
                "hosR_phone, hosR_idCard, hosR_docname, hosR_regPrice, hosR_createTime " +
                "from hosregister where hosR_id="+ hosR_id,null);
        cur.moveToFirst();

        hosregister = new Hosregister();
        hosregister.setHosR_id(cur.getInt(cur.getColumnIndex("hosR_id")));
        hosregister.setHosR_name(cur.getString(cur.getColumnIndex("hosR_name")));
        hosregister.setHosR_sex(cur.getInt(cur.getColumnIndex("hosR_sex")));
        hosregister.setHosR_age(cur.getInt(cur.getColumnIndex("hosR_age")));
        hosregister.setHosR_phone(cur.getString(cur.getColumnIndex("hosR_phone")));
        hosregister.setHosR_idCard(cur.getString(cur.getColumnIndex("hosR_idCard")));
        hosregister.setHosR_docname(cur.getString(cur.getColumnIndex("hosR_docname")));
        hosregister.setHosR_regPrice(cur.getDouble(cur.getColumnIndex("hosR_regPrice")));
        hosregister.setHosR_createTime(cur.getString(cur.getColumnIndex("hosR_createTime")));

        database.close();
        return hosregister;
    }

    /*
* 根据医生姓名查询
* */
    public ArrayList<Hosregister> getResult(String hosR_docname) {
        ArrayList<Hosregister> hosregisterList = new ArrayList<>();
        database = dataBaseHelper.getWritableDatabase();
        Cursor cur = database.rawQuery("select hosR_id,hosR_name, hosR_sex, hosR_age,  " +
                "hosR_phone, hosR_idCard, hosR_docname, hosR_regPrice, hosR_createTime " +
                "from hosregister where hosR_docname like '%"+ hosR_docname +"%'",null);
        cur.moveToFirst();
        while(!cur.isAfterLast()){
            Hosregister hosregister = new Hosregister();
            hosregister.setHosR_id(cur.getInt(cur.getColumnIndex("hosR_id")));
            hosregister.setHosR_name(cur.getString(cur.getColumnIndex("hosR_name")));
            hosregister.setHosR_sex(cur.getInt(cur.getColumnIndex("hosR_sex")));
            hosregister.setHosR_age(cur.getInt(cur.getColumnIndex("hosR_age")));
            hosregister.setHosR_phone(cur.getString(cur.getColumnIndex("hosR_phone")));
            hosregister.setHosR_idCard(cur.getString(cur.getColumnIndex("hosR_idCard")));
            hosregister.setHosR_docname(cur.getString(cur.getColumnIndex("hosR_docname")));
            hosregister.setHosR_regPrice(cur.getDouble(cur.getColumnIndex("hosR_regPrice")));
            hosregister.setHosR_createTime(cur.getString(cur.getColumnIndex("hosR_createTime")));
            hosregisterList.add(hosregister);
            cur.moveToNext();
        }
        database.close();
        return hosregisterList;
    }

    /**
     *修改
     */
    public Hosregister modifyContent(int hosR_id) {
        database = dataBaseHelper.getWritableDatabase();
        Cursor cur = database.rawQuery("select * from hosregister where hosR_id='"+ hosR_id +"'",null);
        cur.moveToFirst();
        Hosregister hosregister = new Hosregister();
        hosregister.setHosR_id(cur.getInt(cur.getColumnIndex("hosR_id")));
        hosregister.setHosR_name(cur.getString(cur.getColumnIndex("hosR_name")));
        hosregister.setHosR_sex(cur.getInt(cur.getColumnIndex("hosR_sex")));
        hosregister.setHosR_age(cur.getInt(cur.getColumnIndex("hosR_age")));
        hosregister.setHosR_phone(cur.getString(cur.getColumnIndex("hosR_phone")));
        hosregister.setHosR_idCard(cur.getString(cur.getColumnIndex("hosR_idCard")));
        hosregister.setHosR_docname(cur.getString(cur.getColumnIndex("hosR_docname")));
        hosregister.setHosR_regPrice(cur.getDouble(cur.getColumnIndex("hosR_regPrice")));
        hosregister.setHosR_createTime(cur.getString(cur.getColumnIndex("hosR_createTime")));
        database.close();
        return hosregister;
    }

    /**
     *更新
     */
    public void Update(Hosregister hosregister) {
        database = dataBaseHelper.getWritableDatabase();
        database.execSQL("update hosregister set hosR_name = '"+ hosregister.getHosR_name() +
                "',hosR_sex = '"+ hosregister.getHosR_sex() +
                "',hosR_age = '"+ hosregister.getHosR_age() +
                "',hosR_phone = '"+ hosregister.getHosR_phone() +
                "',hosR_idCard = '"+ hosregister.getHosR_idCard() +
                "',hosR_docname = '"+ hosregister.getHosR_docname() +
                "',hosR_regPrice = '"+ hosregister.getHosR_regPrice() +
                "',hosR_createTime = '"+ hosregister.getHosR_createTime() +
                "' where hosR_id = '" + hosregister.getHosR_id() + "'" );
        database.close();
    }

    /**
     * 增加
     */
    public void Insert(Hosregister hosregister) {
        database = dataBaseHelper.getWritableDatabase();
        database.execSQL("insert into hosregister(hosR_name, " +
                "hosR_sex,hosR_age,hosR_phone,hosR_idCard,hosR_docname," +
                "hosR_regPrice,hosR_createTime) values('"
                + hosregister.getHosR_name() +"','"
                + hosregister.getHosR_sex() +"','"
                + hosregister.getHosR_age() +"','"
                + hosregister.getHosR_phone() +"','"
                + hosregister.getHosR_idCard() +"','"
                + hosregister.getHosR_docname() +"','"
                + hosregister.getHosR_regPrice() +"','"
                + hosregister.getHosR_createTime() +"')" );
        database.close();
    }

    /**
     * 删除
     */
    public void Delete (int hosR_id) {
        database = dataBaseHelper.getWritableDatabase();
        database.execSQL("delete from hosregister where hosR_id = "+ hosR_id +"");
        database.close();
    }
}

package com.cyz.android.hospital.Dao.impl;

import android.content.Context;

import com.cyz.android.hospital.Dao.HosregisterDataBaseDao;
import com.cyz.android.hospital.entity.Hosregister;

/**
 * Created by 陈志 on 2018/12/2.
 */

public class HosregisterDaoImpl {
    private Context context;
    Hosregister hosregister = null;
    HosregisterDataBaseDao hosregisterDataBaseDao = null;

    public HosregisterDaoImpl(Context context) {
        this.context = context;
        hosregisterDataBaseDao = new HosregisterDataBaseDao(context);
    }

    /* 增加*/
    public void save(String strhosR_name, int strhosR_age, int strhosR_sex, String strhosR_phone, String strhosR_idCard, String strhosR_docname, Double strhosR_regPrice, String strhosR_createTime) {
        hosregister = new Hosregister(strhosR_name, strhosR_sex, strhosR_age, strhosR_phone, strhosR_idCard, strhosR_docname, strhosR_regPrice, strhosR_createTime);
        hosregisterDataBaseDao.Insert(hosregister);

    }

    /* 删除*/
    public void delete(int hosR_id) {
        hosregisterDataBaseDao.Delete(hosR_id);
    }

    /* 修改*/
    public void update(int hosR_id, String strhosR_name, int strhosR_age, int strhosR_sex, String strhosR_phone, String strhosR_idCard, String strhosR_docname, Double strhosR_regPrice, String strhosR_createTime) {
        hosregister = new Hosregister(hosR_id, strhosR_name, strhosR_sex, strhosR_age, strhosR_phone, strhosR_idCard, strhosR_docname, strhosR_regPrice, strhosR_createTime);
        hosregisterDataBaseDao.Update(hosregister);
    }

    /* 详情*/
    public void details(int hosR_id) {
        hosregisterDataBaseDao.selectById(hosR_id);
    }
}

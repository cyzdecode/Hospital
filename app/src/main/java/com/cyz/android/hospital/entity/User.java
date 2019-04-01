package com.cyz.android.hospital.entity;

/**
 * Created by 陈志 on 2018/11/28.
 */

public class User {
    //id
    private  int u_id;
    //登陆的用户名
    private String u_loginName;
    //密码
    private String u_passWord;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_loginName() {
        return u_loginName;
    }

    public void setU_loginName(String u_loginName) {
        this.u_loginName = u_loginName;
    }

    public String getU_passWord() {
        return u_passWord;
    }

    public void setU_passWord(String u_passWord) {
        this.u_passWord = u_passWord;
    }
}

package com.cyz.android.hospital.entity;

/**
 * Created by 陈志 on 2018/11/29.
 */

public class Hosregister {
    //挂号，主键
    private int hosR_id;
    //医生的名称
    private String hosR_docname;
    //挂号时间
    private String hosR_createTime;
    //挂号人的，名字
    private String  hosR_name;
    //病人的身份证号
    private String hosR_idCard;
    //挂号的费用
    private double hosR_regPrice;
    //联系电话
    private String hosR_phone;
    //性别
    private int hosR_sex;
    //年龄
    private int hosR_age;

    public Hosregister(){

    }

    public Hosregister(int hosR_id, String hosR_name, int hosR_sex, int hosR_age, String hosR_phone, String hosR_idCard, String hosR_docname, Double hosR_regPrice, String hosR_createTime) {
        this.hosR_id = hosR_id;
        this.hosR_name = hosR_name;
        this.hosR_sex = hosR_sex;
        this.hosR_age = hosR_age;
        this.hosR_phone = hosR_phone;
        this.hosR_idCard = hosR_idCard;
        this.hosR_docname = hosR_docname;
        this.hosR_regPrice = hosR_regPrice;
        this.hosR_createTime = hosR_createTime;
    }

    public Hosregister(String hosR_name, int hosR_sex, int hosR_age, String hosR_phone, String hosR_idCard, String hosR_docname, Double hosR_regPrice, String hosR_createTime) {
        this.hosR_name = hosR_name;
        this.hosR_sex = hosR_sex;
        this.hosR_age = hosR_age;
        this.hosR_phone = hosR_phone;
        this.hosR_idCard = hosR_idCard;
        this.hosR_docname = hosR_docname;
        this.hosR_regPrice = hosR_regPrice;
        this.hosR_createTime = hosR_createTime;
    }
    public Hosregister(int hosR_id, String hosR_name, String hosR_docname, String hosR_createTime) {
        this.hosR_id = hosR_id;
        this.hosR_name = hosR_name;
        this.hosR_docname = hosR_docname;
        this.hosR_createTime = hosR_createTime;
    }



    public int getHosR_id() {
        return hosR_id;
    }

    public void setHosR_id(int hosR_id) {
        this.hosR_id = hosR_id;
    }

    public String getHosR_docname() {
        return hosR_docname;
    }

    public void setHosR_docname(String hosR_docname) {
        this.hosR_docname = hosR_docname;
    }

    public String getHosR_createTime() {
        return hosR_createTime;
    }

    public void setHosR_createTime(String hosR_createTime) {
        this.hosR_createTime = hosR_createTime;
    }

    public String getHosR_name() {
        return hosR_name;
    }

    public void setHosR_name(String hosR_name) {
        this.hosR_name = hosR_name;
    }

    public String getHosR_idCard() {
        return hosR_idCard;
    }

    public void setHosR_idCard(String hosR_idCard) {
        this.hosR_idCard = hosR_idCard;
    }

    public double getHosR_regPrice() {
        return hosR_regPrice;
    }

    public void setHosR_regPrice(double hosR_regPrice) {
        this.hosR_regPrice = hosR_regPrice;
    }

    public String getHosR_phone() {
        return hosR_phone;
    }

    public void setHosR_phone(String hosR_phone) {
        this.hosR_phone = hosR_phone;
    }

    public int getHosR_sex() {
        return hosR_sex;
    }

    public void setHosR_sex(int hosR_sex) {
        this.hosR_sex = hosR_sex;
    }

    public int getHosR_age() {
        return hosR_age;
    }

    public void setHosR_age(int hosR_age) {
        this.hosR_age = hosR_age;
    }
}

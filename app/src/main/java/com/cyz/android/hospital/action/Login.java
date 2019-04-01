package com.cyz.android.hospital.action;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.cyz.android.hospital.Dao.UserDataBaseDao;
import com.cyz.android.hospital.R;
import com.cyz.android.hospital.entity.User;

/**
 * Created by 陈志 on 2018/11/28.
 */

public class Login extends AppCompatActivity{
    //登陆按钮
    private Button loginbt;
    //输入框
    private EditText etusername,etpassword;
    private CheckBox chk;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private UserDataBaseDao userDataBaseDao = new UserDataBaseDao(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etusername=(EditText)findViewById(R.id.user);
        etpassword=(EditText)findViewById(R.id.pwd);
        chk=(CheckBox)findViewById(R.id.cksave);
        pref=getSharedPreferences("userInfo",MODE_PRIVATE);
        editor=pref.edit();
        String username=pref.getString("name","");
        if(username==""){
            chk.setChecked(false);
        }else {
            etusername.setText(username);
            chk.setChecked(true);
        }

        User user =new User();
        user.setU_loginName("admin");
        user.setU_passWord("654321");
        userDataBaseDao.Insert(user);

        loginbt=(Button)findViewById(R.id.login);
        //给登陆按钮设置监听器
        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =etusername.getText().toString().trim();
                String pass=etpassword.getText().toString().trim();
                //查询user对象用于登陆
                User user1= userDataBaseDao.getResult(name,pass);

                if(user1 != null){
                    if(chk.isChecked()){
                        editor.putString("name",name);
                        editor.commit();
                    }else {
                        editor.remove("name");
                        editor.commit();
                    }
                    //跳转页面
                    Intent intent=new Intent(Login.this,DrawerActivity.class);
                    startActivity(intent);
                    Toast.makeText(Login.this,"登陆成功",Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    //提示登录失败
                    etpassword.setText("");
                    Toast.makeText(Login.this,"登陆失败",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}

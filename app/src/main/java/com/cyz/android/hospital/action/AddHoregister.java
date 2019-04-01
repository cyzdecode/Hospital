package com.cyz.android.hospital.action;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.cyz.android.hospital.Dao.HosregisterDataBaseDao;
import com.cyz.android.hospital.Dao.impl.HosregisterDaoImpl;
import com.cyz.android.hospital.R;
import com.cyz.android.hospital.entity.Hosregister;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 陈志 on 2018/12/2.
 */

public class AddHoregister extends AppCompatActivity {
    private EditText hosR_name;
//    private EditText hosR_sex;
    private RadioButton select_sex_boy;
    private RadioButton select_sex_girl;
    private EditText hosR_age;
    private EditText hosR_phone;
    private EditText hosR_idCard;
    private Spinner hosR_docname;
    //用于获取医生的值
    private String values;
    private EditText hosR_regPrice;
    private Hosregister hosregister;
    private HosregisterDataBaseDao hosregisterDataBaseDao;
    private Button save;
    private Button returnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horsregister_add);
        hosR_name = (EditText) findViewById(R.id.hosR_name);
        select_sex_boy = (RadioButton) findViewById(R.id.select_sex_boy);
        select_sex_girl = (RadioButton) findViewById(R.id.select_sex_girl);
//        hosR_sex = (EditText) findViewById(R.id.hosR_sex);
        hosR_age = (EditText) findViewById(R.id.hosR_age);
        hosR_phone = (EditText) findViewById(R.id.hosR_phone);
        hosR_idCard = (EditText) findViewById(R.id.hosR_idCard);
        hosR_docname = (Spinner) findViewById(R.id.hosR_docname);
        hosR_docname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //获取医生的姓名
                values = (String)hosR_docname.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        hosR_regPrice = (EditText) findViewById(R.id.hosR_regPrice);

        save = (Button) findViewById(R.id.hosregister_add_save);
        returnButton = (Button) findViewById(R.id.hosregister_add_return);
        //保存按钮的监听器
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date = new Date();
                String StrhosR_name = hosR_name.getText().toString();
                //判断年龄输入的是否为数字
                int StrhosR_age = 0;
                if(!hosR_age.getText().toString().equals("")){
                    StrhosR_age = Integer.parseInt(hosR_age.getText().toString());
                }

                //默认为女
                int StrhosR_sex = 0;
                //判断性别
                if(select_sex_boy.isChecked()){
                    StrhosR_sex=1;
                }

                String StrhosR_phone = hosR_phone.getText().toString();
                String StrhosR_idCard = hosR_idCard.getText().toString();

                String StrhosR_docname = values;
                //判断价格输入的是否为数字
                Double StrhosR_regPrice = 0.0;
                if(!hosR_regPrice.getText().toString().equals("")){
                    StrhosR_regPrice = Double.valueOf(hosR_regPrice.getText().toString());
                }

                String StrhosR_createTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
                if(!StrhosR_name.equals("") && StrhosR_age != 0 && !StrhosR_phone.equals("") && !StrhosR_idCard.equals("") && !StrhosR_docname.equals("") && !StrhosR_regPrice.equals(0.0)){
                    HosregisterDaoImpl dao=new HosregisterDaoImpl(AddHoregister.this);
                    dao.save(StrhosR_name,StrhosR_age,StrhosR_sex,StrhosR_phone,StrhosR_idCard,StrhosR_docname,StrhosR_regPrice,StrhosR_createTime);
                    Intent intent = new Intent(AddHoregister.this,DrawerActivity.class);
                    startActivity(intent);
                    AddHoregister.this.finish();
                }else {
                    Toast.makeText(AddHoregister.this,"请完整信息",Toast.LENGTH_LONG).show();
                }

            }
        });
        //返回按钮的监听器
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddHoregister.this,DrawerActivity.class));
                AddHoregister.this.finish();
            }
        });
    }
    //手机自带返回按钮的监听器
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == keyEvent.KEYCODE_BACK) {
            startActivity(new Intent(AddHoregister.this,DrawerActivity.class));
            AddHoregister.this.finish();
        }
        return false;
    }

}

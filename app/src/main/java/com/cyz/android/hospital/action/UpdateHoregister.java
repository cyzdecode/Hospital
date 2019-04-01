package com.cyz.android.hospital.action;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.cyz.android.hospital.Dao.HosregisterDataBaseDao;
import com.cyz.android.hospital.Dao.impl.HosregisterDaoImpl;
import com.cyz.android.hospital.R;
import com.cyz.android.hospital.entity.Hosregister;

/**
 * Created by 陈志 on 2018/12/2.
 */

public class UpdateHoregister extends AppCompatActivity {
    private TextView hosR_id;
    private EditText hosR_name;
//    private EditText hosR_sex;
    private RadioButton select_sex_boy;
    private RadioButton select_sex_girl;
    private EditText hosR_age;
    private EditText hosR_phone;
    private EditText hosR_idCard;
    private Spinner hosR_docname;
    //选中医生的姓名
    private String values;
    //选中医生姓名的下标
    private int where;
    private EditText hosR_regPrice;
    private TextView hosR_createTime;
    private Hosregister hosregister;
    private HosregisterDataBaseDao hosregisterDataBaseDao;
    private Button save;
    private Button returnButton;
    private int strhosR_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hosregister_update);
        hosR_id = (TextView) findViewById(R.id.hosR_id);
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
                values = (String)hosR_docname.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        hosR_regPrice = (EditText) findViewById(R.id.hosR_regPrice);
        hosR_createTime = (TextView) findViewById(R.id.hosR_creatTime);

        Intent intent = this.getIntent();
        strhosR_id = intent.getIntExtra("hosR_id",1);
        hosregisterDataBaseDao = new HosregisterDataBaseDao(this);
        hosregister = hosregisterDataBaseDao.selectById(strhosR_id);
        hosR_id.setText(String.valueOf(strhosR_id));
        hosR_name.setText(hosregister.getHosR_name());
        //判断性别
        if(hosregister.getHosR_sex()==0){
            select_sex_boy.setChecked(true);
        }else if(hosregister.getHosR_sex()==1){
            select_sex_girl.setChecked(true);
        }

        hosR_age.setText(String.valueOf(hosregister.getHosR_age()));
        hosR_phone.setText(hosregister.getHosR_phone());
        hosR_idCard.setText(hosregister.getHosR_idCard());
        //给spniner设置默认值
        SpinnerAdapter adapter = hosR_docname.getAdapter();
        int size = adapter.getCount();
        for (int i = 0; i < size; i++){
            if(TextUtils.equals(hosregister.getHosR_docname(),adapter.getItem(i).toString())){
                hosR_docname.setSelection(i,true);
                break;
            }
        }

        hosR_regPrice.setText(String.valueOf(hosregister.getHosR_regPrice()));
        hosR_createTime.setText(hosregister.getHosR_createTime());

        save = (Button) findViewById(R.id.hosregister_add_save);
        returnButton = (Button) findViewById(R.id.hosregister_add_return);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                String StrhosR_createTime = hosR_createTime.getText().toString();
                if(!StrhosR_name.equals("") && StrhosR_age != 0 && !StrhosR_phone.equals("") && !StrhosR_idCard.equals("") && !StrhosR_docname.equals("") && !StrhosR_regPrice.equals(0.0)){
                    HosregisterDaoImpl dao=new HosregisterDaoImpl(UpdateHoregister.this);
                    dao.update(strhosR_id, StrhosR_name, StrhosR_age, StrhosR_sex, StrhosR_phone, StrhosR_idCard, StrhosR_docname, StrhosR_regPrice, StrhosR_createTime);
                    Intent intent = new Intent(UpdateHoregister.this,DrawerActivity.class);
                    startActivity(intent);
                    UpdateHoregister.this.finish();
                }else {
                    Toast.makeText(UpdateHoregister.this,"请完整信息",Toast.LENGTH_LONG).show();
                }

            }
        });
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateHoregister.this,DrawerActivity.class));
                UpdateHoregister.this.finish();
            }
        });

    }
}

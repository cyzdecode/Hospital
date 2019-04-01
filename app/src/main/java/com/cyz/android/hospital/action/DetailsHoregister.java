package com.cyz.android.hospital.action;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.cyz.android.hospital.Dao.HosregisterDataBaseDao;
import com.cyz.android.hospital.R;
import com.cyz.android.hospital.entity.Hosregister;

/**
 * Created by 陈志 on 2018/12/2.
 */

public class DetailsHoregister extends AppCompatActivity {
    private TextView hosR_id;
    private TextView hosR_name;
    private TextView hosR_sex;
    private RadioButton select_sex_boy;
    private RadioButton select_sex_girl;
    private TextView hosR_age;
    private TextView hosR_phone;
    private TextView hosR_idCard;
    private TextView hosR_docname;
    private TextView hosR_regPrice;
    private TextView hosR_createTime;
    private Hosregister hosregister;
    private HosregisterDataBaseDao hosregisterDataBaseDao;
    private Button returnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hosregister_look);

        hosR_id = (TextView) findViewById(R.id.hosR_id);
        hosR_name = (TextView) findViewById(R.id.hosR_name);
//        select_sex_boy = (RadioButton) findViewById(R.id.select_sex_boy);
//        select_sex_girl = (RadioButton) findViewById(R.id.select_sex_girl);
        hosR_sex = (TextView) findViewById(R.id.hosR_sex);
        hosR_age = (TextView) findViewById(R.id.hosR_age);
        hosR_phone = (TextView) findViewById(R.id.hosR_phone);
        hosR_idCard = (TextView) findViewById(R.id.hosR_idCard);
        hosR_docname = (TextView) findViewById(R.id.hosR_docname);
        hosR_regPrice = (TextView) findViewById(R.id.hosR_regPrice);
        hosR_createTime = (TextView) findViewById(R.id.hosR_creatTime);

        returnButton = (Button) findViewById(R.id.look_return);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsHoregister.this,DrawerActivity.class);
                startActivity(intent);
                DetailsHoregister.this.finish();
            }
        });


        Intent intent = this.getIntent();
        int strhosR_id = intent.getIntExtra("hosR_id",1);
        hosregisterDataBaseDao = new HosregisterDataBaseDao(this);
        hosregister = hosregisterDataBaseDao.selectById(strhosR_id);
        hosR_id.setText(String.valueOf(strhosR_id));
        hosR_name.setText(hosregister.getHosR_name());
        if(hosregister.getHosR_sex()==0){
            hosR_sex.setText("女");
        }else if (hosregister.getHosR_sex()==1){
            hosR_sex.setText("男");
        }

        hosR_age.setText(String.valueOf(hosregister.getHosR_age()));
        hosR_phone.setText(hosregister.getHosR_phone());
        hosR_idCard.setText(hosregister.getHosR_idCard());
        hosR_docname.setText(hosregister.getHosR_docname());
        hosR_regPrice.setText(String.valueOf(hosregister.getHosR_regPrice()));
        hosR_createTime.setText(hosregister.getHosR_createTime());
    }
}

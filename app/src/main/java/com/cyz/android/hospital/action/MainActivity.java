 package com.cyz.android.hospital.action;

 import android.app.AlertDialog;
 import android.content.Context;
 import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
 import android.view.inputmethod.InputMethodManager;
 import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.cyz.android.hospital.Adapter.HosregisterAdapter;
import com.cyz.android.hospital.Dao.HosregisterDataBaseDao;
import com.cyz.android.hospital.R;
import com.cyz.android.hospital.entity.Hosregister;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {
     private RecyclerView recyclerView;
     private ArrayList<Hosregister> hosregisterList;
     //搜索按钮
     private Button search_button;
     //清空按钮
     private Button clear_button;
     //搜索框
     private EditText search_textView;
     private ImageView add;
     private HosregisterDataBaseDao hosregisterDataBaseDao;
     private HosregisterAdapter hosregisterAdapter;
     private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化dao层对象
        hosregisterDataBaseDao = new HosregisterDataBaseDao(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.hospital_toolbar);

        search_textView = (EditText) findViewById(R.id.search_textView);
        search_button = (Button) findViewById(R.id.search_button);
        //给搜索按钮设置监听器
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!search_textView.getText().toString().equals("")){
                    hosregisterList.clear();
                    hosregisterList = hosregisterDataBaseDao.getResult(search_textView.getText().toString());
                    recyclerView = (RecyclerView) findViewById(R.id.hosregister_recycler);
                    linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    hosregisterAdapter = new HosregisterAdapter(hosregisterList,MainActivity.this);
                    recyclerView.setAdapter(hosregisterAdapter);
                }else {
                    hosregisterList = hosregisterDataBaseDao.getArray();
                    recyclerView = (RecyclerView) findViewById(R.id.hosregister_recycler);
                    linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    hosregisterAdapter = new HosregisterAdapter(hosregisterList,MainActivity.this);
                    recyclerView.setAdapter(hosregisterAdapter);
                }
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(search_textView.getWindowToken(),0);
            }
        });
        clear_button = (Button) findViewById(R.id.clear_button);
        //给清空按钮设置监听器
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_textView.setText("");
            }
        });

        add = (ImageView) findViewById(R.id.add) ;
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddHoregister.class));
                MainActivity.this.finish();
            }
        });

        hosregisterList = hosregisterDataBaseDao.getArray();
        recyclerView = (RecyclerView) findViewById(R.id.hosregister_recycler);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        hosregisterAdapter = new HosregisterAdapter(hosregisterList,this);
        recyclerView.setAdapter(hosregisterAdapter);


//        hosregisterAdapter.notifyDataSetChanged();
    }


     public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
         if (keyCode == keyEvent.KEYCODE_BACK) {
             new AlertDialog.Builder(MainActivity.this)
                     .setTitle("退出")
                     .setMessage("确定退出登录？")
                     .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             startActivity(new Intent(MainActivity.this,Login.class));
                             MainActivity.this.finish();
                         }
                     })
                     .setNegativeButton("取消",null).show();
         }
         return false;
     }
}

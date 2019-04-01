package com.cyz.android.hospital.action;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.cyz.android.hospital.Adapter.HosregisterAdapter;
import com.cyz.android.hospital.Dao.HosregisterDataBaseDao;
import com.cyz.android.hospital.R;
import com.cyz.android.hospital.entity.Hosregister;

import java.util.ArrayList;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
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
        setContentView(R.layout.activity_drawer);

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
                    linearLayoutManager = new LinearLayoutManager(DrawerActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    hosregisterAdapter = new HosregisterAdapter(hosregisterList,DrawerActivity.this);
                    recyclerView.setAdapter(hosregisterAdapter);
                }else {
                    hosregisterList = hosregisterDataBaseDao.getArray();
                    recyclerView = (RecyclerView) findViewById(R.id.hosregister_recycler);
                    linearLayoutManager = new LinearLayoutManager(DrawerActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    hosregisterAdapter = new HosregisterAdapter(hosregisterList,DrawerActivity.this);
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
                startActivity(new Intent(DrawerActivity.this,AddHoregister.class));
                DrawerActivity.this.finish();
            }
        });

        hosregisterList = hosregisterDataBaseDao.getArray();
        recyclerView = (RecyclerView) findViewById(R.id.hosregister_recycler);
        linearLayoutManager = new LinearLayoutManager(DrawerActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        hosregisterAdapter = new HosregisterAdapter(hosregisterList,this);
        recyclerView.setAdapter(hosregisterAdapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.hosR1) {
            // Handle the camera action
        } else if (id == R.id.hosR2) {
            Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.hosR3) {
            Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.hosR4) {
            Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.hosR5) {
            Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.hosR6) {
            Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.hosR7) {
            Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.hosR8) {
            Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.hosR9) {
            Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.hosR10) {
            Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.hosR11) {
            Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.hosR12) {
            Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == keyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(DrawerActivity.this)
                    .setTitle("退出")
                    .setMessage("确定退出登录？")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(DrawerActivity.this,Login.class));
                            DrawerActivity.this.finish();
                        }
                    })
                    .setNegativeButton("取消",null).show();
        }
        return false;
    }
}

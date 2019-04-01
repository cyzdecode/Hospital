package com.cyz.android.hospital.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cyz.android.hospital.Dao.impl.HosregisterDaoImpl;
import com.cyz.android.hospital.R;
import com.cyz.android.hospital.action.DetailsHoregister;
import com.cyz.android.hospital.action.DrawerActivity;
import com.cyz.android.hospital.action.UpdateHoregister;
import com.cyz.android.hospital.entity.Hosregister;

import java.util.ArrayList;

/**
 * Created by 陈志 on 2018/12/2.
 */

public class HosregisterAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Hosregister> hosregisterList;
    private HosregisterDaoImpl hosregiterDao;
    private Context context;

    public HosregisterAdapter(ArrayList<Hosregister> hosregisterList,Context context) {
        this.context = context;
        this.hosregisterList = hosregisterList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospital_card_view,parent,false);
        return new HosregisterHolder(view) ;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        HosregisterHolder hosregisterHolder = (HosregisterHolder) holder;
        final Hosregister hosregister = hosregisterList.get(position);
        hosregisterHolder.hosR_id.setText(hosregister.getHosR_id()+"");
        hosregisterHolder.hosR_name.setText(hosregister.getHosR_name());
        hosregisterHolder.hosR_docname.setText(hosregister.getHosR_docname());
        hosregisterHolder.hosR_creatTime.setText(hosregister.getHosR_createTime());

        hosregisterHolder.look_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailsHoregister.class);
                intent.putExtra("hosR_id",hosregister.getHosR_id());
                context.startActivity(intent);
            }
        });
        hosregisterHolder.update_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,UpdateHoregister.class);
                intent.putExtra("hosR_id",hosregister.getHosR_id());
                context.startActivity(intent);
            }
        });
        hosregisterHolder.delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("删除")
                        .setMessage("确定删除？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(context,DrawerActivity.class);
                                intent.putExtra("hosR_id",hosregister.getHosR_id());
                                int strhosR_id = intent.getIntExtra("hosR_id",0);
                                hosregiterDao = new HosregisterDaoImpl(context);
                                hosregiterDao.delete(strhosR_id);
//                notifyDataSetChanged();
                                context.startActivity(intent);
                            }
                        })
                        .setNegativeButton("取消",null).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return hosregisterList.size();
    }

    public class HosregisterHolder extends RecyclerView.ViewHolder {
        private TextView hosR_id;
        private TextView hosR_docname;
        private TextView hosR_name;
        private TextView hosR_creatTime;
        private Button look_button;
        private Button update_button;
        private Button delete_button;

        public HosregisterHolder(View itemView) {
            super(itemView);
            hosR_id = (TextView) itemView.findViewById(R.id.hosR_id);
            hosR_docname = (TextView) itemView.findViewById(R.id.hosR_docname);
            hosR_name = (TextView) itemView.findViewById(R.id.hosR_name);
            hosR_creatTime = (TextView) itemView.findViewById(R.id.hosR_creatTime);
            look_button = itemView.findViewById(R.id.look_button);
            update_button = itemView.findViewById(R.id.update_button);
            delete_button = itemView.findViewById(R.id.delete_button);

        }
    }
}

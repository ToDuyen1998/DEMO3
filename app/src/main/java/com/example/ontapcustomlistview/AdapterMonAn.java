package com.example.ontapcustomlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterMonAn extends BaseAdapter {
    private Context context;//màn hình
    private int layout;//chọn giao diện
    List<MonAn> monAnList;//thông tin

    public AdapterMonAn(Context context, int layout, List<MonAn> monAnList) {
        this.context = context;
        this.layout = layout;
        this.monAnList = monAnList;
    }

    @Override
    public int getCount() {
        return monAnList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);//truyeenf man hinh
        convertView = inflater.inflate(layout,null);//truyen layout

        TextView txtTen = convertView.findViewById(R.id.textViewTen);
        TextView txtGia = convertView.findViewById(R.id.textViewGia);
        CheckBox cbMua = convertView.findViewById(R.id.checkboxMua);
        ImageView imgHinh = convertView.findViewById(R.id.imageHinh);

        final MonAn monAn = monAnList.get(position);

        txtTen.setText(monAn.getTen());
        txtGia.setText(String.valueOf(monAn.getGia()));
        cbMua.setChecked(monAn.isCheck());
        imgHinh.setImageResource(monAn.getHinh());

        cbMua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    monAn.setCheck(true);
                }else{
                    monAn.setCheck(false);
                }
            }
        });

        return convertView;
    }
}

package com.example.duanmau.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.duanmau.R;
import com.example.duanmau.dao.LoaiSachDAO;
import com.example.duanmau.dto.LoaiSachDTO;

import java.util.List;

public class LoaiSachAdapter extends BaseAdapter {
    private Context context;
    private List<LoaiSachDTO> list;

    LoaiSachDTO loaiSachDTO;
    LoaiSachDAO loaiSachDAO;

    public LoaiSachAdapter(Context context, List<LoaiSachDTO> list) {
        this.context = context;
        this.list = list;
        loaiSachDAO = new LoaiSachDAO(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View v=inflater.inflate(R.layout.dong_loai_sach,null);
//        loaiSachDTO=list.get(i);
//        TextView tvidls=v.findViewById(R.id.tvls);
//        TextView tvtenloai=v.findViewById(R.id.tvtenloai);
//        ImageView imgxoa=v.findViewById(R.id.imgxoals);
//
//        tvidls.setText("Mã Loại: "+list.get(i).getMaLoai());
//        tvtenloai.setText("Tên loại Sách: "+list.get(i).getTenLoai());
//
//        imgxoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                xoa();
//            }
//        });
        return convertView;
    }
}

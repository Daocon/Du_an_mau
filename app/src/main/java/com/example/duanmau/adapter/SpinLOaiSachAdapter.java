package com.example.duanmau.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.duanmau.R;
import com.example.duanmau.dao.LoaiSachDAO;
import com.example.duanmau.dto.LoaiSachDTO;
import com.example.duanmau.dto.SpinSachDTO;

import java.util.ArrayList;
import java.util.List;

public class SpinLOaiSachAdapter extends ArrayAdapter<LoaiSachDTO> {
    Context context;
    ArrayList<LoaiSachDTO> list;

    public SpinLOaiSachAdapter(@NonNull Context context, ArrayList<LoaiSachDTO> list) {
        super(context, 0,list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_spin_sach, null);
        }
        final LoaiSachDTO loaiSachDTO = list.get(position);
        if (loaiSachDTO!= null){
            LoaiSachDAO loaiSachDAO = new LoaiSachDAO(context);
        }


        return v;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }
}

package com.example.duanmau;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.R;
import com.example.duanmau.adapter.Top10Adapter;
import com.example.duanmau.dao.ThongKeDAO;
import com.example.duanmau.dto.SachDTO;

import java.util.ArrayList;

public class Sach_Muon_Nhieu_Nhat_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sach__muon__nhieu__nhat,container,false);

        RecyclerView rycTop10 = view.findViewById(R.id.rycTop10);

        ThongKeDAO thongKeDAO = new ThongKeDAO(getContext());
        ArrayList<SachDTO> list = thongKeDAO.getTop10();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rycTop10.setLayoutManager(linearLayoutManager);
        Top10Adapter adapter = new Top10Adapter(getContext(), list);
        rycTop10.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
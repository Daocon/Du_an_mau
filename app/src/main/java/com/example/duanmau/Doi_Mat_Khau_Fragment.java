package com.example.duanmau;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duanmau.R;
import com.example.duanmau.dao.ThuThuDAO;
import com.example.duanmau.databinding.ActivityManHinhLoginBinding;
import com.example.duanmau.databinding.FragmentDoiMatKhauBinding;

public class Doi_Mat_Khau_Fragment extends Fragment {
    private FragmentDoiMatKhauBinding binding;
    private ThuThuDAO thuThuDAO;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDoiMatKhauBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        thuThuDAO = new ThuThuDAO(getActivity());
        binding.btnRelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
package com.example.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duanmau.dao.ThuThuDAO;
import com.example.duanmau.databinding.ActivityManHinhLoginBinding;
import com.example.duanmau.dto.ThuThuDTO;
import com.example.duanmau.preference.UserPreferences;

public class Man_Hinh_Login extends AppCompatActivity {
    private ActivityManHinhLoginBinding binding;
    private ThuThuDTO thuThuDTO;
    private ThuThuDAO thuThuDAO;
    private UserPreferences userPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityManHinhLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);


        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.edtUsername.getText().toString().trim();
                String password = binding.edtPassword.getText().toString().trim();

                thuThuDAO = new ThuThuDAO(Man_Hinh_Login.this);

                if (thuThuDAO.checklogin(username,password)){
                    SharedPreferences sharedPreferences = getSharedPreferences("THONGTIN",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("MaTT", username);
                    editor.commit();

                    startActivity(new Intent(Man_Hinh_Login.this,MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(Man_Hinh_Login.this, "Username và password ko đúng!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
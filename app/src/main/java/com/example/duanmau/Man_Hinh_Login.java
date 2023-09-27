package com.example.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        //check if user is logged in
        userPreferences = new UserPreferences(this);
        if (userPreferences.isLogin()){
            startActivity(new Intent(Man_Hinh_Login.this,MainActivity.class));
            finish();
            return;
        }

        setContentView(view);


        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.edtUsername.getText().toString().trim();
                String password = binding.edtPassword.getText().toString().trim();

                if (username.isEmpty()){
                    binding.edtUsername.setError("Nhập username!");
                    return;
                }
                thuThuDAO = new ThuThuDAO(Man_Hinh_Login.this);
                thuThuDTO = thuThuDAO.getThuThuByID(username);
                if (!username.equals(thuThuDTO.getMaTT())){
                    binding.edtUsername.setError("Nhập sai username!");
                    return;
                }
                if (password.isEmpty()){
                    binding.edtPassword.setError("Nhập password");
                    return;
                }
                Toast.makeText(Man_Hinh_Login.this, thuThuDTO.getMatKhau(), Toast.LENGTH_SHORT).show();
                if (!password.equals(thuThuDTO.getMatKhau())){
                    binding.edtPassword.setError("Nhập sai password!");
                    return;
                }

                //set login status
                if (binding.chkSavePassword.isChecked()){
                    userPreferences.setLogin(true);
                    userPreferences.setIdUser(username);

                }

                startActivity(new Intent(Man_Hinh_Login.this,MainActivity.class));
                finish();
            }
        });
    }
}
package com.example.duanmau;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navi);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, 0, 0);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.hihi) {
            replaceFragment(new Quan_Ly_Phieu_Muon_Fragment());
            drawerLayout.close();
        } else if (id == R.id.type_book) {
            replaceFragment(new Quan_Ly_Loai_Sach_Fragment());
            drawerLayout.close();
        } else if (id == R.id.manage_book) {
            replaceFragment(new Quan_Ly_Sach_Fragment());
            drawerLayout.close();
        } else if (id == R.id.manage_user) {
            replaceFragment(new Quan_Ly_Thanh_Vien_Fragment());
            drawerLayout.close();
        } else if (id == R.id.bestbook) {
            replaceFragment(new Sach_Muon_Nhieu_Nhat_Fragment());
            drawerLayout.close();
        } else if (id == R.id.total) {
            replaceFragment(new Doanh_Thu_Fragment());
            drawerLayout.close();
        } else if (id == R.id.add_user) {
            replaceFragment(new Them_Thanh_Vien_Fragment());
            drawerLayout.close();
        } else if (id == R.id.change_password) {
            replaceFragment(new Doi_Mat_Khau_Fragment());
            drawerLayout.close();
        } else if (id == R.id.log_out) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setMessage("Bạn có muốn đăng xuất hay không");
            alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.super.onBackPressed();
                }
            });
            alertDialog.show();
        }

        return true;
    }

    private void replaceFragment(Fragment Fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout_content,Fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isOpen()) {
            drawerLayout.close();
        } else {
            super.onBackPressed();
        }
    }
}
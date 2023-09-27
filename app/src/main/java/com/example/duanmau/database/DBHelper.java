package com.example.duanmau.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "PHUONGNAMLIBRARY", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String bangthanhvien = "CREATE TABLE thanhvien(" +
                "MaTV integer primary key ," +
                "tenTV text NOT NULL," +
                "namSinh text NOT NULL)";
        db.execSQL(bangthanhvien);

        String bangloaisach = "CREATE TABLE loaisach(" +
                "MaLS integer primary key," +
                "TenLS text NOT NULL)";
        db.execSQL(bangloaisach);

        String bangsach = "CREATE TABLE sach(" +
                "MaS integer primary key," +
                "TenS text UNIQUE NOT NULL," +
                "GiathueS integer NOT NULL," +
                "MaLS integer NOT NULL REFERENCES loaisach(MaLS))";
        db.execSQL(bangsach);

        String bangthuthu = "CREATE TABLE thuthu(" +
                "MaTT text primary key," +
                "TenTT text NOT NULL ," +
                "MatKhau text NOT NULL ," +
                "role text NOT NULL)";
        db.execSQL(bangthuthu);

        String bangphieumuon = "CREATE TABLE phieumuon(" +
                "MaPM integer primary key," +
                "MaTV integer NOT NULL REFERENCES thanhvien(MaTV)," +
                "MaS integer NOT NULL REFERENCES sach(MaS)," +
                "MaTT text NOT NULL REFERENCES thuthu(MaTT)," +
                "ngay date NOT NULL ,"+
                "traSach integer NOT NULL ,"+
                "GiathueS integer NOT NULL REFERENCES sach(GiathueS)  )";
        db.execSQL(bangphieumuon);

        String inseachAdmin = "INSERT INTO thuthu VALUES ('admin','hadao','hadao','admin')";
        db.execSQL(inseachAdmin);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.example.duanmau.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.database.DBHelper;
import com.example.duanmau.dto.LoaiSachDTO;
import com.example.duanmau.dto.SachDTO;

import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    private DBHelper dbHelper;

    public SachDAO(Context context){
        dbHelper = new DBHelper(context);
    }

    public ArrayList<SachDTO> getAllSachToString(){
        ArrayList<SachDTO> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM sach", null);
        if (c.getCount() !=0){
            c.moveToFirst();
            do {
                list.add(new SachDTO(c.getInt(0),c.getString(1),c.getInt(2),c.getInt(3)));

            } while (c.moveToNext());
        }
        return list;
    }
}

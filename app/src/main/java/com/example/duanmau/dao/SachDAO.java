package com.example.duanmau.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.database.DBHelper;
import com.example.duanmau.dto.SachDTO;

import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    DBHelper dbHelper;
    SQLiteDatabase db;
    public SachDAO(Context context){
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public long insertSach(SachDTO obj){
        ContentValues contentValues = new ContentValues();
        contentValues.put("TenSach",obj.getTenSach());
        contentValues.put("GiaThue",obj.getGiaThue());
        contentValues.put("MaLoai",obj.getMaLoai());

        return db.insert("sach",null ,contentValues);
    }

    public int updateSach(SachDTO obj){
        ContentValues contentValues = new ContentValues();
        contentValues.put("TenSach",obj.getTenSach());
        contentValues.put("GiaThue",obj.getGiaThue());
        contentValues.put("MaLoai",obj.getMaLoai());

        String[] dk = new String[]{String.valueOf(obj.getMaSach())};
        return db.update("sach", contentValues,"MaS=?",dk);
    }

    public int deleteSach(SachDTO obj){
        String[] dk = new String[]{String.valueOf(obj.getMaSach())};
        return db.delete("sach","MaS=?",dk);
    }

    public List<SachDTO> getAll(){
        String sql="Select * From sach  ";
        return getdata(sql);
    }

    public  SachDTO getheoId(String id){
        String sql="Select * From sach where MaS=?";
        List<SachDTO> list= getdata(sql,id);
        return  list.get(0);
    }

    public List<SachDTO> getdata(String sql,String...dieukien){
        List<SachDTO>list = new ArrayList<>();
        Cursor c=db.rawQuery(sql,dieukien);
        if (c!=null&&c.getCount()>0){
            c.moveToFirst();
            do {
                list.add(new SachDTO(c.getInt(0),c.getString(1),c.getInt(2),c.getInt(3)));
            }while (c.moveToNext());
        }

        return list;
    }
}

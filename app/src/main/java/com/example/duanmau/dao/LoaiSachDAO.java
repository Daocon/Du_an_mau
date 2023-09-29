package com.example.duanmau.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.database.DBHelper;
import com.example.duanmau.dto.LoaiSachDTO;

import java.util.ArrayList;
import java.util.List;

public class LoaiSachDAO {
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private Context context;

    public LoaiSachDAO(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public int InsertLoaiSach(LoaiSachDTO obj){
        ContentValues values = new ContentValues();
        values.put("MaLS",obj.getMaLoai());
        values.put("TenLS",obj.getHoTen());
        long kq = db.insert("loaisach", null, values);
        if (kq <= 0){
            return -1;
        } else {
            return 1;
        }
    }
    public int UpdateLoaiSach(LoaiSachDTO obj){
        ContentValues values = new ContentValues();
        values.put("MaLS",obj.getMaLoai());
        values.put("TenLS",obj.getHoTen());
        String[] dk = new String[]{String.valueOf(obj.getMaLoai())};
        return db.update("loaisach", values, "MaLS=?", dk);
    }
    public int deleteLoaiSach(LoaiSachDTO obj) {
        String[] dk = new String[]{String.valueOf(obj.getMaLoai())};
        return db.delete("loaisach", "MaLS=?", dk);
    }
    public List<LoaiSachDTO> getAllLoaiSachToString(){
        List<LoaiSachDTO> ls = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM loaisach", null);
        if (c != null && c.getCount()>0){
            c.moveToFirst();
            while (!c.isAfterLast()){
                int id_ls = c.getInt(0);
                String ten_ls = c.getString(1);

                LoaiSachDTO loaiSachDTO = new LoaiSachDTO(id_ls,ten_ls);
                ls.add(loaiSachDTO);
                c.moveToNext();
            }
        }
        return ls;
    }











//    DBHelper dbhepler;
//    SQLiteDatabase db;
//
//    public LoaiSachDAO(Context context) {
//        dbhepler = new DBHelper(context);
//        db = dbhepler.getWritableDatabase();
//    }
//
//
//    public long insertLoaiS(LoaiSachDTO obj) {
//        ContentValues values = new ContentValues();
//        values.put("TenLoaiSach", obj.getHoTen());
//        return db.insert("loaisach", null, values);
//
//
//    }
//
//    public int updateLoaiS(LoaiSachDTO obj) {
//        ContentValues values = new ContentValues();
//        values.put("TenLoaiSach", obj.getHoTen());
//        String[] dk = new String[]{String.valueOf(obj.getMaLoai())};
//        return db.update("loaisach", values, "MaLS=?", dk);
//    }
//
//    public int deleteLoaiS(LoaiSachDTO obj) {
//        String[] dk = new String[]{String.valueOf(obj.getMaLoai())};
//        return db.delete("loaisach", "MaLS=?", dk);
//    }
//
//    public List<LoaiSachDTO> getAll() {
//        String sql = "Select * From LoaiSach";
//        return getdata(sql);
//    }
//
//    public LoaiSachDTO getheoId(String id) {
//        String sql = "Select * From loaisach where MaLS=?";
//        List<LoaiSachDTO> list = getdata(sql, id);
//        return list.get(0);
//    }
//
//    public List<LoaiSachDTO> getdata(String sql, String... dieukien) {
//        List<LoaiSachDTO> list = new ArrayList<>();
//        Cursor c = db.rawQuery(sql, dieukien);
//        if (c != null && c.getCount() > 0) {
//            c.moveToFirst();
//            do {
//                list.add(new LoaiSachDTO(c.getInt(0), c.getString(1)));
//            } while (c.moveToNext());
//        }
//
//        return list;
//    }
//
//    //get tên bằng id
//    public String getTenLoaiSach(int id) {
//        String tenLoaiSach = "";
//        String sql = "SELECT TenLS FROM loaisach WHERE MaLS = '" + id + "'";
//        Cursor c = db.rawQuery(sql, null);
//        if (c != null && c.getCount() > 0) {
//            c.moveToFirst();
//            tenLoaiSach = c.getString(0);
//        }
//        return tenLoaiSach;
//    }
}

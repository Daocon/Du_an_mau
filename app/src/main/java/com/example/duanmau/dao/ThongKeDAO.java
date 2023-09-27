package com.example.duanmau.dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duanmau.database.DBHelper;
import com.example.duanmau.dto.SachDTO;
import com.example.duanmau.dto.Top10DTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class ThongKeDAO {
    private SQLiteDatabase db;
    private Context context;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public ThongKeDAO(Context context){
        this.context = context;
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<Top10DTO> getTop(){
        List<Top10DTO> list = new ArrayList<>();
        String sql = "SELECT MaS,COUNT(MaS) AS soLuong FROM phieumuon GROUP BY MaS ORDER BY soLuong DESC LIMIT 10";
        SachDAO sachDAO = new SachDAO(context);
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor!=null&&cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                Top10DTO top=new Top10DTO();
                SachDTO sach= (SachDTO) sachDAO.getheoId(cursor.getString(cursor.getColumnIndex("MaS")));
                top.tenSach=sach.getTenSach();
                top.soLuong= Integer.parseInt(cursor.getString(cursor.getColumnIndex("soluong")));
                list.add(top);
            }while (cursor.moveToNext());
        }else{
            Log.d("zzzzzzz", "getTop: k nhan dc gia tri");
        }
        return list;
    }
    //thong ke doanh thu
    @SuppressLint("Range")
    public  int getDoanhthu(String tuNgay, String denNgay){
        String sqlDoanhThu="SELECT SUM(GiathueS) as doanhthu FROM phieumuon Where ngay BETWEEN ? AND ? ";
        List<Integer>list=new ArrayList<>();
        Cursor c=db.rawQuery(sqlDoanhThu,new String[]{tuNgay,denNgay});
        while (c.moveToNext()){
            try {
                list.add(Integer.valueOf(c.getString(c.getColumnIndex("doanhthu"))));
            }catch (Exception e){
                list.add(0);
            }
        }
        return list.get(0);
    }
}

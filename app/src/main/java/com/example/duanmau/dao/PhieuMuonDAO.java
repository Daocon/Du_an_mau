package com.example.duanmau.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.database.DBHelper;
import com.example.duanmau.dto.PhieuMuonDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhieuMuonDAO {
    DBHelper dbHelper;
    SQLiteDatabase db;
    public PhieuMuonDAO(Context context){
        dbHelper=new DBHelper(context);
        db=dbHelper.getWritableDatabase();
    }


    public  long insertPhieuMuon(PhieuMuonDTO obj){
        ContentValues values=new ContentValues();
        values.put("MaTV",obj.getMaTV());
        values.put("MaS",obj.getMaSach());
        values.put("MaTT",obj.getMaTT());
        values.put("ngay",String.valueOf(obj.getNgay()));
        values.put("traSach",obj.getTraSach());
        values.put("GiaThueS",obj.getTienThue());
        return db.insert("PhieuMuon",null,values);


    }
    public  int updatePhieuMuon(PhieuMuonDTO obj){
        ContentValues values=new ContentValues();
        values.put("MaTV",obj.getMaTV());
        values.put("MaS",obj.getMaSach());
        values.put("MaTT",obj.getMaTT());
        values.put("ngay",String.valueOf(obj.getNgay()));
        values.put("traSach",obj.getTraSach());
        values.put("GiaThueS",obj.getTienThue());
        String[]dk=new String[]{String.valueOf(obj.getMaPM())};
        return db.update("phieumuon",values,"MaPM=?",dk);
    }
    public  int deletePhieuMuon(PhieuMuonDTO obj){
        String[]dk=new String[]{String.valueOf(obj.getMaPM())};
        return db.delete("phieumuon","MaPM=?",dk);

    }

    public List<PhieuMuonDTO> getAll(){
        String sql="Select * From phieuMuon";
        return getdata(sql);
    }

    public  PhieuMuonDTO getheoId(String id){
        String sql="Select * From thuthu where MaPM=?";
        List<PhieuMuonDTO> list= getdata(sql,id);

        return list.get(0);
    }

    private List<PhieuMuonDTO>getdata(String sql, String...dieukien){
        List<PhieuMuonDTO>list = new ArrayList<>();
        Cursor c=db.rawQuery(sql,dieukien);

        if (c!=null&&c.getCount()>0){
            c.moveToFirst();
            do {
                long datemili =c.getLong(5);
                Date date =new Date(datemili);//int maPM, String maTT, int maTV, int maSach, String ngay, int traSach, int tienThue
                list.add(new PhieuMuonDTO(c.getInt(0),c.getString(1),c.getInt(2),c.getInt(3),date,c.getInt(5),c.getInt(6)));
            }while (c.moveToNext());
        }
        return list;
    }
}

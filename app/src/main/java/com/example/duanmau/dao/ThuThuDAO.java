package com.example.duanmau.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.duanmau.database.DBHelper;
import com.example.duanmau.dto.ThuThuDTO;

import java.util.ArrayList;
import java.util.List;

public class ThuThuDAO {
    private DBHelper dbHelper;
    SQLiteDatabase db;

    public ThuThuDAO(Context context) {
        this.dbHelper = new DBHelper(context);
    }
    public ThuThuDTO getThuThuByID(String id) {
        SQLiteDatabase sqLiteOpenHelper = dbHelper.getReadableDatabase();
        String Sql = "Select * FROM thuthu WHERE MaTT = ? ";
        Cursor cursor = sqLiteOpenHelper.rawQuery(Sql,new String[]{id});
        ThuThuDTO thuThuDTO = new ThuThuDTO();
        if (cursor != null){
            while (cursor.moveToNext()){
                thuThuDTO.setMaTT(cursor.getString(0));
                thuThuDTO.setHoTen(cursor.getString(1));
                thuThuDTO.setMatKhau(cursor.getString(2));
                thuThuDTO.setRole(cursor.getString(3));
            }
            cursor.close();
        }
        return thuThuDTO;
    }
    public  long insertTT(ThuThuDTO thuThuDTO){
        ContentValues values=new ContentValues();
        values.put("MaTT",thuThuDTO.getMaTT());
        values.put("TenThuThu",thuThuDTO.getHoTen());
        values.put("MatKhau",thuThuDTO.getMatKhau());
        values.put("role",thuThuDTO.getRole());
        return db.insert("thuthu",null,values);


    }
    public  int updateTT(ThuThuDTO thuThuDTO){
        ContentValues values=new ContentValues();
        values.put("TenThuThu",thuThuDTO.getHoTen());
        values.put("MatKhau",thuThuDTO.getMatKhau());
        String[]dk=new String[]{thuThuDTO.getMaTT()};
        values.put("role",thuThuDTO.getRole());
        return db.update("thuthu",values,"MaTT=?",dk);
    }
    public  int DeleteTV(ThuThuDTO thuThuDTO){
        String[]dk=new String[]{thuThuDTO.getMaTT()};
        return db.delete("thuthu","MaTT=?",dk);

    }

    public List<ThuThuDTO> getAll(){
        String sql="SELECT * From Thuthu";
        return getdata(sql);
    }

    public   ThuThuDTO getheoId(String id){
        String sql="SELECT * From thuthu where MaTT=?";
        List<ThuThuDTO> list= getdata(sql,id);

        return list.get(0);
    }

    private List<ThuThuDTO>getdata(String sql, String...dieukien){
        List<ThuThuDTO>list = new ArrayList<>();
        Cursor c=db.rawQuery(sql,dieukien);
        if (c!=null&&c.getCount()>0){
            c.moveToFirst();
            do {
                list.add(new ThuThuDTO(c.getString(0),c.getString(1),c.getString(2),c.getString(3)));
            }while (c.moveToNext());
        }

        return list;
    }
    public  int checklogin(String id,String password){
        String sql="SELECT * FROM thuthu WHERE MaTT=? and MatKhau=?";
        List<ThuThuDTO>list=getdata(sql,id,password);
        if (list.size()==0) {
            return -1;
        }
        return 1;


    }

}

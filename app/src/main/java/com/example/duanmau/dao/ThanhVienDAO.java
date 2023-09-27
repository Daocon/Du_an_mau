package com.example.duanmau.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.database.DBHelper;
import com.example.duanmau.dto.ThanhVienDTO;
import com.example.duanmau.dto.ThuThuDTO;

import java.util.ArrayList;
import java.util.List;

public class ThanhVienDAO {
    private SQLiteDatabase db;
    DBHelper dbHelper;

    public ThanhVienDAO(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insertTV(ThanhVienDTO thanhVienDTO) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("hoTen", thanhVienDTO.getHoTen());
        contentValues.put("namSinh", thanhVienDTO.getNamSinh());

        return db.insert("thanhvien", null, contentValues);
    }

    public int update(ThanhVienDTO thanhVienDTO) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("hoTen", thanhVienDTO.getHoTen());
        contentValues.put("namSinh", thanhVienDTO.getNamSinh());

        return db.update("thanhvien", contentValues, "MaTV=?",
                new String[]{String.valueOf(thanhVienDTO.getMaTV())});
    }

    public int delete(ThanhVienDTO thanhVienDTO) {
        String[] dk = new String[]{String.valueOf(thanhVienDTO.getMaTV())};
        return db.delete("thanhvien", "MaTV=?", dk);
    }

    public List<ThanhVienDTO> getAll() {
        String sql = "SELECT * FROM thanhvien";
        return getData(sql);
    }

    public ThanhVienDTO getID(String id) {
        String sql = "SELECT * FROM thanhvien WHERE MaTV=?";
        List<ThanhVienDTO> list = getData(sql, id);
        return list.get(0);
    }

    private List<ThanhVienDTO> getData(String sql, String... selectionArgs) {
        List<ThanhVienDTO> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add(new ThanhVienDTO(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        return list;
    }
}

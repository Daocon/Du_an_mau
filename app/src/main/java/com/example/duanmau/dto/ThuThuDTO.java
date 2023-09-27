package com.example.duanmau.dto;

public class ThuThuDTO {
    private String maTT;
    private String hoTen;
    private String matKhau;
    private String role;

    public ThuThuDTO() {
    }

    public ThuThuDTO(String maTT, String hoTen, String matKhau, String role) {
        this.maTT = maTT;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.role = role;
    }

    public String getMaTT() {
        return maTT;
    }

    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

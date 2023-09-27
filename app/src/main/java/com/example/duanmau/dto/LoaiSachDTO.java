package com.example.duanmau.dto;

public class LoaiSachDTO {
    private int maLoai;
    private String hoTen;

    public LoaiSachDTO() {
    }

    public LoaiSachDTO(Integer maLoai, String hoTen) {
        this.maLoai = maLoai;
        this.hoTen = hoTen;
    }

    public Integer getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Integer maLoai) {
        this.maLoai = maLoai;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
}

package com.example.ontapcustomlistview;

import java.io.Serializable;

public class MonAn implements Serializable {
    private String ten;
    private int gia;
    private int hinh;
    private boolean check;

    public MonAn(String ten, int gia, int hinh, boolean check) {
        this.ten = ten;
        this.gia = gia;
        this.hinh = hinh;
        this.check = check;
    }

    public MonAn(String ten, int gia) {
        this.ten = ten;
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}

package com.example.basicj2ee;

public class LoaiDiem {
    private String maLoaiDiem;
    private String tenLoaiDiem;
    private double tiLe;

    public LoaiDiem() {
    }

    public LoaiDiem(String maLoaiDiem, String tenLoaiDiem, double tiLe) {
        this.maLoaiDiem = maLoaiDiem;
        this.tenLoaiDiem = tenLoaiDiem;
        this.tiLe = tiLe;
    }

    public String getMaLoaiDiem() {
        return maLoaiDiem;
    }

    public void setMaLoaiDiem(String maLoaiDiem) {
        this.maLoaiDiem = maLoaiDiem;
    }

    public String getTenLoaiDiem() {
        return tenLoaiDiem;
    }

    public void setTenLoaiDiem(String tenLoaiDiem) {
        this.tenLoaiDiem = tenLoaiDiem;
    }

    public double getTiLe() {
        return tiLe;
    }

    public void setTiLe(double tiLe) {
        this.tiLe = tiLe;
    }
}

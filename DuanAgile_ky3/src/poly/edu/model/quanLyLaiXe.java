package poly.edu.model;

import java.io.Serializable;

public class quanLyLaiXe implements Serializable {

    private Integer ID;
    private String TenNV;
    private int tuoi;
    private String loaiBang;
    private double luong;
    private int namKinhNghiem;

    public quanLyLaiXe() {
    }

    public quanLyLaiXe(Integer ID, String TenNV, int tuoi, String loaiBang, double luong, int namKinhNghiem) {
        this.ID = ID;
        this.TenNV = TenNV;
        this.tuoi = tuoi;
        this.loaiBang = loaiBang;
        this.luong = luong;
        this.namKinhNghiem = namKinhNghiem;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getLoaiBang() {
        return loaiBang;
    }

    public void setLoaiBang(String loaiBang) {
        this.loaiBang = loaiBang;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public int getNamKinhNghiem() {
        return namKinhNghiem;
    }

    public void setNamKinhNghiem(int namKinhNghiem) {
        this.namKinhNghiem = namKinhNghiem;
    }

    @Override
    public String toString() {
        return "quanLyLaiXe{" + "ID=" + ID + ", TenNV=" + TenNV + ", tuoi=" + tuoi + ", loaiBang=" + loaiBang + ", luong=" + luong + ", namKinhNghiem=" + namKinhNghiem + '}';
    }

    public String getStatus(int namKinhNghiem) {
        if (namKinhNghiem >= 2) {
            return "Lái cũ";
        } else {
            return "Lái mới";
        }
    }
}

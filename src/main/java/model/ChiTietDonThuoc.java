package model;

public class ChiTietDonThuoc {
    private int maChiTiet;
    private int maDonThuoc;
    private int maThuoc;
    private int soLuong;
    private double giaBan;
    private double thanhTien;

    public ChiTietDonThuoc() {}

    public ChiTietDonThuoc(int maChiTiet, int maDonThuoc, int maThuoc, int soLuong, double giaBan) {
        this.maChiTiet = maChiTiet;
        this.maDonThuoc = maDonThuoc;
        this.maThuoc = maThuoc;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhTien = soLuong * giaBan; // Tính tự động
    }

    // Getters & Setters
    public int getMaChiTiet() { return maChiTiet; }
    public void setMaChiTiet(int maChiTiet) { this.maChiTiet = maChiTiet; }

    public int getMaDonThuoc() { return maDonThuoc; }
    public void setMaDonThuoc(int maDonThuoc) { this.maDonThuoc = maDonThuoc; }

    public int getMaThuoc() { return maThuoc; }
    public void setMaThuoc(int maThuoc) { this.maThuoc = maThuoc; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { 
        this.soLuong = soLuong; 
        this.thanhTien = this.soLuong * this.giaBan;
    }

    public double getGiaBan() { return giaBan; }
    public void setGiaBan(double giaBan) { 
        this.giaBan = giaBan; 
        this.thanhTien = this.soLuong * this.giaBan;
    }

    public double getThanhTien() { return thanhTien; }
}

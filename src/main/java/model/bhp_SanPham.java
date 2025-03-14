package model;

public class bhp_SanPham {
    private int id;
    private String tenSanPham;
    private String moTa;
    private double gia;
    private int soLuong;

    // Constructor mặc định
    public bhp_SanPham() {}

    // Constructor với các tham số
    public bhp_SanPham(int id, String tenSanPham, String moTa, double gia, int soLuong) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    // Getter và Setter cho tất cả các thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}

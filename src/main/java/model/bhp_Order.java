package model;

public class bhp_Order {
    private int id;
    private String tenKhachHang;
    private String sdt;
    private String diaChi;
    private double tongTien;
    private String ngayDat;  // Thêm thuộc tính này

    // Constructor đầy đủ
    public bhp_Order(int id, String tenKhachHang, String sdt, String diaChi, double tongTien, String ngayDat) {
        this.id = id;
        this.tenKhachHang = tenKhachHang;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.tongTien = tongTien;
        this.ngayDat = ngayDat;  // Thêm tham số này
    }

    // Getters và Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTenKhachHang() { return tenKhachHang; }
    public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; }

    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

    public String getNgayDat() { return ngayDat; }  // Thêm getter này
    public void setNgayDat(String ngayDat) { this.ngayDat = ngayDat; }  // Thêm setter này
}

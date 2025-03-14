package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class bhp_Product {
    private int bhp_sp_id;
    private String bhp_ten_san_pham;
    private String bhp_mo_ta;
    private BigDecimal bhp_gia;
    private int bhp_so_luong;
    private Timestamp bhp_ngay_tao;

    // Constructor không tham số
    public bhp_Product() {
    }

    // Constructor đầy đủ tham số (tuỳ chọn)
    public bhp_Product(int bhp_sp_id, String bhp_ten_san_pham, String bhp_mo_ta,
                       BigDecimal bhp_gia, int bhp_so_luong, Timestamp bhp_ngay_tao) {
        this.bhp_sp_id = bhp_sp_id;
        this.bhp_ten_san_pham = bhp_ten_san_pham;
        this.bhp_mo_ta = bhp_mo_ta;
        this.bhp_gia = bhp_gia;
        this.bhp_so_luong = bhp_so_luong;
        this.bhp_ngay_tao = bhp_ngay_tao;
    }

    // Getter & Setter
    public int getBhp_sp_id() {
        return bhp_sp_id;
    }

    public void setBhp_sp_id(int bhp_sp_id) {
        this.bhp_sp_id = bhp_sp_id;
    }

    public String getBhp_ten_san_pham() {
        return bhp_ten_san_pham;
    }

    public void setBhp_ten_san_pham(String bhp_ten_san_pham) {
        this.bhp_ten_san_pham = bhp_ten_san_pham;
    }

    public String getBhp_mo_ta() {
        return bhp_mo_ta;
    }

    public void setBhp_mo_ta(String bhp_mo_ta) {
        this.bhp_mo_ta = bhp_mo_ta;
    }

    public BigDecimal getBhp_gia() {
        return bhp_gia;
    }

    public void setBhp_gia(BigDecimal bhp_gia) {
        this.bhp_gia = bhp_gia;
    }

    public int getBhp_so_luong() {
        return bhp_so_luong;
    }

    public void setBhp_so_luong(int bhp_so_luong) {
        this.bhp_so_luong = bhp_so_luong;
    }

    public Timestamp getBhp_ngay_tao() {
        return bhp_ngay_tao;
    }

    public void setBhp_ngay_tao(Timestamp bhp_ngay_tao) {
        this.bhp_ngay_tao = bhp_ngay_tao;
    }
}
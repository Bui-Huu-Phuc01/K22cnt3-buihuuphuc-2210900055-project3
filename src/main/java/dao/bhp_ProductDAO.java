package dao;

import model.bhp_Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class bhp_ProductDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/Buihuuphuc_2210900055_project3?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "buiphuc3d3";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Lấy danh sách tất cả sản phẩm
    public List<bhp_Product> getAllProducts() throws SQLException {
        List<bhp_Product> productList = new ArrayList<>();
        String sql = "SELECT bhp_sp_id, bhp_ten_san_pham, bhp_mo_ta, bhp_gia, bhp_so_luong, bhp_ngay_tao FROM bhp_2210900055_sanpham";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                productList.add(mapResultSetToProduct(rs));
            }
        }
        return productList;
    }

    // Thêm sản phẩm
    public boolean themSanPham(bhp_Product product) throws SQLException {
        String sql = "INSERT INTO bhp_2210900055_sanpham (bhp_ten_san_pham, bhp_mo_ta, bhp_gia, bhp_so_luong, bhp_ngay_tao) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //  stmt.setInt(1, product.getBhp_sp_id());  // ID có thể là auto-increment trong DB
            pstmt.setString(1, product.getBhp_ten_san_pham());
            pstmt.setString(2, product.getBhp_mo_ta());
            pstmt.setBigDecimal(3, product.getBhp_gia());
            pstmt.setInt(4, product.getBhp_so_luong());
            pstmt.setTimestamp(5, product.getBhp_ngay_tao());
            return pstmt.executeUpdate() > 0;
        }
    }

    // Cập nhật sản phẩm
    public boolean updateProduct(bhp_Product product) throws SQLException {
        String sql = "UPDATE bhp_2210900055_sanpham SET bhp_ten_san_pham=?, bhp_mo_ta=?, bhp_gia=?, bhp_so_luong=?, bhp_ngay_tao=? WHERE bhp_sp_id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getBhp_ten_san_pham());
            pstmt.setString(2, product.getBhp_mo_ta());
            pstmt.setBigDecimal(3, product.getBhp_gia());
            pstmt.setInt(4, product.getBhp_so_luong());
            pstmt.setTimestamp(5, product.getBhp_ngay_tao());
            pstmt.setInt(6, product.getBhp_sp_id());
            return pstmt.executeUpdate() > 0;
        }
    }

    // Xóa sản phẩm
    public boolean deleteProduct(int productId) throws SQLException {
        String sql = "DELETE FROM bhp_2210900055_sanpham WHERE bhp_sp_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            return pstmt.executeUpdate() > 0;
        }
    }

    // Lấy thông tin sản phẩm theo ID
    public bhp_Product getProductById(int productId) throws SQLException {
        String sql = "SELECT bhp_sp_id, bhp_ten_san_pham, bhp_mo_ta, bhp_gia, bhp_so_luong, bhp_ngay_tao FROM bhp_2210900055_sanpham WHERE bhp_sp_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToProduct(rs);
            }
        }
        return null;
    }

    // Hàm hỗ trợ: Chuyển từ ResultSet sang bhp_Product
    private bhp_Product mapResultSetToProduct(ResultSet rs) throws SQLException {
        return new bhp_Product(
                rs.getInt("bhp_sp_id"),
                rs.getString("bhp_ten_san_pham"),
                rs.getString("bhp_mo_ta"),
                rs.getBigDecimal("bhp_gia"),
                rs.getInt("bhp_so_luong"),
                rs.getTimestamp("bhp_ngay_tao")
        );
    }
}
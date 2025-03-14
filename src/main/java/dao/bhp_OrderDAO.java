package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bhp_Order;

public class bhp_OrderDAO {

    // Lấy danh sách tất cả đơn hàng
    public List<bhp_Order> getAllOrders() throws SQLException {
        List<bhp_Order> orders = new ArrayList<>();
        String query = "SELECT bhp_dh_id, bhp_ten_khach_hang, bhp_sdt, bhp_dia_chi, bhp_tong_tien, bhp_ngay_dat FROM bhp_2210900055_donhang";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                orders.add(new bhp_Order(
                    rs.getInt("bhp_dh_id"),
                    rs.getString("bhp_ten_khach_hang"),
                    rs.getString("bhp_sdt"),
                    rs.getString("bhp_dia_chi"),
                    rs.getDouble("bhp_tong_tien"),
                    rs.getString("bhp_ngay_dat") // Hoặc Date/Timestamp nếu cần
                ));
            }
        }
        return orders;
    }

    // Thêm đơn hàng mới
    public boolean themDonHang(bhp_Order order) throws SQLException {
        String query = "INSERT INTO bhp_2210900055_donhang (bhp_ten_khach_hang, bhp_sdt, bhp_dia_chi, bhp_tong_tien, bhp_ngay_dat) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, order.getTenKhachHang());
            stmt.setString(2, order.getSdt());
            stmt.setString(3, order.getDiaChi());
            stmt.setDouble(4, order.getTongTien());
            stmt.setString(5, order.getNgayDat()); // Hoặc Date/Timestamp nếu cần

            return stmt.executeUpdate() > 0;
        }
    }

    // Cập nhật đơn hàng
    public boolean capNhatDonHang(bhp_Order order) throws SQLException {
        String query = "UPDATE bhp_2210900055_donhang SET bhp_ten_khach_hang=?, bhp_sdt=?, bhp_dia_chi=?, bhp_tong_tien=?, bhp_ngay_dat=? WHERE bhp_dh_id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, order.getTenKhachHang());
            stmt.setString(2, order.getSdt());
            stmt.setString(3, order.getDiaChi());
            stmt.setDouble(4, order.getTongTien());
            stmt.setString(5, order.getNgayDat()); // Hoặc Date/Timestamp nếu cần
            stmt.setInt(6, order.getId());

            return stmt.executeUpdate() > 0;
        }
    }

    // Xóa đơn hàng theo ID
    public boolean xoaDonHang(int orderId) throws SQLException {
        String query = "DELETE FROM bhp_2210900055_donhang WHERE bhp_dh_id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            return stmt.executeUpdate() > 0;
        }
    }
}
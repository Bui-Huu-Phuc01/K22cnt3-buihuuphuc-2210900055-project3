package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admin;

public class AdminDAO {
    // Câu lệnh SQL để truy vấn admin theo username và password
    private static final String SELECT_ADMIN = 
        "SELECT bhp_admin_id, bhp_username, bhp_password, bhp_created_at " +
        "FROM bhp_2210900055_admin WHERE bhp_username = ? AND bhp_password = ?";

    public Admin getAdminByUsernameAndPassword(String username, String password) {
        Admin admin = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ADMIN)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("bhp_admin_id");
                String uname = rs.getString("bhp_username");
                String pwd = rs.getString("bhp_password");
                // Lấy thêm thời gian tạo nếu cần
                java.sql.Timestamp createdAt = rs.getTimestamp("bhp_created_at");
                admin = new Admin(id, uname, pwd, createdAt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
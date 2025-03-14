package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.bhp_Appointment;

public class bhp_AppointmentDAO {

    // Phương thức lấy danh sách tất cả lịch hẹn từ bảng bhp_appointment
    public List<bhp_Appointment> listAllAppointments() throws SQLException {
        List<bhp_Appointment> listAppointment = new ArrayList<>();
        String sql = "SELECT * FROM bhp_appointment";

        // Sử dụng DatabaseConnection để lấy kết nối
        Connection conn = DatabaseConnection.getConnection();

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("bhp_appointment_id");
            String customerName = resultSet.getString("bhp_customer_name");
            String customerPhone = resultSet.getString("bhp_customer_phone");
            String customerEmail = resultSet.getString("bhp_customer_email");
            String appointmentDate = resultSet.getString("bhp_appointment_date");
            String appointmentTime = resultSet.getString("bhp_appointment_time");
            String notes = resultSet.getString("bhp_notes");
            String createdAt = resultSet.getString("bhp_created_at");

            bhp_Appointment appointment = new bhp_Appointment(id, customerName, customerPhone, customerEmail,
                                                                appointmentDate, appointmentTime, notes, createdAt);
            listAppointment.add(appointment);
        }

        resultSet.close();
        statement.close();
        DatabaseConnection.closeConnection(conn);

        return listAppointment;
    }

    // Nếu cần thêm các phương thức CRUD khác, bạn có thể bổ sung thêm tại đây.
}

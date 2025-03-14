<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.bhp_Appointment" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách lịch hẹn</title>
    <style>
        table { 
            width: 100%; 
            border-collapse: collapse; 
            margin-top: 20px; 
        }
        th, td { 
            border: 1px solid #ddd; 
            padding: 8px; 
            text-align: left; 
        }
        th { 
            background-color: #f2f2f2; 
        }
    </style>
</head>
<body>
    <h2>Danh sách lịch hẹn</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên khách hàng</th>
                <th>Số điện thoại</th>
                <th>Email</th>
                <th>Ngày hẹn</th>
                <th>Giờ hẹn</th>
                <th>Ghi chú</th>
                <th>Ngày tạo</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<bhp_Appointment> appointments = (List<bhp_Appointment>) request.getAttribute("appointments");
                if (appointments != null && !appointments.isEmpty()) {
                    for (bhp_Appointment appointment : appointments) {
            %>
                        <tr>
                            <td><%= appointment.getBhp_appointment_id() %></td>
                            <td><%= appointment.getBhp_customer_name() %></td>
                            <td><%= appointment.getBhp_customer_phone() %></td>
                            <td><%= appointment.getBhp_customer_email() %></td>
                            <td><%= appointment.getBhp_appointment_date() %></td>
                            <td><%= appointment.getBhp_appointment_time() %></td>
                            <td><%= appointment.getBhp_notes() %></td>
                            <td><%= appointment.getBhp_created_at() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                        <tr>
                            <td colspan="8">Không có lịch hẹn nào.</td>
                        </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>

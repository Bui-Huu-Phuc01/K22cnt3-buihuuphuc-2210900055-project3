<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Đơn hàng</title>
</head>
<body>
    <header>
        <h1>Quản lý Đơn hàng</h1>
        <nav>
            <ul>
                <li><a href="index.jsp">Trang chủ</a></li>
                <li><a href="products.jsp">Quản lý Thuốc</a></li>
                <li><a href="report.jsp">Báo cáo Doanh thu</a></li>
                <li><a href="login.jsp">Đăng nhập</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <h2>Danh sách Đơn hàng</h2>
        <table border="1">
            <tr>
                <th>Mã đơn</th>
                <th>Khách hàng</th>
                <th>Ngày đặt</th>
                <th>Tổng tiền</th>
                <th>Trạng thái</th>
                <th>Hành động</th>
            </tr>
            <%
                // Ví dụ dữ liệu giả định
                String[][] orders = {
                    {"BHP_001", "Nguyễn Văn A", "2025-03-01", "1.200.000 VND", "Đã giao"},
                    {"BHP_002", "Trần Thị B", "2025-03-02", "850.000 VND", "Chờ xử lý"}
                };
                for (String[] order : orders) {
            %>
            <tr>
                <td><%= order[0] %></td>
                <td><%= order[1] %></td>
                <td><%= order[2] %></td>
                <td><%= order[3] %></td>
                <td><%= order[4] %></td>
                <td>
                    <a href="editOrder.jsp?id=<%= order[0] %>">Sửa</a> |
                    <a href="deleteOrder.jsp?id=<%= order[0] %>" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>

        <h2>Thêm Đơn hàng</h2>
        <form action="addOrderServlet" method="post">
            <label>Khách hàng: <input type="text" name="customer"></label><br>
            <label>Ngày đặt: <input type="date" name="orderDate"></label><br>
            <label>Tổng tiền: <input type="text" name="totalPrice"></label><br>
            <label>Trạng thái:
                <select name="status">
                    <option value="Chờ xử lý">Chờ xử lý</option>
                    <option value="Đang giao">Đang giao</option>
                    <option value="Đã giao">Đã giao</option>
                </select>
            </label><br>
            <button type="submit">Thêm đơn hàng</button>
        </form>
    </main>

    <footer>
        <p>&copy; 2025 Hiệu thuốc Đông Y Bùi Phúc. Mọi quyền được bảo lưu.</p>
    </footer>
</body>
</html>

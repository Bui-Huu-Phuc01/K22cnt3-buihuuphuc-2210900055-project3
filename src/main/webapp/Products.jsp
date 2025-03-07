<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Sản phẩm</title>
</head>
<body>
    <h1>Quản lý Sản phẩm</h1>

    <!-- Form thêm sản phẩm -->
    <h2>Thêm Sản Phẩm</h2>
    <form action="add-product" method="post">
        <label for="tenSanPham">Tên sản phẩm:</label>
        <input type="text" name="tenSanPham" required>
        
        <label for="moTa">Mô tả:</label>
        <input type="text" name="moTa" required>
        
        <label for="gia">Giá:</label>
        <input type="number" name="gia" step="0.01" required>
        
        <button type="submit">Thêm</button>
    </form>

    <hr>

    <!-- Danh sách sản phẩm -->
    <h2>Danh Sách Sản Phẩm</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên Sản Phẩm</th>
                <th>Mô Tả</th>
                <th>Giá</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <%
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thuoc_db", "root", "password");
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM bhp_sanpham");

                    while (rs.next()) {
            %>
                        <tr>
                            <td><%= rs.getInt("bhp_id") %></td>
                            <td><%= rs.getString("ten_sanpham") %></td>
                            <td><%= rs.getString("mo_ta") %></td>
                            <td><%= rs.getDouble("gia") %></td>
                            <td>
                                <a href="editProduct.jsp?id=<%= rs.getInt("bhp_id") %>">Sửa</a>
                                |
                                <a href="delete-product?id=<%= rs.getInt("bhp_id") %>" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Xóa</a>
                            </td>
                        </tr>
            <%
                    }
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </tbody>
    </table>

</body>
</html>

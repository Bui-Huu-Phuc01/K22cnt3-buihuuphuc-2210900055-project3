<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh sửa Sản phẩm</title>
</head>
<body>
    <h1>Chỉnh sửa Sản phẩm</h1>

    <%
        int id = Integer.parseInt(request.getParameter("id"));
        String tenSanPham = "";
        String moTa = "";
        double gia = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thuoc_db", "root", "password");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bhp_sanpham WHERE bhp_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tenSanPham = rs.getString("ten_sanpham");
                moTa = rs.getString("mo_ta");
                gia = rs.getDouble("gia");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <form action="edit-product" method="post">
        <input type="hidden" name="id" value="<%= id %>">
        
        <label for="tenSanPham">Tên sản phẩm:</label>
        <input type="text" name="tenSanPham" value="<%= tenSanPham %>" required>
        
        <label for="moTa">Mô tả:</label>
        <input type="text" name="moTa" value="<%= moTa %>" required>
        
        <label for="gia">Giá:</label>
        <input type="number" name="gia" step="0.01" value="<%= gia %>" required>
        
        <button type="submit">Cập nhật</button>
    </form>

    <a href="products.jsp">Quay lại danh sách</a>
</body>
</html>

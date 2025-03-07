<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng Ký Tài Khoản</title>
    <link rel="stylesheet" href="styles.css"> <%-- Thêm CSS nếu cần --%>
</head>
<body>
    <h2>Đăng Ký Tài Khoản</h2>
    
    <form action="register" method="post">
        <label for="username">Tên đăng nhập:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="password" required>

        <label for="confirmPassword">Xác nhận mật khẩu:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>

        <button type="submit">Đăng Ký</button>
    </form>

    <%-- Hiển thị thông báo lỗi nếu có --%>
    <% String message = request.getParameter("message");
       if (message != null) { %>
        <p style="color: red;"><%= message %></p>
    <% } %>

    <p>Đã có tài khoản? <a href="login.jsp">Đăng nhập</a></p>
</body>
</html>

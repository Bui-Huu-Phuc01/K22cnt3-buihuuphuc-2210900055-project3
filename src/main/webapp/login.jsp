<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
    <h2>Đăng nhập</h2>

    <!-- Hiển thị lỗi nếu có -->
    <%
        String error = request.getParameter("error");
        if("1".equals(error)){
    %>
        <p style="color:red;">Sai thông tin đăng nhập!</p>
    <%
        } else if("2".equals(error)){
    %>
        <p style="color:red;">Đã xảy ra lỗi Exception!</p>
    <%
        }
    %>

    <form action="<%= request.getContextPath() %>/LoginServlet" method="post">
        <label>Tên đăng nhập:</label>
        <input type="text" name="username" required><br><br>

        <label>Mật khẩu:</label>
        <input type="password" name="password" required><br><br>

        <button type="submit">Đăng nhập</button>
    </form>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 50px;
        }
        h1 {
            color: #2c3e50;
        }
        .container {
            margin-top: 20px;
        }
        a {
            display: block;
            margin: 10px;
            text-decoration: none;
            color: #3498db;
            font-size: 18px;
        }
        a:hover {
            color: #e74c3c;
        }
    </style>
</head>
<body>

    <h1>Chào mừng đến với Hệ thống Quản lý Thuốc</h1>

    <div class="container">
        <a href="KhachHangServlet">Quản lý Khách Hàng</a>
        <a href="ThuocServlet">Quản lý Thuốc</a>
        <a href="DonThuocServlet">Quản lý Đơn Thuốc</a>
        <a href="NhanVienServlet">Quản lý Nhân Viên</a>
    </div>

</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ - Hiệu Thuốc Đông Y Bùi Phúc</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .hero {
            background: url('images/pharmacy-banner.jpg') no-repeat center center;
            background-size: cover;
            height: 300px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.7);
        }
        .footer {
            background: #343a40;
            color: white;
            padding: 15px 0;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">Hiệu Thuốc Bùi Phúc</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link active" href="index.jsp">Trang chủ</a></li>
                    <li class="nav-item"><a class="nav-link" href="login.jsp">Đăng nhập</a></li>
                    <li class="nav-item"><a class="nav-link" href="register.jsp">Đăng ký</a></li>
                    <li class="nav-item"><a class="nav-link" href="admin.jsp">Quản lý</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <div class="hero">
        <h1>Chào mừng đến với Hiệu Thuốc Đông Y Bùi Phúc</h1>
    </div>

    <!-- Nội dung chính -->
    <div class="container text-center my-4">
        <h3>Quản lý hiệu thuốc dễ dàng & hiệu quả</h3>
        <p>Hệ thống giúp bạn theo dõi kho thuốc, đơn hàng và thông tin khách hàng một cách chuyên nghiệp.</p>
        <a href="register.jsp" class="btn btn-success">Bắt đầu ngay</a>
    </div>

    <!-- Footer -->
    <footer class="footer">
        <p>&copy; 2025 Hiệu Thuốc Bùi Phúc | Designed by YourName</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>bhp_Quản Lý Hệ Thống</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body { background-color: #f8f9fa; }
        .nav-card { margin: 20px 0; }
    </style>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h2 class="text-center mb-4">bhp_Quản Lý Hệ Thống</h2>
        <div class="row">
            <!-- Quản lý Admin -->
            <div class="col-md-4">
                <div class="card nav-card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Quản Lý Admin</h5>
                        <p class="card-text">Quản lý thông tin Admin hệ thống.</p>
                        <a href="<%= request.getContextPath() %>/bhp_quanly_admin.jsp" class="btn btn-primary">Vào quản lý</a>
                    </div>
                </div>
            </div>
            <!-- Quản lý Sản phẩm -->
            <div class="col-md-4">
                <div class="card nav-card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Quản Lý Sản Phẩm</h5>
                        <p class="card-text">Quản lý thông tin Sản phẩm.</p>
                        <a href="<%= request.getContextPath() %>/bhp_quanly_sanpham.jsp" class="btn btn-primary">Vào quản lý</a>
                    </div>
                </div>
            </div>
            <!-- Đặt lịch -->
            <div class="col-md-4">
                <div class="card nav-card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Đặt Lịch</h5>
                        <p class="card-text">Quản lý đặt lịch hẹn khách hàng.</p>
                        <a href="<%= request.getContextPath() %>/bhp_datlich.jsp" class="btn btn-primary">Vào quản lý</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Nút quay lại trang chủ -->
        <div class="text-center mt-4">
            <a href="<%= request.getContextPath() %>/index.jsp" class="btn btn-secondary">Quay lại trang chủ</a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

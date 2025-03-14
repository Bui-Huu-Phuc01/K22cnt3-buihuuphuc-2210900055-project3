<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Quản lý hệ thống</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body { font-family: Arial, sans-serif; }
        .sidebar { height: 100vh; background: #343a40; color: white; padding-top: 20px; position: fixed; width: 250px; }
        .sidebar a { color: white; text-decoration: none; padding: 15px; display: block; }
        .sidebar a:hover { background: #495057; }
        .content { margin-left: 260px; padding: 20px; }
    </style>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <nav class="col-md-3 col-lg-2 sidebar">
                <h4 class="text-center">Quản lý hệ thống</h4>
                <a href="dashboard.jsp">Trang chủ</a>
                <a href="quanlyadmin.jsp">Quản lý Admin</a>
                <a href="quanlysanpham.jsp">Quản lý Sản phẩm</a>
                <a href="baocao.jsp">Báo cáo</a>
                <a href="logout.jsp" class="text-danger">🚪 Đăng xuất</a>
            </nav>
            
            <!-- Main Content -->
            <main class="col-md-9 col-lg-10 content">
                <h2>Chào mừng, <%= session.getAttribute("adminUsername") %>!</h2>
                <p>Đây là bảng điều khiển hệ thống quản lý hiệu thuốc Đông y Bùi Phúc.</p>
                
                <!-- Bảng hiển thị thông tin -->
                <div class="card">
                    <div class="card-header bg-primary text-white">Danh sách Quản trị viên</div>
                    <div class="card-body">
                        <table class="table table-bordered">
                            <thead class="table-dark">
                                <tr>
                                    <th>ID</th>
                                    <th>Tên đăng nhập</th>
                                    <th>Email</th>
                                    <th>Hành động</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%-- Lấy danh sách admin từ request attribute --%>
                                <c:forEach var="admin" items="${adminList}">
    <tr>
        <td>${admin.bhp_admin_id}</td>
        <td>${admin.bhp_username}</td>
        <td>${admin.bhp_email}</td>
        <td>
            <a href="editAdmin.jsp?id=${admin.bhp_admin_id}" class="btn btn-warning btn-sm">Sửa</a>
            <a href="deleteAdmin?id=${admin.bhp_admin_id}" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Xóa</a>
        </td>
    </tr>
</c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </main>
        </div>
    </div>
</body>
</html>

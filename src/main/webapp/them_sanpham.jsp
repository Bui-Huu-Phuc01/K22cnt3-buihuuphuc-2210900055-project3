<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.SanPhamDAO, model.SanPham" %>
<%@ page import="java.io.IOException" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Thêm sản phẩm mới</h2>
        
        <form action="ThemSanPhamServlet" method="post">
            <div class="mb-3">
                <label class="form-label">Tên sản phẩm:</label>
                <input type="text" class="form-control" name="tenSanPham" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Giá:</label>
                <input type="number" class="form-control" name="gia" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Số lượng:</label>
                <input type="number" class="form-control" name="soLuong" required>
            </div>
            <button type="submit" class="btn btn-success">✔️ Thêm sản phẩm</button>
            <a href="quanly_sanpham.jsp" class="btn btn-secondary">🔙 Quay lại</a>
        </form>
    </div>
</body>
</html>

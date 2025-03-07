<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.SanPhamDAO" %>
<%@ page import="model.SanPham" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý Sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Quản lý Sản phẩm</h2>

        <a href="them_sanpham.jsp" class="btn btn-primary mb-3">➕ Thêm sản phẩm</a>

        <table class="table table-bordered table-hover">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Tên sản phẩm</th>
                    <th>Giá</th>
                    <th>Số lượng</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <%
                    SanPhamDAO sanPhamDAO = new SanPhamDAO();
                    List<SanPham> danhSachSanPham = sanPhamDAO.getAllSanPham();

                    if (danhSachSanPham != null && !danhSachSanPham.isEmpty()) {
                        for (SanPham sp : danhSachSanPham) {
                %>
                <tr>
                    <td><%= sp.getId() %></td>
                    <td><%= sp.getTenSanPham() %></td>
                    <td><%= sp.getGia() %> VND</td>
                    <td><%= sp.getSoLuong() %></td>
                    <td>
                        <a href="sua_sanpham.jsp?id=<%= sp.getId() %>" class="btn btn-warning btn-sm">✏️ Sửa</a>
                        <a href="XoaSanPhamServlet?id=<%= sp.getId() %>" class="btn btn-danger btn-sm" 
                           onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?');">🗑️ Xóa</a>
                    </td>
                </tr>
                <% 
                        }
                    } else { 
                %>
                <tr>
                    <td colspan="5" class="text-center">Không có sản phẩm nào!</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>

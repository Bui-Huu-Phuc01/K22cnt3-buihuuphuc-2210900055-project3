<%@ page import="java.util.List" %>
<%@ page import="model.bhp_Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý sản phẩm</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        body {
            font-family: "Segoe UI", Tahoma, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="mt-4">Quản lý sản phẩm</h1>

        <div class="row mt-4">
            <div class="col-md-6">
                <h2>Thêm sản phẩm mới</h2>
                <form action="bhp_SanPhamServlet?action=insert" method="post" class="mt-3">
                    <div class="form-group">
                        <label for="bhp_tenSanPham">Tên sản phẩm:</label>
                        <input type="text" id="bhp_tenSanPham" name="bhp_tenSanPham" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="bhp_moTa">Mô tả:</label>
                        <input type="text" id="bhp_moTa" name="bhp_moTa" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="bhp_gia">Giá:</label>
                        <input type="text" id="bhp_gia" name="bhp_gia" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="bhp_soLuong">Số lượng:</label>
                        <input type="text" id="bhp_soLuong" name="bhp_soLuong" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-primary"><i class="fas fa-plus"></i> Thêm sản phẩm</button>
                </form>
            </div>

            <div class="col-md-6">
                <%
                    bhp_Product productToEdit = (bhp_Product) request.getAttribute("product");
                    if (productToEdit != null) {
                %>
                <h2>Sửa sản phẩm</h2>
                <form action="bhp_SanPhamServlet?action=update" method="post" class="mt-3">
                    <input type="hidden" name="id" value="<%= productToEdit.getBhp_sp_id() %>">
                    <div class="form-group">
                        <label for="bhp_tenSanPham">Tên sản phẩm:</label>
                        <input type="text" id="bhp_tenSanPham" name="bhp_tenSanPham" value="<%= productToEdit.getBhp_ten_san_pham() %>" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="bhp_moTa">Mô tả:</label>
                        <input type="text" id="bhp_moTa" name="bhp_moTa" value="<%= productToEdit.getBhp_mo_ta() %>" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="bhp_gia">Giá:</label>
                        <input type="text" id="bhp_gia" name="bhp_gia" value="<%= productToEdit.getBhp_gia() %>" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="bhp_soLuong">Số lượng:</label>
                        <input type="text" id="bhp_soLuong" name="bhp_soLuong" value="<%= productToEdit.getBhp_so_luong() %>" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-success"><i class="fas fa-edit"></i> Cập nhật sản phẩm</button>
                </form>
                <%
                    }
                %>
            </div>
        </div>

        <h2 class="mt-4">Danh sách sản phẩm</h2>
        <table class="table table-bordered mt-3">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên sản phẩm</th>
                    <th>Mô tả</th>
                    <th>Giá</th>
                    <th>Số lượng</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<bhp_Product> productList = (List<bhp_Product>) request.getAttribute("productList");
                    if (productList != null && !productList.isEmpty()) {
                        for (bhp_Product product : productList) {
                %>
                <tr>
                    <td><%= product.getBhp_sp_id() %></td>
                    <td><%= product.getBhp_ten_san_pham() %></td>
                    <td><%= product.getBhp_mo_ta() %></td>
                    <td><%= product.getBhp_gia() %></td>
                    <td><%= product.getBhp_so_luong() %></td>
                    <td>
                        <a href="bhp_SanPhamServlet?action=edit&id=<%= product.getBhp_sp_id() %>" class="btn btn-sm btn-primary"><i class="fas fa-edit"></i> Sửa</a>
                        <a href="bhp_SanPhamServlet?action=delete&id=<%= product.getBhp_sp_id() %>" class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i> Xóa</a>
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="6">Không có sản phẩm nào.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
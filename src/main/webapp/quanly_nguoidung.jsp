<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.bhp_UserDAO, model.bhp_User, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản Lý Người Dùng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h2 class="text-center mb-4">Quản Lý Người Dùng</h2>

        <!-- Form thêm người dùng -->
        <div class="card mb-4">
            <div class="card-header bg-primary text-white">Thêm Người Dùng Mới</div>
            <div class="card-body">
                <form action="<%= request.getContextPath() %>/bhp_AddUserServlet" method="post" class="row g-3">
                    <div class="col-md-4">
                        <label class="form-label">Tên người dùng</label>
                        <input type="text" name="username" class="form-control" required>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Email</label>
                        <input type="email" name="email" class="form-control" required>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Số điện thoại</label>
                        <input type="text" name="phone" class="form-control" required>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Mật khẩu</label>
                        <input type="password" name="password" class="form-control" required>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary">Thêm Người Dùng</button>
                    </div>
                </form>
            </div>
        </div>

        <!-- Danh sách người dùng -->
        <h4 class="mb-3">Danh sách Người Dùng</h4>
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Tên người dùng</th>
                    <th>Email</th>
                    <th>Số điện thoại</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
            
                <%
                    bhp_UserDAO userDAO = new bhp_UserDAO();
                    List<bhp_User> userList = userDAO.getAllUsers();
                    for (bhp_User user : userList) {
                %>
                <tr>
                    <td><%= user.getId() %></td>
                    <td><%= user.getUsername() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.getPhone() %></td>
                    <td>
                        <form action="<%= request.getContextPath() %>/DeleteUserServlet" method="get" style="display: inline;">
                            <input type="hidden" name="id" value="<%= user.getId() %>">
                            <button type="submit" class="btn btn-danger btn-sm">Xóa</button>
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>

package controller;

import dao.bhp_UserDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userIdParam = request.getParameter("id");

        if (userIdParam != null && !userIdParam.isEmpty()) {
            try {
                int userId = Integer.parseInt(userIdParam);
                bhp_UserDAO userDAO = new bhp_UserDAO();
                userDAO.deleteUser(userId);

                // Xóa thành công, chuyển hướng về trang quản lý người dùng
                response.sendRedirect("quanly_nguoidung.jsp");
            } catch (NumberFormatException e) {
                // Xử lý lỗi nếu ID không phải là số
                request.setAttribute("error", "ID người dùng không hợp lệ.");
                request.getRequestDispatcher("quanly_nguoidung.jsp").forward(request, response);
            }
        } else {
            // Xử lý lỗi nếu không có ID người dùng
            request.setAttribute("error", "Không tìm thấy ID người dùng.");
            request.getRequestDispatcher("quanly_nguoidung.jsp").forward(request, response);
        }
    }
}
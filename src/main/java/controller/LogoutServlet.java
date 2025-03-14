package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Sử dụng doGet hoặc doPost đều được. Thường doGet là đủ cho logout.
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Lấy session hiện tại, nếu có
        HttpSession session = request.getSession(false);
        
        // Nếu session != null, tiến hành hủy
        if (session != null) {
            session.invalidate();
        }
        
        // Chuyển hướng về trang login.jsp (hoặc trang chủ)
        response.sendRedirect("login.jsp");
    }
    
    // Nếu muốn logout bằng POST, có thể override doPost:
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

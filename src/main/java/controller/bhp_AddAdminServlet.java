package controller;

import dao.AdminDAO;
import model.Admin;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/bhp_AddAdminServlet")
public class bhp_AddAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO = new AdminDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("bhp_username");
        String password = request.getParameter("bhp_password");
        String email = request.getParameter("bhp_email");

        Admin admin = new Admin();
        admin.setBhp_username(username);
        admin.setBhp_password(password);
        admin.setBhp_email(email);

        adminDAO.insertAdmin(admin);

        response.sendRedirect(request.getContextPath() + "/bhp_quanly_admin.jsp");
    }
}

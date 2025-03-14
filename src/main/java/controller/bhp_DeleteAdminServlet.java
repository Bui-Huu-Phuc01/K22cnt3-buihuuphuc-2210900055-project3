package controller;

import dao.AdminDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/bhp_DeleteAdminServlet")
public class bhp_DeleteAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO = new AdminDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        adminDAO.deleteAdmin(id);
        response.sendRedirect(request.getContextPath() + "/bhp_quanly_admin.jsp");
    }
}

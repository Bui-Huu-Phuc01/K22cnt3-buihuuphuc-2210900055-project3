package controller;

import dao.bhp_UserDAO;
import model.bhp_User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/bhp_AddUserServlet")
public class bhp_AddUserServlet extends HttpServlet {
    private bhp_UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new bhp_UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        bhp_User user = new bhp_User(0, username, email, phone, password);

        boolean success = userDAO.addUser(user);

        if (success) {
            response.sendRedirect(request.getContextPath() + "/quanly_nguoidung.jsp?success=1");
        } else {
            response.sendRedirect(request.getContextPath() + "/quanly_nguoidung.jsp?error=1");
        }
    }
}

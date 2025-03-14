package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Buihuuphuc_2210900055_project3";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Buiphuc3d3";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            HttpSession session = request.getSession();

            // Kiểm tra trong bảng bhp_2210900055_admin
            String sqlAdmin = "SELECT * FROM bhp_2210900055_admin WHERE bhp_username=? AND bhp_password=?";
            PreparedStatement stmtAdmin = conn.prepareStatement(sqlAdmin);
            stmtAdmin.setString(1, username);
            stmtAdmin.setString(2, password);
            ResultSet rsAdmin = stmtAdmin.executeQuery();

            if (rsAdmin.next()) {
                session.setAttribute("username", username);
                session.setAttribute("role", "admin");
                response.sendRedirect("admin_dashboard.jsp");
                conn.close();
                return;
            }

            // Kiểm tra trong bảng bhp_users
            String sqlUser = "SELECT * FROM bhp_users WHERE username=? AND password=?";
            PreparedStatement stmtUser = conn.prepareStatement(sqlUser);
            stmtUser.setString(1, username);
            stmtUser.setString(2, password);
            ResultSet rsUser = stmtUser.executeQuery();

            if (rsUser.next()) {
                session.setAttribute("username", username);
                session.setAttribute("role", "user");
                response.sendRedirect("user_dashboard.jsp");
                conn.close();
                return;
            }

            // Sai thông tin đăng nhập
            response.sendRedirect("login.jsp?error=1");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=2");
        }
    }
}
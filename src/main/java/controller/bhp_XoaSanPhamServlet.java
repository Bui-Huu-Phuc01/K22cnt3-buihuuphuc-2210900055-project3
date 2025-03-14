package controller;

import dao.bhp_ProductDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/bhp_XoaSanPhamServlet")
public class bhp_XoaSanPhamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(bhp_XoaSanPhamServlet.class.getName());
    private bhp_ProductDAO bhp_productDAO;

    @Override
    public void init() {
        bhp_productDAO = new bhp_ProductDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));

        try {
            boolean success = bhp_productDAO.deleteProduct(productId);
            if (success) {
                request.getSession().setAttribute("bhp_success", "Xóa sản phẩm thành công");
            } else {
                request.getSession().setAttribute("bhp_error", "Không thể xóa sản phẩm");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Lỗi khi xóa sản phẩm: ", e);
            request.getSession().setAttribute("bhp_error", "Lỗi: " + e.getMessage());
        }

        response.sendRedirect("bhp_SanPhamServlet");
    }
}
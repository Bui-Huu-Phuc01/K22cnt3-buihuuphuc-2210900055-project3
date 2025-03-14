package controller;

import dao.bhp_ProductDAO;
import model.bhp_Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/bhp_CapNhatSanPhamServlet")
public class bhp_CapNhatSanPhamServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(bhp_CapNhatSanPhamServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String ten = request.getParameter("ten");
            String moTa = request.getParameter("moTa");
            BigDecimal gia = new BigDecimal(request.getParameter("gia"));
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));

            // Tạo đối tượng sản phẩm
            bhp_Product sanPham = new bhp_Product(id, ten, moTa, gia, soLuong, null);
            bhp_ProductDAO productDAO = new bhp_ProductDAO();

            boolean success = productDAO.updateProduct(sanPham);

            if (success) {
                request.getSession().setAttribute("success", "Cập nhật sản phẩm thành công");
            } else {
                request.getSession().setAttribute("error", "Không thể cập nhật sản phẩm");
            }

        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Lỗi định dạng số: ", e);
            request.getSession().setAttribute("error", "Giá hoặc số lượng không hợp lệ");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Lỗi trong quá trình cập nhật sản phẩm: ", e);
            request.getSession().setAttribute("error", "Lỗi không xác định: " + e.getMessage());
        }

        // Chuyển hướng về danh sách sản phẩm
        response.sendRedirect(request.getContextPath() + "/bhp_SanPhamServlet");
    }
}

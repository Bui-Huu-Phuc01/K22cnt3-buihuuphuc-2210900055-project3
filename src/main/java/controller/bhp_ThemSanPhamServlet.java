package controller;

import dao.bhp_ProductDAO;
import model.bhp_Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

@WebServlet("/bhp_ThemSanPhamServlet")
public class bhp_ThemSanPhamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String tenSanPham = request.getParameter("tenSanPham"); // Đảm bảo khớp với tên trường trong form
        String moTa = request.getParameter("moTa"); // Đảm bảo khớp với tên trường trong form
        String giaStr = request.getParameter("gia"); // Đảm bảo khớp với tên trường trong form
        String soLuongStr = request.getParameter("soLuong"); // Đảm bảo khớp với tên trường trong form

        HttpSession session = request.getSession();

        try {
            BigDecimal gia = new BigDecimal(giaStr);
            int soLuong = Integer.parseInt(soLuongStr);
            Timestamp ngayTao = new Timestamp(System.currentTimeMillis());

            // Tạo đối tượng sản phẩm
            bhp_Product sanPham = new bhp_Product();
            sanPham.setBhp_ten_san_pham(tenSanPham);
            sanPham.setBhp_mo_ta(moTa);
            sanPham.setBhp_gia(gia);
            sanPham.setBhp_so_luong(soLuong);
            sanPham.setBhp_ngay_tao(ngayTao);

            // Gọi DAO để thêm sản phẩm
            bhp_ProductDAO productDAO = new bhp_ProductDAO();
            boolean themThanhCong = productDAO.themSanPham(sanPham);

            if (themThanhCong) {
                session.setAttribute("success", "Thêm sản phẩm thành công!");
            } else {
                session.setAttribute("error", "Thêm sản phẩm thất bại!");
            }
        } catch (NumberFormatException e) {
            session.setAttribute("error", "Dữ liệu không hợp lệ: Giá hoặc số lượng không đúng định dạng!");
        } catch (Exception e) {
            session.setAttribute("error", "Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace(); // In lỗi ra console để debug
        }

        response.sendRedirect("bhp_SanPhamServlet"); // Chuyển hướng đến Servlet chính
    }
}
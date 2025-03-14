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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/bhp_SanPhamServlet")
public class bhp_SanPhamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(bhp_SanPhamServlet.class.getName());
    private bhp_ProductDAO bhp_productDAO;

    @Override
    public void init() {
        bhp_productDAO = new bhp_ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("delete".equals(action)) {
                deleteProduct(request, response);
            } else if ("edit".equals(action)) {
                showEditForm(request, response);
            } else if ("new".equals(action)) {
                showNewForm(request, response);
            } else {
                listProducts(request, response);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Lỗi cơ sở dữ liệu trong doGet: ", e);
            request.getSession().setAttribute("error", "Lỗi cơ sở dữ liệu: " + e.getMessage());
            response.sendRedirect("bhp_SanPhamServlet");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Lỗi IO trong doGet: ", e);
            request.getSession().setAttribute("error", "Lỗi: " + e.getMessage());
            response.sendRedirect("bhp_SanPhamServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("update".equals(action)) {
                updateProduct(request, response);
            } else if ("insert".equals(action)) {
                insertProduct(request, response);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Lỗi cơ sở dữ liệu trong doPost: ", e);
            request.getSession().setAttribute("error", "Lỗi cơ sở dữ liệu: " + e.getMessage());
            response.sendRedirect("bhp_SanPhamServlet");
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Lỗi định dạng số trong doPost: ", e);
            request.getSession().setAttribute("error", "Giá hoặc số lượng không hợp lệ");
            response.sendRedirect("bhp_SanPhamServlet");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Lỗi IO trong doPost: ", e);
            request.getSession().setAttribute("error", "Lỗi: " + e.getMessage());
            response.sendRedirect("bhp_SanPhamServlet");
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<bhp_Product> productList = bhp_productDAO.getAllProducts();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("/bhp_quanly_sanpham.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/bhp_quanly_sanpham.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bhp_Product existingProduct = bhp_productDAO.getProductById(id);
        request.setAttribute("product", existingProduct);
        request.getRequestDispatcher("/bhp_quanly_sanpham.jsp").forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String tenSanPham = request.getParameter("bhp_tenSanPham"); // Thêm tiền tố bhp_
        String moTa = request.getParameter("bhp_moTa"); // Thêm tiền tố bhp_
        String giaStr = request.getParameter("bhp_gia"); // Thêm tiền tố bhp_
        String soLuongStr = request.getParameter("bhp_soLuong"); // Thêm tiền tố bhp_

        if (isEmpty(tenSanPham) || isEmpty(moTa) || isEmpty(giaStr) || isEmpty(soLuongStr)) {
            request.getSession().setAttribute("error", "Vui lòng nhập đầy đủ thông tin sản phẩm");
            response.sendRedirect("bhp_SanPhamServlet");
            return;
        }

        BigDecimal gia = new BigDecimal(giaStr);
        int soLuong = Integer.parseInt(soLuongStr);

        bhp_Product newProduct = new bhp_Product();
        newProduct.setBhp_ten_san_pham(tenSanPham);
        newProduct.setBhp_mo_ta(moTa);
        newProduct.setBhp_gia(gia);
        newProduct.setBhp_so_luong(soLuong);
        newProduct.setBhp_ngay_tao(new java.sql.Timestamp(System.currentTimeMillis()));

        boolean success = bhp_productDAO.themSanPham(newProduct);

        if (success) {
            request.getSession().setAttribute("success", "Thêm sản phẩm thành công");
        } else {
            request.getSession().setAttribute("error", "Không thể thêm sản phẩm");
        }
        response.sendRedirect("bhp_SanPhamServlet");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tenSanPham = request.getParameter("bhp_tenSanPham"); // Thêm tiền tố bhp_
        String moTa = request.getParameter("bhp_moTa"); // Thêm tiền tố bhp_
        String giaStr = request.getParameter("bhp_gia"); // Thêm tiền tố bhp_
        String soLuongStr = request.getParameter("bhp_soLuong"); // Thêm tiền tố bhp_

        if (isEmpty(tenSanPham) || isEmpty(moTa) || isEmpty(giaStr) || isEmpty(soLuongStr)) {
            request.getSession().setAttribute("error", "Vui lòng nhập đầy đủ thông tin sản phẩm");
            response.sendRedirect("bhp_SanPhamServlet");
            return;
        }

        BigDecimal gia = new BigDecimal(giaStr);
        int soLuong = Integer.parseInt(soLuongStr);

        bhp_Product updateProduct = new bhp_Product();
        updateProduct.setBhp_sp_id(id);
        updateProduct.setBhp_ten_san_pham(tenSanPham);
        updateProduct.setBhp_mo_ta(moTa);
        updateProduct.setBhp_gia(gia);
        updateProduct.setBhp_so_luong(soLuong);
        updateProduct.setBhp_ngay_tao(new java.sql.Timestamp(System.currentTimeMillis()));

        boolean success = bhp_productDAO.updateProduct(updateProduct);

        if (success) {
            request.getSession().setAttribute("success", "Cập nhật sản phẩm thành công");
        } else {
            request.getSession().setAttribute("error", "Không thể cập nhật sản phẩm");
        }
        response.sendRedirect("bhp_SanPhamServlet");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean success = bhp_productDAO.deleteProduct(id);

        if (success) {
            request.getSession().setAttribute("success", "Xóa sản phẩm thành công");
        } else {
            request.getSession().setAttribute("error", "Không thể xóa sản phẩm");
        }
        response.sendRedirect("bhp_SanPhamServlet");
    }

    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
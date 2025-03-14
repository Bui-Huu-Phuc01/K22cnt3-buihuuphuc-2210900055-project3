package controller;

import dao.bhp_OrderDAO;
import model.bhp_Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/bhp_AddOrdergServlet")
public class bhp_AddOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private bhp_OrderDAO orderDAO;

    @Override
    public void init() throws ServletException {
        orderDAO = new bhp_OrderDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String tenKhachHang = request.getParameter("tenKhachHang");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");

            double tongTien = 0;
            try {
                tongTien = Double.parseDouble(request.getParameter("tongTien"));
            } catch (NumberFormatException e) {
                System.err.println("❌ Lỗi chuyển đổi tổng tiền: " + e.getMessage());
                response.sendRedirect(request.getContextPath() + "/quanly_donhang.jsp?error=invalid_amount");
                return;
            }

            String ngayDat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            bhp_Order order = new bhp_Order(0, tenKhachHang, sdt, diaChi, tongTien, ngayDat);

            boolean success = orderDAO.themDonHang(order);

            if (success) {
                response.sendRedirect(request.getContextPath() + "/quanly_donhang.jsp?success=1");
            } else {
                response.sendRedirect(request.getContextPath() + "/quanly_donhang.jsp?error=1");
            }
        } catch (Exception e) {
            System.err.println("❌ Lỗi xử lý đơn hàng: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/quanly_donhang.jsp?error=server_error");
        }
    }
}

package controller;

import dao.bhp_AppointmentDAO;
import model.bhp_Appointment;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/bhp_appointments")
public class bhp_AppointmentListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private bhp_AppointmentDAO appointmentDAO;

    public void init() {
        appointmentDAO = new bhp_AppointmentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            List<bhp_Appointment> listAppointment = appointmentDAO.listAllAppointments();
            request.setAttribute("appointments", listAppointment);
            request.getRequestDispatcher("bhp_appointments.jsp").forward(request, response);        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}

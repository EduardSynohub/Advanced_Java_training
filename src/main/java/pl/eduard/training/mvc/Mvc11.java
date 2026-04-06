package pl.eduard.training.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/mvc11")
public class Mvc11 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = req.getParameter("role");

        if (role != null && !role.isEmpty()) {
            req.setAttribute("userRole", "ROLE_" + role.toUpperCase());
        } else {
            req.setAttribute("userRole", "GUEST");
        }

        getServletContext().getRequestDispatcher("/jspFiles/role.jsp").forward(req, resp);
    }
}

package pl.eduard.training.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/mvc12")
public class Mvc12 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String startParam = req.getParameter("start");
        String endParam = req.getParameter("end");

        if (startParam != null && !startParam.isEmpty() && endParam != null && !endParam.isEmpty()) {
            int start = Integer.parseInt(startParam) + 10;
            int end = Integer.parseInt(endParam) + 10;

            req.setAttribute("start", start);
            req.setAttribute("end", end);
            getServletContext().getRequestDispatcher("/jspFiles/jsp2.jsp").forward(req, resp);
        }
    }
}

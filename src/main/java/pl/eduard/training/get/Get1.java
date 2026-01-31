package pl.eduard.training.get;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/get1")
public class Get1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startParam = req.getParameter("start");
        String endParam = req.getParameter("end");

        if (startParam == null && endParam == null) {
            resp.getWriter().append("BRAK");
            return;
        }

        int parseStart = Integer.parseInt(startParam);
        int parseEnd = Integer.parseInt(endParam);

        for (int i = parseStart; i <= parseEnd; i++) {
            resp.getWriter().append(String.valueOf(i)).append(" ");
        }
    }
}

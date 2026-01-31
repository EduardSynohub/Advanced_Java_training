package pl.eduard.training.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/servlet13")
public class Servlet13 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalTime localTime = LocalTime.now();
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Servlet13 - Lokal time</title></head>");
        out.println("<body>");
        out.println("<h1>Now is:</h1>");
        out.println("<p>" + localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}

package pl.eduard.training.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet14")
public class Servlet14 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String ipAddress = req.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = req.getRemoteAddr();
        }

        String browser = req.getHeader("User-Agent");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet14</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Information about client</h1>");
        out.println("<p>Address IP: " + ipAddress + "</p>");
        out.println("<p>Browser: " + browser + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}

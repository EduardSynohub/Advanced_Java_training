package pl.eduard.training.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/showAllCookies")
public class Cookie4Show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain; charset=UTF-8");

        Cookie[] cookies = req.getCookies();

        if (cookies == null) {
            resp.getWriter().write("This site don't have any cookies.");
        } else {
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out = resp.getWriter();

            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Cookie Name</th>");
            out.println("<th>Cookie Value</th>");
            out.println("<th>Delete?</th>");
            out.println("</tr>");

            for (Cookie c : cookies) {
                out.println("<tr>");
                out.println("<td>" + c.getName() + "</td>");
                out.println("<td>" + c.getValue() + "</td>");
                out.println("<td><a href='removeCookie?name=" + c.getName() + "'>Delete</a></td>");
                out.println("</tr>");
            }

            out.println("</table>");
        }

    }
}

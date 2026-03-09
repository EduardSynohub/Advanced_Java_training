package pl.eduard.training.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/countVisits")
public class Servlet34 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html; charset=UTF-8");

        boolean found = false;

        for (Cookie c : cookies) {
            if (c.getName().equals("visit")) {
                int count = Integer.parseInt(c.getValue());
                count++;
                c.setValue(String.valueOf(count));
                resp.addCookie(c);

                resp.getWriter().write(String.format("You visit this page %d times!", count));
                resp.getWriter().write("<br><a href='/countVisits'>Refresh this page</a>");

                found = true;
            }
        }

        if (!found) {
            Cookie visit = new Cookie("visit", "1");
            visit.setMaxAge(1440);
            resp.addCookie(visit);
            resp.getWriter().write("Welcome for the first time on our page.");
            resp.getWriter().write("<br><a href='/countVisits'>Refresh this page</a>");
        }
    }
}

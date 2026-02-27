package pl.eduard.training.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/showCookie")
public class Cookie1Get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain; charset=UTF-8");

        Cookie [] cookies = req.getCookies();
        String cookieName = "User";

        for (Cookie c : cookies) {
            if (cookieName.equals(c.getName())) {
                resp.getWriter().printf("Cookie name is '%s' and cookie value is '%s'", c.getName(), c.getValue());
            }
        }
    }
}

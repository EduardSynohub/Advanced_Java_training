package pl.eduard.training.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/removeCookie")
public class Cookie4Del extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookieNameParam = req.getParameter("name");

        Cookie [] cookies = req.getCookies();

        for (Cookie c : cookies) {
            if (cookieNameParam.equals(c.getName())) {
                c.setMaxAge(0);
                resp.addCookie(c);
            }
        }

        resp.sendRedirect("/showAllCookies");
    }
}

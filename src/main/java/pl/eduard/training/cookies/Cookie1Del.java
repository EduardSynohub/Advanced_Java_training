package pl.eduard.training.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteCookie")
public class Cookie1Del extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain; charset=UTF-8");

        Cookie [] cookies = req.getCookies();
        if (cookies == null) {
            resp.getWriter().write("This website don't have any cookies.");
        }

        String cookieName = "User";

        for (Cookie c : cookies) {
            if (cookieName.equals(c.getName())) {
                c.setMaxAge(0);
                resp.addCookie(c);
                resp.getWriter().write("Cookie 'User' successfully deleted");
            } else {
                resp.getWriter().write("Cookie 'User' doesn't exist");
            }
        }
    }
}

package pl.eduard.training.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie3")
public class Cookie3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookieNameParam = req.getParameter("key");
        String cookieValueParam = req.getParameter("value");
        String cookieTimeParam = req.getParameter("time");

        resp.setContentType("text/plain; charset=UTF-8");

        if (cookieNameParam == null || cookieNameParam.isBlank()) {
            resp.getWriter().write("Cookie name required");
            return;
        }

        Cookie cookie = new Cookie(cookieNameParam, cookieValueParam);
        int cookieLifetime = Integer.parseInt(cookieTimeParam);
        cookie.setMaxAge(cookieLifetime);
        resp.addCookie(cookie);

        resp.getWriter().write("You created a new cookie: " + cookie.getName() + " = " + cookie.getValue() + " and it will expire in " + cookie.getMaxAge() + " hours.");
    }
}

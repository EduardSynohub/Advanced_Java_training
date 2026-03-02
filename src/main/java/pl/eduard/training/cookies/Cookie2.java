package pl.eduard.training.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addToCookies")
public class Cookie2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookieNameParam = req.getParameter("key");
        String cookieValueParam = req.getParameter("value");

        resp.setContentType("text/plain; charset=UTF-8");

        if (cookieNameParam == null || cookieNameParam.isBlank()) {
            resp.getWriter().write("Cookie name required");
            return;
        }

        Cookie cookie = new Cookie(cookieNameParam, cookieValueParam);
        cookie.setMaxAge(300);
        resp.addCookie(cookie);

        resp.getWriter().write("You created a new cookie: " + cookie.getName() + " = " + cookie.getValue());
    }
}

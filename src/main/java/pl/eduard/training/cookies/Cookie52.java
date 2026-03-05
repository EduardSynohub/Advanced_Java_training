package pl.eduard.training.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/cookie52")
public class Cookie52 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        boolean cookieExists = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("cookie51".equals(c.getName())) {

                    cookieExists = true;

                    c.setMaxAge(0);
                    resp.addCookie(c);
                }
            }
        }

        if (cookieExists) {

            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<h2>Welcome to Cookie52</h2>");

        } else {

            String message = "FirstVisitCookie51";

            resp.sendRedirect("cookie51?msg=" +
                    URLEncoder.encode(message, "UTF-8"));
        }
    }
}

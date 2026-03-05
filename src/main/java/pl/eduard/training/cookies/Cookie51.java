package pl.eduard.training.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie51")
public class Cookie51 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String msg = req.getParameter("msg");

        if (msg != null) {
            out.println("<p>" + msg + "</p>");
        }

        Cookie cookie = new Cookie("cookie51", "visited");
        cookie.setMaxAge(60);
        resp.addCookie(cookie);

        out.println("<h2>Welcome to Cookie51</h2>");
        out.println("<a href='cookie52'>Go to Cookie52</a>");
    }
}

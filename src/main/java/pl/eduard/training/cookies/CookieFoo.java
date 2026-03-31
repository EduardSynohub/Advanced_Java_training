package pl.eduard.training.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/setCookieFoo")
public class CookieFoo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie foo = new Cookie("foo", "bar");
        foo.setMaxAge(60);
        resp.addCookie(foo);

        resp.sendRedirect("/jspFiles/fourth.jsp");
    }
}

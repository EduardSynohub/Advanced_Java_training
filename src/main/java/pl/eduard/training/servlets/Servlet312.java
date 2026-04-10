package pl.eduard.training.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/languageServlet")
public class Servlet312 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String lang = req.getParameter("lang");

        Cookie cookie = new Cookie("language", lang);
        cookie.setMaxAge(60);

        resp.addCookie(cookie);

        resp.sendRedirect("/languageSelect");
    }
}

package pl.eduard.training.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/post1")
public class Form1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userLastname = req.getParameter("userLastname");

        resp.setContentType("text/plain;charset=UTF-8");
        resp.getWriter().append("Welcome ")
                .append(userName)
                .append(" ")
                .append(userLastname);
    }
}

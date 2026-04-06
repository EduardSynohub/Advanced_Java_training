package pl.eduard.training.filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    private final static String USER = "admin";
    private final static String PASSWORD = "admin";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("jspFiles/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if (user.equals(USER) && pass.equals(PASSWORD)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", user);
            resp.sendRedirect("/admin");
        } else {
            if (!user.equals(USER)) {
                req.setAttribute("error", "Incorrect username!");
                req.getRequestDispatcher("jspFiles/login.jsp").forward(req, resp);
            } else if (!pass.equals(PASSWORD)){
                req.setAttribute("error", "Incorrect password!");
                req.getRequestDispatcher("jspFiles/login.jsp").forward(req, resp);
            }
        }
    }
}

package pl.eduard.training.sessions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session1Get")
public class Session1Get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        resp.setContentType("text/plain; charset=UTF-8");

        if (session.getAttribute("counter") == null) {
            resp.getWriter().write("EMPTY");
        } else {
            int counter = (int) session.getAttribute("counter") + 1;
            session.setAttribute("counter", counter);
            resp.getWriter().write("Session: counter = " + counter);
        }
    }
}

package pl.eduard.training.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addToSession")
public class Session3Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("htmlFiles/session3Add.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String keySessionParam = req.getParameter("key");
        String valueSessionParam = req.getParameter("value");

        List<String> values = new ArrayList<>();
        values.add(valueSessionParam);

        session.setAttribute(keySessionParam, valueSessionParam);

        List<String> keys = (List<String>) session.getAttribute("keys");

        if (keys == null) {
            keys = new ArrayList<>();
        }

        keys.add(keySessionParam);
        session.setAttribute("keys", keys);

        resp.sendRedirect("/showAllSessions");
    }
}

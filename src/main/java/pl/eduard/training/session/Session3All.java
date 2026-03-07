package pl.eduard.training.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showAllSessions")
public class Session3All extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession();

        List<String> keys = (List<String>) session.getAttribute("keys");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>Key</th>");
        out.println("<th>Value</th>");
        out.println("</tr>");

        if (keys != null) {
            for (String key : keys) {
                String value = (String) session.getAttribute(key);

                out.println("<tr>");
                out.println("<td>" + key + "</td>");
                out.println("<td>" + value + "</td>");
                out.println("</tr>");
            }
        }

        out.println("</table>");

        out.println("<br><a href='htmlFiles/session3Add.html'>Go back</a>");
    }
}

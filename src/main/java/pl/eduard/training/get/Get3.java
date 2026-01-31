package pl.eduard.training.get;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get3")
public class Get3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String widthParam = req.getParameter("width");
        String heightParam = req.getParameter("height");
        int width = 5;
        int height = 10;

        if (widthParam != null && !widthParam.isEmpty()) {
            width = Integer.parseInt(widthParam);
        }

        if (heightParam != null && !heightParam.isEmpty()) {
            height = Integer.parseInt(heightParam);
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Multiplication table</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Multiplication table</h1>");
        out.println("<table border='1'>");

        for (int i = 1; i <= height; i++) {
            out.println("<tr>");
            for (int j = 1; j <= width; j++) {
                out.println("<td>" + i + " * " + j + " = " + (i * j) + "</td>");
            }
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}

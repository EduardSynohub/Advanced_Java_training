package pl.eduard.training.get;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/get4")
public class Get4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String company = req.getParameter("company");
        String[] learn = req.getParameterValues("learn");

        if (company == null) {
            req.getRequestDispatcher("/htmlFiles/get4.html")
                    .forward(req, resp);
            return;
        }

        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().write("""
            <!DOCTYPE html>
            <html>
            <body>
                <h2>Company: %s</h2>
                <h3>Technologies:</h3>
                <ul>
        """.formatted(company));

        if (learn != null) {
            for (String tech : learn) {
                resp.getWriter().write("<li>" + tech + "</li>");
            }
        }

        resp.getWriter().write("""
                </ul>
                <a href="/get4">Back</a>
            </body>
            </html>
        """);
    }
}

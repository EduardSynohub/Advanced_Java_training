package pl.eduard.training.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/rememberMe")
public class Cookie36 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Cookie [] cookies = req.getCookies();
        boolean find = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("rememberUserName")) {
                    out.printf("Hello %s. Your data has been loaded from a cookie.", c.getValue());
                    find = true;
                }
            }
        }

        if (!find) {
            out.println("<html>");
            out.println("<body>");

            out.println("<form action='rememberMe' method='POST'>");
            out.println("Name: <input type='text' name='userName'><br><br>");
            out.println("<input type='checkbox' name='remember'> Remember me<br><br>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String remember = req.getParameter("remember");

        if (userName == null || userName.isEmpty()) {
            resp.getWriter().write("Name can not be empty.");
            return;
        }

        if (remember != null && !remember.isEmpty()) {
            Cookie rememberMeCookie = new Cookie("rememberUserName", userName);
            rememberMeCookie.setMaxAge(60);
            resp.addCookie(rememberMeCookie);

            resp.getWriter().write(String.format("Hello %s", userName));
        } else {
            resp.getWriter().write(String.format("Hello %s", userName));
        }
    }
}

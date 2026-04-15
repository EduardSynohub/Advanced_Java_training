package pl.eduard.training.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.eduard.training.DbUtil.DbUtil;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/newsletter")
public class Newsletter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        boolean showForm = true;

        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            if ("newsletterCookie".equals(c.getName())) {
                showForm = false;
            }
        }

        out.write("Czym jest Lorem Ipsum?<br>" +
                "Lorem Ipsum jest tekstem stosowanym" +
                " jako przykładowy wypełniacz w przemyśle poligraficznym. " +
                "Został po raz pierwszy użyty w XV w. przez nieznanego drukarza " +
                "do wypełnienia tekstem próbnej książki. " +
                "Pięć wieków później zaczął być używany " +
                "przemyśle elektronicznym, pozostając praktycznie niezmienionym. " +
                "Spopularyzował się w latach 60. XX w. wraz z publikacją arkuszy " +
                "Letrasetu, zawierających fragmenty Lorem Ipsum, a ostatnio z " +
                "zawierającym różne wersje Lorem Ipsum oprogramowaniem " +
                "przeznaczonym do realizacji druków na komputerach osobistych, " +
                "jak Aldus PageMaker");

        if (showForm) {
            out.write("<form method=\"post\" action=\"/newsletter\">\n" +
                    "  <br>" +
                    "  Please subscribe to the newsletter.\n" +
                    "  <br>\n" +
                    "  <br>\n" +
                    "  <label>\n" +
                    "    Email: <input type=\"email\" name=\"userEmail\" required/>\n" +
                    "  </label>\n" +
                    "  <br>\n" +
                    "  <label>\n" +
                    "    Name: <input type=\"text\" name=\"userName\" required/>\n" +
                    "  </label>\n" +
                    "  <br>\n" +
                    "  <br>\n" +
                    "  <label>\n" +
                    "    <button type=\"submit\">Submit</button>\n" +
                    "  </label>\n" +
                    "</form>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userEmail = req.getParameter("userEmail");
        String userName = req.getParameter("userName");

        DbUtil.saveUser(userEmail, userName);

        Cookie cookie = new Cookie("newsletterCookie", "24hour");
        cookie.setMaxAge(60*60*24);
        resp.addCookie(cookie);

        resp.sendRedirect("/newsletter");
    }
}

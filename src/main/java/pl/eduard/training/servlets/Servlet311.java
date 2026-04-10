package pl.eduard.training.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/languageSelect")
public class Servlet311 extends HttpServlet {
    private final Map<String, String> lang = new HashMap<>();

    @Override
    public void init() {
        lang.put("en", "Hello");
        lang.put("pl", "Cześć");
        lang.put("de", "Hallo");
        lang.put("es", "Hola");
        lang.put("fr", "Salut");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String selectedLang = "en";

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("language".equals(c.getName())) {
                    selectedLang = c.getValue();
                }
            }
        }

        String message = lang.getOrDefault(selectedLang, "Hello");

        out.println("<html><body>");

        out.println("<h2>" + message + "</h2>");

        out.println("<form method='POST' action='/languageServlet'>");
        out.println("Choose language: ");
        out.println("<select name='lang'>");
        for (String key : lang.keySet()) {
            out.println("<option value='" + key + "'>" + key + "</option>");
        }
        out.println("</select><br><br>");
        out.println("<button type='submit'>Select</button>");
        out.println("</form>");

        out.println("</body></html>");
    }
}

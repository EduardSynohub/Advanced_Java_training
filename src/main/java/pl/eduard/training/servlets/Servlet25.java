package pl.eduard.training.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@WebServlet("/servlet25")
public class Servlet25 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random random = new Random();
        List<Integer> integerList = new ArrayList<>();

        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().write("""
            <!DOCTYPE html>
            <html>
            <body>
            <table>
                <tr>
                <td>
        """);

        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(100);
            integerList.add(randomNumber);
            resp.getWriter().write(randomNumber + "<br>");
        }

        resp.getWriter().write("""
                </td>
                <td>
                </td>
                <td>
        """);

        Collections.sort(integerList);

        for (Integer n : integerList) {
            resp.getWriter().write(n + "<br>");
        }

        resp.getWriter().write("""
                </td>
                </tr>
                </table>
                </body>
            </html>
            """);
    }
}

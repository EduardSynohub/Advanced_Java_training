package pl.eduard.training.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/binaryNumbers")
public class Servlet32 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("htmlFiles/servlet32.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        String binary = req.getParameter("binary");

        if (binary == null || !binary.matches("[01]+")) {
            resp.getWriter().write("Invalid binary number!");
            return;
        }

        char[] binaryChars = binary.toCharArray();
        int decimalValue = 0;

        for (int i = binaryChars.length - 1; i >= 0; i--) {
            decimalValue += (int) (Integer.parseInt(String.valueOf(binaryChars[i])) * Math.pow(2, (binaryChars.length - i - 1)));
        }

        resp.getWriter().write(String.format("Binary number %s = decimal value %d", binary, decimalValue));
    }
}

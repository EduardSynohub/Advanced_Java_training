package pl.eduard.training.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/post5")
public class Form5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain; charset=UTF-8");

        String degreesParam = req.getParameter("degrees");
        String conversionType = req.getParameter("conversionType");

        if (degreesParam == null || degreesParam.isBlank()) {
            resp.getWriter().write("No temperature provided.");
            return;
        }

        double degrees;

        try {
            degrees = Double.parseDouble(degreesParam);
        } catch (NumberFormatException e) {
            resp.getWriter().write("Invalid number.");
            return;
        }

        double result;

        if ("celcToFahr".equals(conversionType)) {
            result = degrees * 9 / 5 + 32;
            resp.getWriter().printf("%.2f °C = %.2f °F", degrees, result);

        } else if ("fahrToCelc".equals(conversionType)) {
            result = (degrees - 32) * 5 / 9;
            resp.getWriter().printf("%.2f °F = %.2f °C", degrees, result);

        } else {
            resp.getWriter().write("Unknown conversion type.");
        }
    }
}

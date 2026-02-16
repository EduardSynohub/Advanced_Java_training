package pl.eduard.training.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

@WebServlet("/post4")
public class Form4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstParam = req.getParameter("firstCoefficient");
        String secondParam = req.getParameter("secondCoefficient");
        String thirdParam = req.getParameter("thirdCoefficient");
        Double firstCoefficient = null;
        Double secondCoefficient = null;
        Double thirdCoefficient = null;

        if (notNullAndNotBlank(firstParam)) {
            firstCoefficient = parseStringToDouble(firstParam, "Parse first coefficient error: ");

            if (firstCoefficient == 0) {
                resp.getWriter().write("Leading coefficient must be not equal 0! Try one more time.");
                return;
            }
        }

        if (notNullAndNotBlank(secondParam)) {
            secondCoefficient = parseStringToDouble(secondParam, "Parse second coefficient error: ");
        }

        if (notNullAndNotBlank(thirdParam)) {
            thirdCoefficient = parseStringToDouble(thirdParam, "Parse third coefficient error: ");
        }

        resp.getWriter().write("Your equation: " + firstCoefficient + "x^2 + " + secondCoefficient + "x + " + thirdCoefficient + " = 0\n");

        double discriminant = secondCoefficient * secondCoefficient - 4 * firstCoefficient * thirdCoefficient;

        if (discriminant > 0 ) {
            double x1 = BigDecimal.valueOf((-secondCoefficient - Math.sqrt(discriminant)) / (2 * firstCoefficient))
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            double x2 = BigDecimal.valueOf((-secondCoefficient + Math.sqrt(discriminant)) / (2 * firstCoefficient))
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            resp.getWriter().write("Discriminant is greater than 0.\n");
            resp.getWriter().write("Two real roots: " + x1 + ", " + x2);
        } else if (discriminant == 0) {
            double x = BigDecimal.valueOf(-secondCoefficient / (2 * firstCoefficient))
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            resp.getWriter().write("Discriminant is equal to 0.\n");
            resp.getWriter().write("Only one real root: " + x);
        } else {
            resp.getWriter().write("Discriminant is below 0. No real roots.");
        }
    }

    protected Double parseStringToDouble(String toParse, String message) {
        try {
            return Double.parseDouble(toParse);
        } catch (NumberFormatException e) {
            System.out.println(message + e.getMessage());
        }

        return null;
    }

    protected boolean notNullAndNotBlank(String toCheck) {
        return toCheck != null && !toCheck.isBlank();
    }
}

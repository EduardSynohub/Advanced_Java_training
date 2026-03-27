package pl.eduard.training.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet35")
public class Servlet35 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String firstNumberParam = req.getParameter("firstNumber");
        String secondNumberParam = req.getParameter("secondNumber");
        String thirdNumberParam = req.getParameter("thirdNumber");
        String forthNumberParam = req.getParameter("forthNumber");

        Double firstNumber = null;
        Double secondNumber = null;
        Double thirdNumber = null;
        Double forthNumber = null;

        if (notNullAndNotBlank(firstNumberParam)){
            firstNumber = parseStringToDouble(firstNumberParam, "First number parse error: ");
        }

        if (notNullAndNotBlank(secondNumberParam)){
            secondNumber = parseStringToDouble(secondNumberParam, "Second number parse error: ");
        }

        if (notNullAndNotBlank(thirdNumberParam)){
            thirdNumber = parseStringToDouble(thirdNumberParam, "Third number parse error: ");
        }

        if (notNullAndNotBlank(forthNumberParam)){
            forthNumber = parseStringToDouble(forthNumberParam, "Forth number parse error: ");
        }

        double sum = firstNumber + secondNumber + thirdNumber + forthNumber;
        double average = sum / 4.00;
        double mathProduct = firstNumber * secondNumber * thirdNumber * forthNumber;

        PrintWriter out = resp.getWriter();

        out.println("<h3>Numbers:</h3>");
        out.println("- " + firstNumber + "<br>");
        out.println("- " + secondNumber + "<br>");
        out.println("- " + thirdNumber + "<br>");
        out.println("- " + forthNumber + "<br>");

        out.println("<h3>Average:</h3>");
        out.println("- " + average + "<br>");

        out.println("<h3>Sum:</h3>");
        out.println("- " + sum + "<br>");

        out.println("<h3>Mathematical product:</h3>");
        out.println("- " + mathProduct + "<br>");
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

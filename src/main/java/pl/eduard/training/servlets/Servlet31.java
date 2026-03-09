package pl.eduard.training.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/currencyExchange")
public class Servlet31 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("htmlFiles/servlet31.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        double moneyAmountParam = Double.parseDouble(req.getParameter("moneyAmount"));
        String currencyParam = req.getParameter("currency");

        switch (currencyParam){
            case "eurToUsd":
                resp.getWriter().write(String.format("%.2f euro = %.2f dollars", moneyAmountParam, moneyAmountParam * 1.15));
                break;
            case "usdToEur":
                resp.getWriter().write(String.format("%.2f dollars = %.2f euro", moneyAmountParam, moneyAmountParam * 0.87));
                break;
            case "eurToPln":
                resp.getWriter().write(String.format("%.2f euro = %.2f polish zloty", moneyAmountParam, moneyAmountParam * 4.28));
                break;
            case "plnToEur":
                resp.getWriter().write(String.format("%.2f polish zloty = %.2f euro", moneyAmountParam, moneyAmountParam * 0.23));
                break;
            case "usdToPln":
                resp.getWriter().write(String.format("%.2f dollars = %.2f polish zloty", moneyAmountParam, moneyAmountParam * 3.71));
                break;
            case "plnToUsd":
                resp.getWriter().write(String.format("%.2f polish zloty = %.2f dollars", moneyAmountParam, moneyAmountParam * 0.27));
                break;
        }
    }
}

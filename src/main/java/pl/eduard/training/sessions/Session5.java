package pl.eduard.training.sessions;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/session5")
public class Session5 extends HttpServlet {

    private final Random random = new Random();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html; charset=UTF-8");

        int number1 = random.nextInt(101);
        int number2 = random.nextInt(101);

        int result = number1 + number2;

        HttpSession session = req.getSession();
        session.setAttribute("captcha", result);

        PrintWriter out = resp.getWriter();

        out.println("<h2>Form</h2>");
        out.println("<form method='POST' action='session5'>");

        out.println("First name: <input type='text' name='firstName'><br><br>");
        out.println("Last name: <input type='text' name='lastName'><br><br>");
        out.println("Email: <input type='text' name='email'><br><br>");

        out.println("<p>Enter sum of " + number1 + " and " + number2 + "</p>");

        out.println("<input type='number' name='captchaAnswer'><br><br>");

        out.println("<input type='submit' value='Send'>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html; charset=UTF-8");

        HttpSession session = req.getSession();

        Integer captcha = (Integer) session.getAttribute("captcha");

        String answerParam = req.getParameter("captchaAnswer");

        PrintWriter out = resp.getWriter();

        if (captcha == null) {
            out.println("Captcha session expired.");
            return;
        }

        try {
            int userAnswer = Integer.parseInt(answerParam);

            if (userAnswer == captcha) {
                out.println("<h2>Captcha correct!</h2>");
            } else {
                out.println("<h2>Captcha incorrect!</h2>");
            }

        } catch (NumberFormatException e) {
            out.println("<h2>Invalid captcha value.</h2>");
        }
    }
}
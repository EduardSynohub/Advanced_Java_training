package pl.eduard.training.sessions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/quiz")
public class Sess38 extends HttpServlet {
    static final String[][] CAPITOLS = {
            {"Germany", "Berlin"},
            {"Italy", "Rome"},
            {"France", "Paris"},
            {"Poland", "Warsaw"},
            {"Ukraine", "Kyiv"}
    };

    int correctAnswers = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int index = 0;

        HttpSession session = req.getSession(false);

        if (session != null) {
            index = (int) session.getAttribute("index");
        } else {
            session = req.getSession();
            session.setAttribute("index", index);
        }

        if (index <= 4) {
            out.println("<html>");
            out.println("<body>");

            if (session.getAttribute("answerResponse") != null) {
                out.println((String) session.getAttribute("answerResponse"));
                out.println("<br>");
                out.println("<br>");
            }

            out.println("<form action='quiz' method='POST'>");
            out.printf("Provide the capital for the country: %s <br> <input type='text' name='userAnswer'>", CAPITOLS[index][0]);
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("The quiz has ended.<br>");
            out.printf("Correct answers: %d", correctAnswers);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String answerResponse;

        HttpSession session = req.getSession();
        String answer = req.getParameter("userAnswer");

        int index = (int) session.getAttribute("index");

        if (index <= 4) {
            if (answer.equalsIgnoreCase(CAPITOLS[index][1])) {
                answerResponse = "It's correct answer.";
                correctAnswers++;
            } else {
                answerResponse = "It's incorrect answer.";
            }
            session.setAttribute("answerResponse", answerResponse);

            index++;
            session.setAttribute("index", index);

            resp.sendRedirect("/quiz");
        }
    }
}

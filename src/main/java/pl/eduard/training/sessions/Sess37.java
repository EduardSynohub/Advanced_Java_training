package pl.eduard.training.sessions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/math")
public class Sess37 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num1 = new Random().nextInt(20, 1000);
        int num2 = new Random().nextInt(20, 1000);
        HttpSession session = req.getSession();
        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<body>");

        out.println("<form action='math' method='POST'>");
        out.printf("%d + %d = <input type='number' step='1' name='addition'><br>", num1, num2);
        out.printf("%d - %d = <input type='number' step='1' name='subtraction'><br>", num1, num2);
        out.printf("%d * %d = <input type='number' step='1' name='multiplication'><br>", num1, num2);
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        HttpSession session = req.getSession();
        int num1 = (int) session.getAttribute("num1");
        int num2 = (int) session.getAttribute("num2");

        String additionParam = req.getParameter("addition");
        String subtractionParam = req.getParameter("subtraction");
        String multiplicationParam = req.getParameter("multiplication");

        if (notNullAndNotBlank(additionParam) && notNullAndNotBlank(subtractionParam) && notNullAndNotBlank(multiplicationParam)) {
            int addition = Integer.parseInt(additionParam);
            int subtraction = Integer.parseInt(subtractionParam);
            int multiplication = Integer.parseInt(multiplicationParam);

            if (num1 + num2 == addition) {
                resp.getWriter().println(printAnswer(num1, num2, addition, "Correct"));
            } else {
                resp.getWriter().println(printAnswer(num1, num2, addition, "Wrong"));
            }

            if (num1 - num2 == subtraction) {
                resp.getWriter().println(printAnswer(num1, num2, subtraction, "Correct"));
            } else {
                resp.getWriter().println(printAnswer(num1, num2, subtraction, "Wrong"));
            }

            if (num1 * num2 == multiplication) {
                resp.getWriter().println(printAnswer(num1, num2, multiplication, "Correct"));
            } else {
                resp.getWriter().println(printAnswer(num1, num2, multiplication, "Wrong"));
            }
        } else {
            resp.getWriter().write("<body> You must write an answer.<br> <a href='/math'>Go back</a> </body>");
        }
    }

    protected String printAnswer(int num1, int num2, int num3, String answer){
        return num1 + " + " + num2 + " = " + num3 + " " + answer + "<br>";
    }

    protected boolean notNullAndNotBlank(String toCheck) {
        return toCheck != null && !toCheck.isBlank();
    }
}

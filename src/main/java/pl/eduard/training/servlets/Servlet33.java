package pl.eduard.training.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet33")
public class Servlet33 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession sess = req.getSession();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Session form</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Session form</h2>");

        out.println("<form action='servlet33' method='POST'>");

        if (!sess.isNew()) {
            String input1Param = (String) sess.getAttribute("input1");
            String input2Param = (String) sess.getAttribute("input2");
            String input3Param = (String) sess.getAttribute("input3");
            String input4Param = (String) sess.getAttribute("input4");
            String input5Param = (String) sess.getAttribute("input5");

            out.println("Input 1: <input type='text' name='input1' value='" + input1Param + "'><br><br>");
            out.println("Input 2: <input type='text' name='input2' value='" + input2Param + "'><br><br>");
            out.println("Input 3: <input type='text' name='input3' value='" + input3Param + "'><br><br>");
            out.println("Input 4: <input type='text' name='input4' value='" + input4Param + "'><br><br>");
            out.println("Input 5: <input type='text' name='input5' value='" + input5Param + "'><br><br>");
        } else {
            out.println("Input 1: <input type='text' name='input1'><br><br>");
            out.println("Input 2: <input type='text' name='input2'><br><br>");
            out.println("Input 3: <input type='text' name='input3'><br><br>");
            out.println("Input 4: <input type='text' name='input4'><br><br>");
            out.println("Input 5: <input type='text' name='input5'><br><br>");
        }

        out.println("<input type='submit' value='Submit'>");

        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String input1 = req.getParameter("input1");
        String input2 = req.getParameter("input2");
        String input3 = req.getParameter("input3");
        String input4 = req.getParameter("input4");
        String input5 = req.getParameter("input5");

        HttpSession session = req.getSession();
        session.setAttribute("input1", input1);
        session.setAttribute("input2", input2);
        session.setAttribute("input3", input3);
        session.setAttribute("input4", input4);
        session.setAttribute("input5", input5);

        resp.getWriter().write("Form successfully sent. <br>");
        resp.getWriter().write("<a href='/servlet33'>Do you wanna try one more time?</a>");
    }
}

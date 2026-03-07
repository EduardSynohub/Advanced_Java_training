package pl.eduard.training.sessions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/session2")
public class Session2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("htmlFiles/session2.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String[] gradeParam = req.getParameterValues("grade");
        List<Double> newGrades = new ArrayList<>();

        for (String s : gradeParam) {
            newGrades.add(Double.parseDouble(s));
        }

        List<Double> currentGrades;
        if (session.getAttribute("grades") == null) {
            currentGrades = new ArrayList<>();
        } else {
            currentGrades = (List<Double>) session.getAttribute("grades");
        }

        currentGrades.addAll(newGrades);
        double average = BigDecimal.valueOf(calculatingAverage(currentGrades))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        session.setAttribute("grades", currentGrades);

        resp.getWriter().append("GRADES: ");
        resp.getWriter().append(Arrays.toString(currentGrades.toArray()));
        resp.getWriter().append("\n");
        resp.getWriter().append("AVERAGE: ");
        resp.getWriter().append(String.valueOf(average));
    }

    protected double calculatingAverage(List<Double> doubleList) {
        double sum = 0.0;
        for (double d : doubleList) {
            sum += d;
        }

        return (sum) / doubleList.size();
    }
}

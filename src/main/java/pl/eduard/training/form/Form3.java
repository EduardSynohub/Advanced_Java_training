package pl.eduard.training.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@WebServlet("/getForm3")
public class Form3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageParam = req.getParameter("page");

        if (!pageParam.equalsIgnoreCase("") && pageParam != null) {
            try {
                int intPage = Integer.parseInt(pageParam);
                List<Integer> integersDivisor = new ArrayList<>();

                if (intPage > 0) {
                    for (int i = 1; i * i <= intPage; i++) {
                        if (intPage % i == 0) {
                            integersDivisor.add(i);
                            if (i != intPage / i) {
                                integersDivisor.add(intPage / i);
                            }
                        }
                    }

                    Collections.sort(integersDivisor);
                    resp.getWriter().write(integersDivisor.toString());
                } else {
                    resp.getWriter().write("Number must be greater than 0 and less than " + Integer.MAX_VALUE);
                }
            } catch (NumberFormatException e) {
                System.out.println("Parse error: " + e.getMessage());
            }
        }
    }
}

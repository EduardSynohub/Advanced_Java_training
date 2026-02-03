package pl.eduard.training.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/servlet242")
public class Servlet242 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> products = new ArrayList<>(List.of(
                "Asus Transformer;2999.99",
                "iPhone 6;3499.18",
                "Converse Sneakers;125.00",
                "LG OLED55B6P OLED TV;6493.91",
                "Samsung HT-J4100;800.99",
                "Alpine Swiss Dress Belt;99.08",
                "60 Watt LED;1.50",
                "Arduino Nano;3.26"
        ));

        String idParam = req.getParameter("id");
        int id = -1;

        if (!idParam.isEmpty() && idParam != null) {
            id = Integer.parseInt(idParam);
        }

        if (id <= products.size() && id > 0) {
            String[] split = products.get(id - 1).split(";");
            resp.getWriter().append(split[0])
                    .append(" - ")
                    .append(split[1]);
        } else {
            resp.getWriter().append("Product not found!");
        }
    }
}

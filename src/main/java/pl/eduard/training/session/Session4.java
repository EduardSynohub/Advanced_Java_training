package pl.eduard.training.session;

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
import java.util.List;

@WebServlet("/session4")
public class Session4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        resp.setContentType("text/plain; charset=UTF-8");

        if (cart != null && !cart.isEmpty()) {
            double total = 0.0;
            for(CartItem ci : cart) {
                double sum = ci.getQuantity() * ci.getPrice();
                total += sum;
                resp.getWriter().write(String.format("%s - %d x %.2fzł = %.2fzł\n", ci.getName(), ci.getQuantity(), ci.getPrice(), sum));
            }
            resp.getWriter().write("SUM: " + BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP).doubleValue() + "zł");
        } else {
            resp.getWriter().write("Cart is empty.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain; charset=UTF-8");

        HttpSession session = req.getSession();
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cart");

        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }

        String productName = req.getParameter("productName");
        int productQuantity = Integer.parseInt(req.getParameter("quantity"));
        double productPrice = Double.parseDouble(req.getParameter("price"));

        if (productQuantity != 0) {
            CartItem newItem = new CartItem(productName, productQuantity, productPrice);
            cartItems.add(newItem);
            session.setAttribute("cart", cartItems);
        }

        resp.sendRedirect("htmlFiles/session4.html");
    }
}

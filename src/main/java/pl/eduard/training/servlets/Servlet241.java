package pl.eduard.training.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet241")
public class Servlet241 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("""
                <!DOCTYPE html>
                <html>
                <doby>
                    <h2><a href="http://localhost:8080/servlet242?id=1">Go to servlet242 with id 1</a>
                    <h2><a href="http://localhost:8080/servlet242?id=2">Go to servlet242 with id 2</a>
                    <h2><a href="http://localhost:8080/servlet242?id=3">Go to servlet242 with id 3</a>
                    <h2><a href="http://localhost:8080/servlet242?id=4">Go to servlet242 with id 4</a>
                    <h2><a href="http://localhost:8080/servlet242?id=5">Go to servlet242 with id 5</a>
                    <h2><a href="http://localhost:8080/servlet242?id=6">Go to servlet242 with id 6</a>
                    <h2><a href="http://localhost:8080/servlet242?id=7">Go to servlet242 with id 7</a>
                    <h2><a href="http://localhost:8080/servlet242?id=8">Go to servlet242 with id 8</a>
                </body>
                </html>
                """);
    }
}

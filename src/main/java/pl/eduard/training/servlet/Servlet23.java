package pl.eduard.training.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@WebServlet("/servlet23")
public class Servlet23 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("oop.txt");

        if (inputStream == null) {
            resp.getWriter().append("File not found.");
        } else {
            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                resp.getWriter().write(scanner.nextLine() + "\n");
            }

            scanner.close();
        }
    }
}

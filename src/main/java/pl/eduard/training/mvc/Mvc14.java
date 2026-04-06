package pl.eduard.training.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mvc14")
public class Mvc14 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("Harry Potter 1", "Rowling", 4563));
        bookList.add(new Book("Harry Potter 2", "Rowling", 4345));
        bookList.add(new Book("Harry Potter 3", "Rowling", 4958));

        req.setAttribute("bookList", bookList);
        getServletContext().getRequestDispatcher("/jspFiles/resultList.jsp").forward(req, resp);
    }
}

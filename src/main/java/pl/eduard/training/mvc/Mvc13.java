package pl.eduard.training.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/mvc13")
public class Mvc13 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String bookTitle = req.getParameter("title");
        String bookAuthor = req.getParameter("author");
        String isbnParam = req.getParameter("isbn");

        if (notNullAndNotEmpty(bookTitle) && notNullAndNotEmpty(bookAuthor) && notNullAndNotEmpty(isbnParam)) {
            int bookIsbn = Integer.parseInt(isbnParam);
            Book book = new Book(bookTitle, bookAuthor, bookIsbn);
            req.setAttribute("book", book);

            getServletContext().getRequestDispatcher("/jspFiles/result.jsp").forward(req, resp);
        } else {
            resp.getWriter().write("Book must have title, author and isbn. Try again: <br>" +
                    "<a href='jspFiles/jsp3.jsp'>Go back</a>");
        }
    }

    protected boolean notNullAndNotEmpty (String strToCheck) {
        return strToCheck != null && !strToCheck.isEmpty();
    }
}

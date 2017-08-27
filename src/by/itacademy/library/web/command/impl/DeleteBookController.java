package by.itacademy.library.web.command.impl;

import by.itacademy.library.entities.Book;
import by.itacademy.library.service.BookService;
import by.itacademy.library.service.impl.BookServiceImpl;
import by.itacademy.library.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project KR. Created by masiuk-l on 21.08.2017.
 */
public class DeleteBookController implements Controller {
    private BookService bookService = BookServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Book book = bookService.get(Integer.parseInt(req.getParameter("id")));
        if (book != null) {
            bookService.delete(book.getBookID());
        }
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/frontController?command=catalog");

    }
}

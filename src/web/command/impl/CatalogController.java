package web.command.impl;

import service.BookService;
import service.impl.BookServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CatalogController implements Controller {
    private BookService bookService = new BookServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("books", bookService.getAll());
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}

package web.command.impl;

import VO.BookVO;
import entities.Book;
import service.BookService;
import service.impl.BookServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookController implements Controller {

    private BookService bookService = new BookServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int bookID = Integer.parseInt(req.getParameter("bookID"));
        Book book = bookService.get(bookID);
        BookVO bookVO = bookService.getBookVO(book);
        req.getSession().setAttribute("book", bookVO);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}

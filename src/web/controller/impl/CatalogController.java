package web.controller.impl;

import VO.BookVO;
import entities.Book;
import service.BookService;
import service.impl.BookServiceImpl;
import web.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CatalogController implements Controller {
    private BookService bookService = new BookServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Book> books = new ArrayList<>(bookService.getAll());
        ArrayList<BookVO> bookVOS = new ArrayList<>();
        for (Book book : books) {
            BookVO bookVO = bookService.getBookVO(book);
            bookVOS.add(bookVO);
        }

        req.getSession().setAttribute("books", bookVOS);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}

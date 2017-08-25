package web.command.impl;

import entities.Book;
import entities.BookAuthor;
import service.AuthorService;
import service.BookAuthorService;
import service.BookService;
import service.impl.AuthorServiceImpl;
import service.impl.BookAuthorServiceImpl;
import service.impl.BookServiceImpl;
import web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookController implements Controller {
    private AuthorService authorService = AuthorServiceImpl.getInstance();
    private BookService bookService = BookServiceImpl.getInstance();
    private BookAuthorService bookAuthorService = BookAuthorServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getSession().setAttribute("authors", authorService.getAll());
        if (req.getMethod().equals("GET")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            dispatcher.forward(req, resp);
        } else {
            Book book = new Book();
            book.setName(req.getParameter("name"));
            book.setIsbn(req.getParameter("isbn"));
            book.setGenre(req.getParameter("genre"));
            book.setYear(Integer.parseInt(req.getParameter("year")));
            book.setQuantity(Integer.parseInt(req.getParameter("quantity")));
            book = bookService.save(book);
            String[] authorIDs = req.getParameterValues("author");
            for (String authorID : authorIDs) {
                BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setBookID(book.getBookID());
                bookAuthor.setAuthorID(Integer.parseInt(authorID));
                bookAuthorService.save(bookAuthor);
            }
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/frontController?command=catalog");
        }
    }
}

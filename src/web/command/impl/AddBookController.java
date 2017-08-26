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
import java.time.LocalDate;

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
            boolean validData = true;
            if (req.getParameter("name").matches("^.{1,29}$")) {
                book.setName(req.getParameter("name"));
            } else {
                validData = false;
            }
            if (req.getParameter("isbn").matches("^[0-9\\\\-]{1,12}$")) {
                book.setIsbn(req.getParameter("isbn"));
            } else {
                validData = false;
            }
            if (req.getParameter("genre").matches("^.{1,30}$")) {
                book.setGenre(req.getParameter("genre"));
            } else {
                validData = false;
            }
            int year;
            try {
                year = Integer.parseInt(req.getParameter("year"));
                if (year <= LocalDate.now().getYear() && year > 0) {
                    book.setYear(year);
                } else {
                    validData = false;
                }
            } catch (NumberFormatException e) {
                validData = false;
            }
            int quantity;
            try {
                quantity = Integer.parseInt(req.getParameter("quantity"));
                if (quantity <= 999 && quantity > 0) {
                    book.setQuantity(quantity);
                } else {
                    validData = false;
                }
            } catch (NumberFormatException e) {
                validData = false;
            }

            if (validData) {
                bookService.save(book);
                String[] authorIDs = req.getParameterValues("author");//todo допилить??
                for (String authorID : authorIDs) {
                    BookAuthor bookAuthor = new BookAuthor();
                    bookAuthor.setBookID(book.getBookID());
                    bookAuthor.setAuthorID(Integer.parseInt(authorID));
                    bookAuthorService.save(bookAuthor);
                }
                req.getSession().setAttribute("errorMsg", "");
                String contextPath = req.getContextPath();
                resp.sendRedirect(contextPath + "/frontController?command=catalog");
                return;
            } else {
                req.getSession().setAttribute("errorMsg", "Invalid data. Please, retry");
                RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
                dispatcher.forward(req, resp);
                return;
            }
        }
    }
}

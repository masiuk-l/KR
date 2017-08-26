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
import java.util.ArrayList;

public class EditBookController implements Controller {
    private BookService bookService = BookServiceImpl.getInstance();
    private AuthorService authorService = AuthorServiceImpl.getInstance();
    private BookAuthorService bookAuthorService = BookAuthorServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getMethod().equals("GET")) {
            int bookID = Integer.parseInt(req.getParameter("id"));
            Book book = bookService.get(bookID);
            req.getSession().setAttribute("bookVO", bookService.getBookVO(book));
            req.getSession().setAttribute("authors", authorService.getAll());
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            dispatcher.forward(req, resp);
            return;
        } else {
            int bookID = Integer.parseInt(req.getParameter("id"));
            Book oldBook = bookService.get(bookID);
            Book newBook = new Book();
            boolean validData = true;
            if (req.getParameter("name").matches("^.{1,29}$") || req.getParameter("name").length() == 0) {
                newBook.setName(req.getParameter("name"));
            } else {
                validData = false;
            }
            if (req.getParameter("isbn").matches("^[0-9\\\\-]{1,12}$") || req.getParameter("isbn").length() == 0) {
                newBook.setIsbn(req.getParameter("isbn"));
            } else {
                validData = false;
            }
            if (req.getParameter("genre").matches("^.{1,30}$") || req.getParameter("genre").length() == 0) {
                newBook.setGenre(req.getParameter("genre"));
            } else {
                validData = false;
            }
            int year;
            try {
                if (req.getParameter("year").length() == 0) {
                    newBook.setYear(0);
                } else {
                    year = Integer.parseInt(req.getParameter("year"));
                    if (year <= LocalDate.now().getYear() && year > 0) {
                        newBook.setYear(year);
                    } else {
                        validData = false;
                    }
                }

            } catch (NumberFormatException e) {
                validData = false;
            }
            int quantity;
            try {
                quantity = Integer.parseInt(req.getParameter("quantity"));
                if (quantity <= 999 && quantity > 0) {
                    newBook.setQuantity(quantity);
                } else {
                    validData = false;
                }
            } catch (NumberFormatException e) {
                validData = false;
            }

            if (validData) {
                bookService.update(oldBook, newBook);
                ArrayList<BookAuthor> bookAuthors = new ArrayList<>(bookAuthorService.getByBookID(oldBook));
                for (BookAuthor bookAuthor : bookAuthors) {
                    bookAuthorService.delete(bookAuthor.getBookAuthorID());
                }
                String[] authorIDs = req.getParameterValues("author");
                for (String authorID : authorIDs) {
                    BookAuthor bookAuthor = new BookAuthor();
                    bookAuthor.setBookID(oldBook.getBookID());
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
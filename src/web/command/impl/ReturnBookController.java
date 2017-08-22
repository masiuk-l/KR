package web.command.impl;

import entities.Book;
import entities.Form;
import entities.Reader;
import service.BookService;
import service.FormService;
import service.impl.BookServiceImpl;
import service.impl.FormServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ReturnBookController implements Controller {
    private BookService bookService = new BookServiceImpl();
    private FormService formService = new FormServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = bookService.get(Integer.parseInt(req.getParameter("bookID")));
        Form form = null;
        if (req.getSession().getAttribute("sreader") == null) {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/frontController?command=error");
        }
        int readerID = ((Reader) req.getSession().getAttribute("sreader")).getReaderID();
        AtomicInteger quantity = new AtomicInteger(book.getQuantity());
        int currentCount = quantity.incrementAndGet();
        book.setQuantity(currentCount);
        bookService.update(book);
        ArrayList<Form> forms = new ArrayList<>(formService.getByBook(book));
        for (Form f : forms) {
            if (f.getReaderID() == readerID)
                form = f;
        }
        if (form == null) {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/frontController?command=error");
        } else {
            formService.delete(form.getFormID());
        }
    }
}

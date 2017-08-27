package by.itacademy.library.web.command.impl;

import by.itacademy.library.entities.Book;
import by.itacademy.library.entities.Form;
import by.itacademy.library.entities.Reader;
import by.itacademy.library.service.BookService;
import by.itacademy.library.service.FormService;
import by.itacademy.library.service.impl.BookServiceImpl;
import by.itacademy.library.service.impl.FormServiceImpl;
import by.itacademy.library.web.command.Controller;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Project KR. Created by masiuk-l on 18.08.2017.
 */
public class ReserveBookController implements Controller {
    private BookService bookService = BookServiceImpl.getInstance();
    private FormService formService = FormServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = bookService.get(Integer.parseInt(req.getParameter("bookID")));

        AtomicInteger quantity = new AtomicInteger(book.getQuantity());
        int currentCount = quantity.decrementAndGet();
        book.setQuantity(currentCount);
        bookService.update(book);
        Form form = new Form();
        form.setBookID(book.getBookID());
        form.setReaderID(((Reader) req.getSession().getAttribute("sreader")).getReaderID());
        form.setLibrarianID(1);//todo ??
        form.setReceivalType("Абонемент");//todo ??
        form.setReceivalDate(LocalDate.now());
        form.setReturnDate(LocalDate.now().plus(14, ChronoUnit.DAYS));
        formService.save(form);
        PrintWriter writer = resp.getWriter();
        writer.print(new Gson().toJson(currentCount));
    }
}

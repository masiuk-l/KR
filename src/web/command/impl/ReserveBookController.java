package web.command.impl;

import com.google.gson.Gson;
import entities.Book;
import service.BookService;
import service.impl.BookServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

public class ReserveBookController implements Controller {
    private BookService bookService = new BookServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = bookService.get(Integer.parseInt(req.getParameter("bookID")));

        AtomicInteger quantity = new AtomicInteger(book.getQuantity());
        int currentCount = quantity.decrementAndGet();
        book.setQuantity(currentCount);
        bookService.update(book);
        PrintWriter writer = resp.getWriter();
        writer.print(new Gson().toJson(currentCount));
    }
}

package web.command.impl;

import service.ReaderService;
import service.impl.ReaderServiceImpl;
import web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorController implements Controller {
    ReaderService readerService = new ReaderServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        req.setAttribute("title", "error");
        dispatcher.forward(req, resp);
        return;
    }
}

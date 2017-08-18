package web.command.impl;

import service.ReaderService;
import service.impl.ReaderServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReadersController implements Controller {
    private ReaderService readerService = new ReaderServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("readers", readerService.getAll());
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}

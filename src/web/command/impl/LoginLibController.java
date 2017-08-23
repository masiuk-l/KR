package web.command.impl;

import entities.Librarian;
import service.LibrarianService;
import service.impl.LibrarianServiceImpl;
import web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginLibController implements Controller {
    LibrarianService librarianService = new LibrarianServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("loginlib");
        String password = req.getParameter("passwordlib");
        if (login == null || password == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            dispatcher.forward(req, resp);
            return;
        }
        Librarian librarian = librarianService.getByLogin(login);
//        if (librarian != null && librarian.getPassword().equals(Encoder.encode(password))) {
        if (librarian != null && password.equals(librarian.getPassword())) {
            req.getSession().setAttribute("slibrarian", librarian);
            req.getSession().setAttribute("errorMsg", "");
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/frontController?command=main");
            return;
        } else {
            req.getSession().setAttribute("errorMsg", "Invalid Login or Password");
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            dispatcher.forward(req, resp);
            return;
        }
    }
}

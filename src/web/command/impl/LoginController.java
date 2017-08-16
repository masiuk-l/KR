package web.command.impl;

import entities.Reader;
import service.ReaderService;
import service.impl.ReaderServiceImpl;
import web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements Controller {
    ReaderService readerService = new ReaderServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String surname = req.getParameter("surname");//TODO change to login
        String password = req.getParameter("password");
        if (surname == null || password == null) {
            resp.setHeader("errorMsg", "Invalid Login or Password");
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            req.setAttribute("title", "Login form");
            dispatcher.forward(req, resp);
            return;
        }
        Reader reader = readerService.getBySurname(surname).get(0);
//        if (reader != null && reader.getPassword().equals(Encoder.encode(password))) {
        if (reader != null && password.equals(reader.getPassword())) {
            req.getSession().setAttribute("reader", reader);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/frontController?command=readers");
            return;
        } else {
            resp.setHeader("errorMsg", "Invalid Login or Password");
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            req.setAttribute("title", "Login form");
            dispatcher.forward(req, resp);
            return;
        }
    }
}

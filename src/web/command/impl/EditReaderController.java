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
import java.time.LocalDate;

public class EditReaderController implements Controller {
    private ReaderService readerService = new ReaderServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getMethod().equals("GET")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            dispatcher.forward(req, resp);
            return;
        } else {
            Reader sessionReader = (Reader) req.getSession().getAttribute("sreader");
            Reader newReader = new Reader();
            newReader.setSurname(req.getParameter("surname"));
            newReader.setName(req.getParameter("name"));
            newReader.setSecondName(req.getParameter("secondname"));
            newReader.setEmail(req.getParameter("email"));
            newReader.setPassword(req.getParameter("password"));
            LocalDate date = LocalDate.parse(req.getParameter("birthday"));
            newReader.setBirthday(date);
            System.out.println(req.getParameter("gender"));
            newReader.setGender(req.getParameter("gender").equals("1") ? "male" : "female");
            System.out.println(newReader.getGender());
            readerService.update(sessionReader, newReader);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/frontController?command=main");
            return;
        }
    }
}

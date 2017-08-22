package web.command.impl;

import entities.Reader;
import service.ReaderService;
import service.impl.ReaderServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpController implements Controller {
    private ReaderService readerService = new ReaderServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Reader reader = new Reader();
        reader.setSurname(req.getParameter("surname"));
        reader.setName(req.getParameter("name"));
        reader.setSecondName(req.getParameter("secondName"));
        reader.setEmail(req.getParameter("email"));
        reader.setPassword(req.getParameter("password"));
        //reader.setBirthday(new Date());//todo трансформация даты!!!!!!!1
        reader.setGender(req.getParameter("gender").equals("1") ? "male" : "female");
        reader = readerService.save(reader);
    }
}

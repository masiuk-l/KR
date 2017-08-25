package web.command.impl;

import entities.Author;
import service.AuthorService;
import service.impl.AuthorServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class AddAuthorController implements Controller {
    private AuthorService authorService = AuthorServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Author author = new Author();
        author.setSurname(req.getParameter("surname"));
        author.setName(req.getParameter("name"));
        author.setSecondName(req.getParameter("secondname"));
        LocalDate date = LocalDate.parse(req.getParameter("birthday"));
        author.setBirthday(date);
        author.setCountry(req.getParameter("country"));
        authorService.save(author);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/frontController?command=addBook");
    }
}

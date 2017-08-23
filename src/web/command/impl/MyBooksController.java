package web.command.impl;

import VO.FormVO;
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

public class MyBooksController implements Controller {
    private BookService bookService = BookServiceImpl.getInstance();
    private FormService formService = FormServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("sreader") == null) {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/frontController?command=error");
        }
        Reader reader = (Reader) req.getSession().getAttribute("sreader");
        ArrayList<Form> forms = new ArrayList<>(formService.getByReader(reader));
        ArrayList<FormVO> formVOS = new ArrayList<>();
        for (Form form : forms) {
            FormVO formVO = formService.getFormVO(form);
            formVOS.add(formVO);
        }
        req.getSession().setAttribute("formVOS", formVOS);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}

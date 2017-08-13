package web;

import entities.Reader;
import service.ReaderService;
import service.impl.ReaderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@WebServlet(name = "SaveReaderServlet", urlPatterns = {"/saveReader"})
public class SaveReaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equals(request.getParameter("surname"), "") || Objects.equals(request.getParameter("name"), "") || Objects.equals(request.getParameter("secondName"), "")
                || Objects.equals(request.getParameter("birthday"), "") || Objects.equals(request.getParameter("email"), "")
                || Objects.equals(request.getParameter("password"), "") || Objects.equals(request.getParameter("gender"), "")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/save-reader.jsp");
            dispatcher.forward(request, response);
        } else {
            Reader reader = new Reader();
            reader.setSurname(request.getParameter("surname"));
            reader.setName(request.getParameter("name"));
            reader.setSecondName(request.getParameter("secondName"));
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date parsed = null;
            try {
                parsed = format.parse(request.getParameter("birthday"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Date sql = new java.sql.Date(parsed.getTime());
            reader.setBirthday(sql);
            reader.setEmail(request.getParameter("email"));
            reader.setPassword(request.getParameter("password"));
            reader.setGender(request.getParameter("gender"));
            ReaderService readerService = new ReaderServiceImpl();
            readerService.save(reader);
            response.sendRedirect("/library/success.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

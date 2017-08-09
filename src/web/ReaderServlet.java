package web;

import entity.Reader;
import service.ReaderService;
import service.impl.ReaderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ReaderServlet", urlPatterns = {"/readers"})
public class ReaderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReaderService readerService = new ReaderServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        List<Reader> readers = readerService.getAll();
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Readers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p><table border = \"1\">");
            for (Reader reader : readers) {

                out.println("<tr>");
                out.println("<td>");
                out.println(readers.size());
                out.println("</td>");
                out.println("<td>");
                out.println(reader.getName());
                out.println("</td>");
                out.println("<td>");
                out.println(reader.getSurname());
                out.println("</td>");
                out.println("<td>");
                out.println(reader.getSecondName());
                out.println("</td>");
                out.println("<td>");
                out.println(reader.getBirthday());
                out.println("</td>");
                out.println("</tr>");


            }
            out.println("</table></p>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}

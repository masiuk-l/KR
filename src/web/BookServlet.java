package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import dao.AuthorDAO;
import dao.impl.AuthorDAOImpl;
import entity.Author;

@WebServlet(name = "HelloServlet", urlPatterns = {"/books"})
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        AuthorDAO authorDAO = AuthorDAOImpl.getInstance();
        List<Author> authors = null;
        try {
            authors = authorDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Books</title>");
            out.println("</head>");
            out.println("<body>");
            for (Author author : authors) {
                out.println("<p>");
                out.println("<tr>");
                out.println("<td>");
                out.println(author);
                out.println("<td>");
                out.println("<td>");
                out.println("<td>");

                out.println("</td>");
                out.println("</tr>");

                out.println("</p>");
            }


            out.println("</body>");
            out.println("</html>");
        }
    }
}

package web.handlers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ErrorHandler", urlPatterns = "/errorHandler")
public class ErrorHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer statusCode = (Integer)
                request.getAttribute("javax.servlet.error.status_code");

        if (statusCode == 404)
            response.sendRedirect(request.getContextPath() + "/frontController?controller=404");
        else response.sendRedirect(request.getContextPath() + "/frontController?controller=error");

    }
}

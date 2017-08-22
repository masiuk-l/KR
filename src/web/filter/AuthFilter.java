package web.filter;

import web.command.enums.CommandType;
import web.handlers.RequestHandler;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/frontController"})
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        CommandType type = RequestHandler.getCommand(request);
        if (CommandType.RESERVE_BOOK_AJAX.equals(type)) {
            String contextPath = request.getContextPath();
            if ((session.getAttribute("sreader") == null)) {
                response.sendRedirect(contextPath + "/frontController?command=login");//todo не работает!
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

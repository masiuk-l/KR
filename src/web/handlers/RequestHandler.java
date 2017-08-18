package web.handlers;

import web.controller.enums.CommandType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static web.controller.enums.CommandType.READERS;

public class RequestHandler {
    public static CommandType getCommand(HttpServletRequest req) {
        String param = req.getParameter("controller");
        if (param == null && "".equals(param)) {
            param = "readers";
        }


        CommandType type = CommandType.getByPageName(param);
        req.setAttribute("title", type.getPageName());
        HttpSession session = req.getSession();
        String pageName = (String) session.getAttribute("pageName");
        if (pageName != null) {
            session.setAttribute("prevPage", pageName);
            session.setAttribute("pageName", type.getPageName());
            session.setAttribute("pagePath", type.getPagePath());
        } else {
            session.setAttribute("prevPage", type.getPageName());
            session.setAttribute("pageName", READERS.getPageName());
            session.setAttribute("pagePath", READERS.getPagePath());
        }

        return type;
    }
}

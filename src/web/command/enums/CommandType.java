package web.command.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import web.command.Controller;
import web.command.impl.*;

@Getter
@AllArgsConstructor
public enum CommandType {
    LOGIN("login.jsp", "Login", new LoginController()),
    LOGOUT("login.jsp", "Logout", new LogoutController()),
    CATALOG("catalog/main.jsp", "Catalog", new CatalogController()),
    READERS("readers/main.jsp", "Readers", new ReadersController()),
    NOT_FOUND("error/404.jsp", "404", new ErrorController()),
    ERROR("error/error.jsp", "Error", new ErrorController());

    private String pagePath;
    private String pageName;
    private Controller controller;

    public static CommandType getByPageName(String page) {
        for (CommandType type : CommandType.values()) {
            if (type.pageName.equalsIgnoreCase(page)) {
                return type;
            }
        }
        return READERS;
    }
}

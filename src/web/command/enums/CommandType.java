package web.command.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import web.command.Controller;
import web.command.impl.*;

@Getter
@AllArgsConstructor
public enum CommandType {

    CATALOG("catalog/main.jsp", "Catalog", new CatalogController()),
    BOOK("catalog/book.jsp", "Book", new BookController()),
    ERROR("error/error.jsp", "Error", new ErrorController()),
    LOGIN("login.jsp", "Login", new LoginController()),
    LOGOUT("login.jsp", "Logout", new LogoutController()),
    NOT_FOUND("error/404.jsp", "404", new ErrorController()),
    READER("readers/cabinet.jsp", "Cabinet", new ReaderController()),
    READERS("readers/main.jsp", "Readers", new ReadersController());



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

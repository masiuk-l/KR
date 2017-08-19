package web.command.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import web.command.Controller;
import web.command.impl.*;

@Getter
@AllArgsConstructor
public enum CommandType {

    CATALOG("catalog/main.jsp", "Catalog", "catalog.title", new CatalogController()),
    BOOK("catalog/book.jsp", "Book", "book.title", new BookController()),
    ERROR("error/error.jsp", "Error", "error.title", new ErrorController()),
    LOGIN("login.jsp", "Login", "login.title", new LoginController()),
    LOGOUT("login.jsp", "Logout", "logout.title", new LogoutController()),
    MAIN("main/main.jsp", "main", "library.title", new MainController()),
    NOT_FOUND("error/404.jsp", "404", "404.title", new ErrorController()),
    READER("readers/cabinet.jsp", "Cabinet", "cabinet.title", new ReaderController()),
    READERS("readers/main.jsp", "Readers", "readers.title", new ReadersController());



    private String pagePath;
    private String pageName;
    private String i18nKey;
    private Controller controller;

    public static CommandType getByPageName(String page) {
        for (CommandType type : CommandType.values()) {
            if (type.pageName.equalsIgnoreCase(page)) {
                return type;
            }
        }
        return MAIN;
    }
}

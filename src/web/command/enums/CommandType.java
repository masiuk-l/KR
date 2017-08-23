package web.command.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import web.command.Controller;
import web.command.impl.*;

@Getter
@AllArgsConstructor
public enum CommandType {

    CATALOG("catalog/main.jsp", "catalog", "catalog.title", new CatalogController()),
    BOOK("catalog/book.jsp", "book", "book.title", new BookController()),
    EDIT_READER("cabinet/editReader.jsp", "editreader", "editreader.title", new EditReaderController()),
    ERROR("error/error.jsp", "error", "error.title", new ErrorController()),
    LOGIN("login.jsp", "login", "login.title", new LoginController()),
    LOGOUT("", "logout", "logout.title", new LogoutController()),
    MAIN("main/main.jsp", "main", "library.title", new MainController()),
    MY_BOOKS("cabinet/myBooks.jsp", "mybooks", "mybooks.title", new MyBooksController()),
    NOT_FOUND("error/404.jsp", "404", "404.title", new ErrorController()),
    READER("readers/cabinet.jsp", "cabinet", "cabinet.title", new ReaderController()),
    READERS("readers/main.jsp", "readers", "readers.title", new ReadersController()),
    RESERVE_BOOK_AJAX("", "reserveBook", "", new ReserveBookController()),
    RETURN_BOOK_AJAX("", "returnBook", "", new ReturnBookController()),
    SIGN_UP("", "signup", "sigup.title", new SignUpController());



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

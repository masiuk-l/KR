package web.command.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import web.command.Controller;
import web.command.impl.LoginController;
import web.command.impl.LogoutController;
import web.command.impl.ReadersController;

@Getter
@AllArgsConstructor
public enum CommandType {
    LOGIN("login.jsp", "Login", new LoginController()),
    LOGOUT("login.jsp", "Logout", new LogoutController()),
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

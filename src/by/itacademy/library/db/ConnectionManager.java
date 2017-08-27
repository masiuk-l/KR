package by.itacademy.library.db;

import java.sql.Connection;

/**
 * Project KR. Created by masiuk-l on 20.08.2017.
 */
public class ConnectionManager {
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    public static Connection getConnection() throws DBException {
        try {
            if (tl.get() == null) {
                tl.set(DataSource.getInstance().getConnection());
            }
            return tl.get();
        } catch (Exception e) {
            throw new DBException("Ошибка получения соединения " + e.getMessage());
        }
    }
}

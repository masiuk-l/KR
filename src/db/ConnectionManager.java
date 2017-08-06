package db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Dell on 06.08.2017.
 */
public class ConnectionManager {
    final static Logger LOG = Logger.getLogger(ConnectionManager.class);

    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("url");
        String driver = resource.getString("driver");
        String user = resource.getString("user");
        String pass = resource.getString("password");
        try {
            Class.forName(driver).newInstance();
        } catch (ClassNotFoundException e) {
            throw new SQLException("Драйвер не загружен!");
        } catch (InstantiationException | IllegalAccessException e) {
            LOG.error(e);
        }
        return DriverManager.getConnection(url, user, pass);
    }
}

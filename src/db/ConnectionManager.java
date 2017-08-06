package db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
public class ConnectionManager {
    final static Logger LOG = Logger.getLogger(ConnectionManager.class);
    private static ConnectionManager connectionManager;
    private ComboPooledDataSource cpds;

    private ConnectionManager() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("url");
        String driver = resource.getString("driver");
        String user = resource.getString("user");
        String pass = resource.getString("password");
        cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            throw new DBException("Ошибка загрузка драйвера.");
        }
        cpds.setJdbcUrl(url);
        cpds.setUser(user);
        cpds.setPassword(pass);

    }

    public static ConnectionManager getInstance() throws SQLException {
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();
            return connectionManager;
        } else {
            return connectionManager;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }

}

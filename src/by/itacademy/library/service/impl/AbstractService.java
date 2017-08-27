package by.itacademy.library.service.impl;

import by.itacademy.library.db.ConnectionManager;
import by.itacademy.library.db.DBException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
public abstract class AbstractService {

    public void startTransaction() throws SQLException {
        getConnection().setAutoCommit(false);
    }

    public void commit() throws SQLException {
        getConnection().commit();
    }

    public Connection getConnection() {
        return ConnectionManager.getConnection();
    }

    public void rollback() {
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            throw new DBException("rollback error");
        }
    }
}

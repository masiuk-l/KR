package service.impl;

import db.ConnectionManager;

import java.sql.SQLException;


public abstract class AbstractService {

    public void startTransaction() throws SQLException {
        ConnectionManager.getInstance().getConnection().setAutoCommit(false);
    }

    public void commit() throws SQLException {
        ConnectionManager.getInstance().getConnection().commit();
    }
}

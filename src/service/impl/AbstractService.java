package service.impl;

import db.ConnectionManager;

import java.sql.SQLException;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
public abstract class AbstractService {

    public void startTransaction() throws SQLException {
        ConnectionManager.getInstance().getConnection().setAutoCommit(false);
    }

    public void commit() throws SQLException {
        ConnectionManager.getInstance().getConnection().commit();
    }
}

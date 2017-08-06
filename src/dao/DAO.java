package dao;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by Dell on 06.08.2017.
 */
public interface DAO<T> {

    T save(T t) throws SQLException;

    T get(Serializable id) throws SQLException;

    void update(T t) throws SQLException;

    int delete(Serializable id) throws SQLException;

}

package dao;

import entity.Reader;

import java.sql.SQLException;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
public interface ReaderDAO extends DAO<Reader> {

    List<Reader> getBySurname(String surname) throws SQLException;

    List<Reader> getAll() throws SQLException;

}

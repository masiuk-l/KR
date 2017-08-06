package dao;

import entity.Reader;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Dell on 06.08.2017.
 */
public interface ReaderDAO extends DAO<Reader> {

    Reader getReaderBySurname(String surname) throws SQLException;

    List<Reader> getAll() throws SQLException;

}

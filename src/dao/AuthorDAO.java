package dao;

import entity.Author;

import java.sql.SQLException;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
public interface AuthorDAO extends DAO<Author> {


    Author getReaderBySurname(String surname) throws SQLException;

    List<Author> getAll() throws SQLException;
}

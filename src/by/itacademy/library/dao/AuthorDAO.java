package by.itacademy.library.dao;

import by.itacademy.library.entities.Author;

import java.sql.SQLException;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
public interface AuthorDAO extends DAO<Author> {

    List<Author> getBySurname(String surname) throws SQLException;

}

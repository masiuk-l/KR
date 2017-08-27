package by.itacademy.library.dao;

import by.itacademy.library.entities.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 07.08.2017.
 */
public interface BookDAO extends DAO<Book> {

    List<Book> getByName(String name) throws SQLException;

    List<Book> getByIsbn(String isbn) throws SQLException;

    List<Book> getByGenre(String genre) throws SQLException;

}

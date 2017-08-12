package dao;

import entities.Author;
import entities.Book;
import entities.BookAuthor;

import java.sql.SQLException;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 07.08.2017.
 */
public interface BookAuthorDAO extends DAO<BookAuthor> {

    List<BookAuthor> getByAuthor(Author author) throws SQLException;

    List<BookAuthor> getByBook(Book book) throws SQLException;

    List<BookAuthor> getAll() throws SQLException;

}

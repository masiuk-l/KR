package dao.impl;

import dao.BookAuthorDAO;
import entities.Author;
import entities.Book;
import entities.BookAuthor;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 07.08.2017.
 */
public class BookAuthorDAOImpl implements BookAuthorDAO {


    @Override
    public BookAuthor save(BookAuthor bookAuthor) throws SQLException {
        return null;
    }

    @Override
    public BookAuthor get(Serializable id) throws SQLException {
        return null;
    }

    @Override
    public void update(BookAuthor bookAuthor) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }

    @Override
    public List<BookAuthor> getByAuthor(Author author) throws SQLException {
        return null;
    }

    @Override
    public List<BookAuthor> getByBook(Book book) throws SQLException {
        return null;
    }

    @Override
    public List<BookAuthor> getAll() throws SQLException {
        return null;
    }
}

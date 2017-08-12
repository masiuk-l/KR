package dao.impl;

import dao.BookDAO;
import entities.Book;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public List<Book> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<Book> getByName(String name) throws SQLException {
        return null;
    }

    @Override
    public Book save(Book book) throws SQLException {
        return null;
    }

    @Override
    public Book get(Serializable id) throws SQLException {
        return null;
    }

    @Override
    public void update(Book book) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }
}

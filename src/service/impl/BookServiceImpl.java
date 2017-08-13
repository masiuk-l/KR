package service.impl;

import dao.BookDAO;
import dao.impl.BookDAOImpl;
import entities.Book;
import service.BookService;
import service.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl extends AbstractService implements BookService {
    private BookDAO bookDAO = BookDAOImpl.getInstance();

    @Override
    public Book save(Book book) {
        try {
            if (book != null) {
                startTransaction();
                book = bookDAO.save(book);
                commit();
                return book;
            } else {
                throw new ServiceException("Book not defined");
            }
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating Book");
        }

    }

    @Override
    public Book get(Serializable id) {
        try {
            Book book;
            startTransaction();
            book = bookDAO.get(id);
            commit();
            return book;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error getting Book");
        }
    }

    @Override
    public void update(Book book) {
        try {
            startTransaction();
            bookDAO.update(book);
            commit();
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error updating Book");
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            startTransaction();
            int rows = bookDAO.delete(id);
            commit();
            return rows;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error deleting Book");
        }
    }

    @Override
    public List<Book> getByName(String name) {
        ArrayList<Book> books;
        try {
            startTransaction();
            books = new ArrayList<>(bookDAO.getByName(name));
            commit();
            return books;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Book");
        }
    }

    @Override
    public List<Book> getByIsbn(String isbn) {
        ArrayList<Book> books;
        try {
            startTransaction();
            books = new ArrayList<>(bookDAO.getByIsbn(isbn));
            commit();
            return books;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Book");
        }
    }

    @Override
    public List<Book> getByGenre(String genre) {
        ArrayList<Book> books;
        try {
            startTransaction();
            books = new ArrayList<>(bookDAO.getByGenre(genre));
            commit();
            return books;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Book");
        }
    }

    @Override
    public List<Book> getAll() {
        ArrayList<Book> books;
        try {
            startTransaction();
            books = new ArrayList<>(bookDAO.getAll());
            commit();
            return books;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Book");
        }
    }
}

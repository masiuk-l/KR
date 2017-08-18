package service.impl;

import dao.BookAuthorDAO;
import dao.impl.BookAuthorDAOImpl;
import entities.Author;
import entities.Book;
import entities.BookAuthor;
import service.BookAuthorService;
import service.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookAuthorServiceImpl extends AbstractService implements BookAuthorService {
    private BookAuthorDAO bookAuthorDAO = BookAuthorDAOImpl.getInstance();

    @Override
    public BookAuthor save(BookAuthor bookAuthor) {
        try {
            if (bookAuthor != null) {
                startTransaction();
                bookAuthor = bookAuthorDAO.save(bookAuthor);
                commit();
                return bookAuthor;
            } else {
                throw new ServiceException("BookAuthor not defined");
            }
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating BookAuthor", e);
        }

    }

    @Override
    public BookAuthor get(Serializable id) {
        try {
            BookAuthor bookAuthor;
            startTransaction();
            bookAuthor = bookAuthorDAO.get(id);
            commit();
            return bookAuthor;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error getting BookAuthor", e);
        }
    }

    @Override
    public void update(BookAuthor bookAuthor) {
        try {
            startTransaction();
            bookAuthorDAO.update(bookAuthor);
            commit();
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error updating BookAuthor", e);
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            startTransaction();
            int rows = bookAuthorDAO.delete(id);
            commit();
            return rows;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error deleting BookAuthor", e);
        }
    }

    @Override
    public List<BookAuthor> getByAuthorID(Author author) {
        ArrayList<BookAuthor> bookAuthors;
        try {
            startTransaction();
            bookAuthors = new ArrayList<>(bookAuthorDAO.getByAuthorID(author));
            commit();
            return bookAuthors;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding BookAuthor", e);
        }
    }

    @Override
    public List<BookAuthor> getByBookID(Book book) {
        ArrayList<BookAuthor> bookAuthors;
        try {
            startTransaction();
            bookAuthors = new ArrayList<>(bookAuthorDAO.getByBookID(book));
            commit();
            return bookAuthors;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding BookAuthor", e);
        }
    }

    @Override
    public List<BookAuthor> getAll() {
        ArrayList<BookAuthor> bookAuthors;
        try {
            startTransaction();
            bookAuthors = new ArrayList<>(bookAuthorDAO.getAll());
            commit();
            return bookAuthors;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding BookAuthor", e);
        }
    }
}


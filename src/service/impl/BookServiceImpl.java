package service.impl;

import VO.BookVO;
import VO.transfer.BookTransfer;
import dao.*;
import dao.impl.*;
import entities.*;
import service.BookService;
import service.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl extends AbstractService implements BookService {
    private BookDAO bookDAO = BookDAOImpl.getInstance();
    private ReaderDAO readerDAO = ReaderDAOImpl.getInstance();
    private AuthorDAO authorDAO = AuthorDAOImpl.getInstance();
    private FormDAO formDAO = FormDAOImpl.getInstance();
    private BookAuthorDAO bookAuthorDAO = BookAuthorDAOImpl.getInstance();

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
            throw new ServiceException("Error creating Book", e);
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
            throw new ServiceException("Error getting Book", e);
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
            throw new ServiceException("Error updating Book", e);
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
            throw new ServiceException("Error deleting Book", e);
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
            throw new ServiceException("Error finding Book", e);
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
            throw new ServiceException("Error finding Book", e);
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
            throw new ServiceException("Error finding Book", e);
        }
    }

    @Override
    public BookVO getBookVO(Book book) {
        try {
            startTransaction();
            List<BookAuthor> bookAuthors = new ArrayList<>(bookAuthorDAO.getByBookID(book));
            List<Author> authors = new ArrayList<>();
            for (BookAuthor bookAuthor : bookAuthors) {
                Author author = authorDAO.get(bookAuthor.getAuthorID());
                authors.add(author);
            }
            List<Form> forms = formDAO.getByBook(book);
            List<Reader> readers = new ArrayList<>();
            for (Form form : forms) {
                Reader reader = readerDAO.get(form.getReaderID());
                readers.add(reader);
            }
            BookVO bookVO = BookTransfer.toValueObject(book, readers, authors);
            commit();
            return bookVO;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating bookVO", e);
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
            throw new ServiceException("Error finding Book", e);
        }
    }
}

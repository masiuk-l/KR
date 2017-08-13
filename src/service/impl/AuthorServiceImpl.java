package service.impl;

import dao.AuthorDAO;
import dao.impl.AuthorDAOImpl;
import entities.Author;
import service.AuthorService;
import service.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorServiceImpl extends AbstractService implements AuthorService {
    private AuthorDAO authorDAO = AuthorDAOImpl.getInstance();

    @Override
    public Author save(Author author) {
        try {
            if (author != null) {
                startTransaction();
                author = authorDAO.save(author);
                commit();
                return author;
            } else {
                throw new ServiceException("Author not defined");
            }
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating Author");
        }

    }

    @Override
    public Author get(Serializable id) {
        try {
            Author author;
            startTransaction();
            author = authorDAO.get(id);
            commit();
            return author;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error getting Author");
        }
    }

    @Override
    public void update(Author author) {
        try {
            startTransaction();
            authorDAO.update(author);
            commit();
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error updating Author");
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            startTransaction();
            int rows = authorDAO.delete(id);
            commit();
            return rows;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error deleting Author");
        }
    }

    @Override
    public List<Author> getBySurname(String surname) {
        ArrayList<Author> authors;
        try {
            startTransaction();
            authors = new ArrayList<>(authorDAO.getBySurname(surname));
            commit();
            return authors;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Author");
        }
    }

    @Override
    public List<Author> getAll() {
        ArrayList<Author> authors;
        try {
            startTransaction();
            authors = new ArrayList<>(authorDAO.getAll());
            commit();
            return authors;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Author");
        }
    }
}

package service.impl;


import dao.LibrarianDAO;
import dao.impl.LibrarianDAOImpl;
import entities.Librarian;
import service.LibrarianService;
import service.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibrarianServiceImpl extends AbstractService implements LibrarianService {
    private LibrarianDAO librarianDAO = LibrarianDAOImpl.getInstance();

    @Override
    public Librarian save(Librarian librarian) {
        try {
            if (librarian != null) {
                startTransaction();
                librarian = librarianDAO.save(librarian);
                commit();
                return librarian;
            } else {
                throw new ServiceException("Librarian not defined");
            }
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating Librarian", e);
        }

    }

    @Override
    public Librarian get(Serializable id) {
        try {
            Librarian librarian;
            startTransaction();
            librarian = librarianDAO.get(id);
            commit();
            return librarian;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error getting Librarian", e);
        }
    }

    @Override
    public void update(Librarian librarian) {
        try {
            startTransaction();
            librarianDAO.update(librarian);
            commit();
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error updating Librarian", e);
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            startTransaction();
            int rows = librarianDAO.delete(id);
            commit();
            return rows;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error deleting Librarian", e);
        }
    }

    @Override
    public List<Librarian> getBySurname(String surname) {
        ArrayList<Librarian> librarians;
        try {
            startTransaction();
            librarians = new ArrayList<>(librarianDAO.getBySurname(surname));
            commit();
            return librarians;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Librarian", e);
        }
    }

    @Override
    public List<Librarian> getAll() {
        ArrayList<Librarian> librarians;
        try {
            startTransaction();
            librarians = new ArrayList<>(librarianDAO.getAll());
            commit();
            return librarians;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Librarian", e);
        }
    }
}

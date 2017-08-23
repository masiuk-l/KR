package dao;

import entities.Librarian;

import java.sql.SQLException;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 07.08.2017.
 */
public interface LibrarianDAO extends DAO<Librarian> {

    List<Librarian> getBySurname(String surname) throws SQLException;

    List<Librarian> getByLogin(String login) throws SQLException;
}

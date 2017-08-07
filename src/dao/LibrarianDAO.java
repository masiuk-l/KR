package dao;

import entity.Librarian;

import java.sql.SQLException;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 07.08.2017.
 */
public interface LibrarianDAO extends DAO<Librarian> {

    List<Librarian> getAll() throws SQLException;

    List<Librarian> getBySurame(String Surname) throws SQLException;
}

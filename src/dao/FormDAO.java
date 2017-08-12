package dao;

import entities.Book;
import entities.Form;
import entities.Librarian;
import entities.Reader;

import java.sql.SQLException;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 07.08.2017.
 */
public interface FormDAO extends DAO<Form> {

    List<Form> getAll() throws SQLException;

    List<Form> getByReader(Reader reader) throws SQLException;

    List<Form> getByLibrarian(Librarian librarian) throws SQLException;

    List<Form> getByBook(Book book) throws SQLException;

    List<Form> getByReceivalType(String receivalType) throws SQLException;

}
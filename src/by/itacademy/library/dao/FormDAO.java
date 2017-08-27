package by.itacademy.library.dao;

import by.itacademy.library.entities.Book;
import by.itacademy.library.entities.Form;
import by.itacademy.library.entities.Librarian;
import by.itacademy.library.entities.Reader;

import java.sql.SQLException;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 07.08.2017.
 */
public interface FormDAO extends DAO<Form> {

    List<Form> getByReader(Reader reader) throws SQLException;

    List<Form> getByLibrarian(Librarian librarian) throws SQLException;

    List<Form> getByBook(Book book) throws SQLException;

    List<Form> getByReceivalType(String receivalType) throws SQLException;

}

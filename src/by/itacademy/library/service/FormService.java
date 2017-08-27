package by.itacademy.library.service;

import by.itacademy.library.VO.FormVO;
import by.itacademy.library.entities.Book;
import by.itacademy.library.entities.Form;
import by.itacademy.library.entities.Librarian;
import by.itacademy.library.entities.Reader;

import java.io.Serializable;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 15.08.2017.
 */
public interface FormService {
    Form save(Form form);

    Form get(Serializable id);

    void update(Form form);

    int delete(Serializable id);

    List<Form> getByReader(Reader reader);

    List<Form> getByLibrarian(Librarian librarian);

    List<Form> getByBook(Book book);

    List<Form> getByReceivalType(String receivalType);

    FormVO getFormVO(Form form);

    List<Form> getAll();
}

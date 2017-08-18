package service;

import VO.FormVO;
import entities.Book;
import entities.Form;
import entities.Librarian;
import entities.Reader;

import java.io.Serializable;
import java.util.List;

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

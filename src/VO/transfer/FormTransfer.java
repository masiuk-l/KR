package VO.transfer;

import VO.FormVO;
import entities.Book;
import entities.Form;
import entities.Librarian;
import entities.Reader;

public class FormTransfer {
    public static FormVO toValueObject(Form form, Book book, Librarian librarian, Reader reader) {
        FormVO formVO = new FormVO();
        formVO.setForm(form);
        formVO.setBook(book);
        formVO.setLibrarian(librarian);
        formVO.setReader(reader);
        return formVO;
    }

    public static Form toEntity(FormVO formVO) {
        Form form = formVO.getForm();
        return form;
    }
}

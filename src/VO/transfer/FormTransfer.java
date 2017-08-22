package VO.transfer;

import VO.BookVO;
import VO.FormVO;
import entities.Form;
import entities.Librarian;
import entities.Reader;

public class FormTransfer {
    public static FormVO toValueObject(Form form, BookVO bookVO, Librarian librarian, Reader reader) {
        FormVO formVO = new FormVO();
        formVO.setForm(form);
        formVO.setBookVO(bookVO);
        formVO.setLibrarian(librarian);
        formVO.setReader(reader);
        return formVO;
    }

    public static Form toEntity(FormVO formVO) {
        Form form = formVO.getForm();
        return form;
    }
}

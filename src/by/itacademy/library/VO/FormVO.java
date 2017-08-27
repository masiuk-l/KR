package by.itacademy.library.VO;

import by.itacademy.library.entities.Form;
import by.itacademy.library.entities.Librarian;
import by.itacademy.library.entities.Reader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project KR. Created by masiuk-l on 17.08.2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FormVO {
    private Form form;
    private Reader reader;
    private Librarian librarian;
    private BookVO bookVO;
}

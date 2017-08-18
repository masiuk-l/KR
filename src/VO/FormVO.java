package VO;

import entities.Book;
import entities.Form;
import entities.Librarian;
import entities.Reader;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FormVO {
    private Form form;
    private Reader reader;
    private Librarian librarian;
    private Book book;
}

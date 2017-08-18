package VO;

import entities.Author;
import entities.Book;
import entities.Reader;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BookVO {
    private Book book;
    private List<Author> authors = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();
}

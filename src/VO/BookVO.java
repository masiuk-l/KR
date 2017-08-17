package VO;

import entities.Author;
import entities.Reader;
import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BookVO {
    private int bookID;
    private String name;
    private String isbn;
    private String genre;
    private int year;
    private int quantity;
    private ArrayList<Author> authors = new ArrayList<>();
    private ArrayList<Reader> readers = new ArrayList<>();
}

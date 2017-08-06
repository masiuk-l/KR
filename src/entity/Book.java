package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Dell on 06.08.2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    int bookID;
    String name;
    String isbn;
    String genre;
    int year;
    int quantity;
}

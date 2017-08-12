package entities;

import lombok.*;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BookAuthor {
    private int bookAuthorID;
    private int authorID;
    private int bookID;
}

package entities;

import lombok.*;

import java.sql.Date;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Form {
    private int formID;
    private int bookID;
    private int readerID;
    private int librarianID;
    private String receivalType;
    private Date receivalDate;
    private Date returnDate;
}

package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Form {
    int formID;
    int bookID;
    int readerID;
    int librarianID;
    String receivalType;
    Date receivalDate;
    Date returnDate;
}

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
public class Author {
    int authorID;
    String name;
    String surname;
    String secondName;
    int year;
    String country;
}

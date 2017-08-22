package entities;

import lombok.*;

import java.time.LocalDate;


/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Author {
    private int authorID;
    private String name;
    private String surname;
    private String secondName;
    private LocalDate birthday;
    private String country;
}

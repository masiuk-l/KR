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
public class Reader {
    private int readerID;
    private String name;
    private String surname;
    private String secondName;
    private LocalDate birthday;
    private String password;
    private String email;
    private String gender;
    private String status;
}

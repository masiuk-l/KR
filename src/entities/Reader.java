package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    private int readerID;
    private String name;
    private String surname;
    private String secondName;
    private Date birthday;
    private String password;
    private String email;
    private String gender;
    private String status;
}

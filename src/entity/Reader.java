package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


/**
 * Created by Dell on 06.08.2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    int readerID;
    String name;
    String surname;
    String secondName;
    Date birthday;
}

package by.itacademy.library.dao.impl;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */

public abstract class AbstractDAO {
    public Date toSQLDate(LocalDate localDate) {
        LocalDateTime localDateTime = localDate.atStartOfDay();
        return new Date(localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    public LocalDate toLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}

import dao.ReaderDAO;
import dao.impl.ReaderDAOImpl;
import db.ConnectionManager;
import entity.Reader;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * Created by Dell on 06.08.2017.
 */
public class ReaderDAOImplTest {

    @Test
    public void saveAndGetBySurname() throws Exception {
        ReaderDAO readerDAO = ReaderDAOImpl.getInstance();
        Connection conn = ConnectionManager.getInstance().getConnection();
        conn.setAutoCommit(false);
        Reader reader = new Reader();
        reader.setName("Иван");
        reader.setSecondName("Иванович");
        reader.setSurname("Иванов");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(1976, 11, 27);
        reader.setBirthday(new Date(calendar.getTimeInMillis()));
        readerDAO.save(reader);
        Reader newReader = readerDAO.getReaderBySurname("Иванов");
        Assert.assertEquals(reader.getName(), newReader.getName());
        conn.rollback();
    }


    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }


    @Test
    public void getAll() throws Exception {

    }

}
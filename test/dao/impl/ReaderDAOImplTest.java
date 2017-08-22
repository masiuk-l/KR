package dao.impl;

import dao.ReaderDAO;
import entities.Reader;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
public class ReaderDAOImplTest {

    @Test
    public void saveAndGetBySurname() throws Exception {
        ReaderDAO readerDAO = ReaderDAOImpl.getInstance();
        Reader reader = new Reader();
        reader.setName("Иван");
        reader.setSecondName("Иванович");
        reader.setSurname("Козлов");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(1976, Calendar.NOVEMBER, 27);
        //reader.setBirthday(new Date(calendar.getTimeInMillis()));
        reader.setEmail("ffr@ww");
        reader.setPassword("fvfdcsdv");
        reader.setGender("женский");
        reader.setStatus("");
        reader = readerDAO.save(reader);
        Reader newReader = readerDAO.getBySurname("Козлов").get(0);
        Assert.assertEquals(reader.toString(), newReader.toString());
        readerDAO.delete(reader.getReaderID());
    }


    @Test
    public void getAndUpdate() throws Exception {
        ReaderDAO readerDAO = ReaderDAOImpl.getInstance();
        Reader reader = new Reader();
        reader.setName("Иван");
        reader.setSecondName("Иванович");
        reader.setSurname("Иванов");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(1976, Calendar.NOVEMBER, 27);
        //reader.setBirthday(new Date(calendar.getTimeInMillis()));
        reader.setEmail("ffr@ww");
        reader.setPassword("fvfdcsdv");
        reader.setGender("женский");
        reader.setStatus("");
        readerDAO.save(reader);
        String newSurname = "Иванова";
        reader = readerDAO.getBySurname("Иванов").get(0);
        reader.setSurname(newSurname);
        readerDAO.update(reader);
        Reader newReader = readerDAO.get(reader.getReaderID());
        Assert.assertTrue(reader.equals(newReader));
        readerDAO.delete(reader.getReaderID());
    }

    @Test
    public void getAllAndDelete() throws Exception {
        ReaderDAO readerDAO = ReaderDAOImpl.getInstance();
        Reader reader = new Reader();
        reader.setName("Иван");
        reader.setSecondName("Иванович");
        reader.setSurname("Иванов");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(1976, Calendar.NOVEMBER, 27);
        reader.setBirthday(LocalDate.now());
        reader.setEmail("ffr@ww");
        reader.setPassword("fvfdcsdv");
        reader.setGender("женский");
        reader.setStatus("");
        readerDAO.save(reader);
        //проверка работы c датой
        reader = readerDAO.getBySurname("Иванов").get(0);
        System.out.println(reader);
        //
        List<Reader> readers = readerDAO.getAll();
        int oldSize = readers.size();
        readerDAO.delete(reader.getReaderID());
        readers = readerDAO.getAll();
        Assert.assertEquals(oldSize - 1, readers.size());
    }
}
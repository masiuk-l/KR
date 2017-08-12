package dao.impl;

import dao.AuthorDAO;
import entities.Author;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class AuthorDAOImplTest {


    @Test
    public void saveAndGetBySurname() throws Exception {
        AuthorDAO authorDAO = AuthorDAOImpl.getInstance();
        Author author = new Author();
        author.setName("Иван");
        author.setSecondName("Иванович");
        author.setSurname("Иванов");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(1976, Calendar.NOVEMBER, 27);
        author.setBirthday(new Date(calendar.getTimeInMillis()));
        author.setCountry("Россия");
        authorDAO.save(author);
        Author newAuthor = authorDAO.getBySurname("Иванов").get(0);
        Assert.assertEquals(author.getName(), newAuthor.getName());
        authorDAO.delete(newAuthor.getAuthorID());
    }


    @Test
    public void getAndUpdate() throws Exception {
        AuthorDAO authorDAO = AuthorDAOImpl.getInstance();
        Author author = authorDAO.get(1);
        String oldSurname = author.getSurname();
        String newSurname = "Иванова";
        author.setSurname(newSurname);
        authorDAO.update(author);
        Author newAuthor = authorDAO.get(author.getAuthorID());
        Assert.assertEquals(newAuthor.getSurname(), newSurname);
        newAuthor.setSurname(oldSurname);
        authorDAO.update(newAuthor);
    }

    @Test
    public void getAllAndDelete() throws Exception {
        AuthorDAO authorDAO = AuthorDAOImpl.getInstance();
        Author author = new Author();
        author.setName("Иван");
        author.setSecondName("Иванович");
        author.setSurname("Иванов");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(1976, Calendar.NOVEMBER, 27);
        author.setBirthday(new Date(calendar.getTimeInMillis()));
        author.setCountry("Россия");
        authorDAO.save(author);
        List<Author> authors = authorDAO.getAll();
        int oldSize = authors.size();
        authorDAO.delete(author.getAuthorID());
        authors = authorDAO.getAll();
        Assert.assertEquals(oldSize - 1, authors.size());
    }
}
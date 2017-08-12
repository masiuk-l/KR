package dao.impl;

import dao.BookDAO;
import entities.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BookDAOImplTest {
    @Test
    public void saveAndGetBySurname() throws Exception {
        BookDAO bookDAO = BookDAOImpl.getInstance();
        Book book = new Book();
        book.setName("Книга");
        book.setIsbn("03293849310");
        book.setGenre("Роман");
        book.setYear(1996);
        book.setQuantity(42);
        bookDAO.save(book);
        Book newBook = bookDAO.getByName("Книга").get(0);
        Assert.assertTrue(book.equals(newBook));
        bookDAO.delete(newBook.getBookID());
    }


    @Test
    public void getAndUpdate() throws Exception {
        BookDAO bookDAO = BookDAOImpl.getInstance();
        Book book = new Book();
        book.setName("Книга");
        book.setIsbn("03293849310");
        book.setGenre("Роман");
        book.setYear(1996);
        book.setQuantity(42);
        bookDAO.save(book);
        book = bookDAO.getByName("Книга").get(0);
        book.setName("Не книга");
        bookDAO.update(book);
        Book newBook = bookDAO.get(book.getBookID());
        Assert.assertTrue(book.equals(newBook));
        bookDAO.delete(book.getBookID());
    }

    @Test
    public void getAllAndDelete() throws Exception {
        BookDAO bookDAO = BookDAOImpl.getInstance();
        Book book = new Book();
        book.setName("Книга");
        book.setIsbn("03293849310");
        book.setGenre("Роман");
        book.setYear(1996);
        book.setQuantity(42);
        bookDAO.save(book);
        List<Book> books = bookDAO.getAll();
        int oldSize = books.size();
        bookDAO.delete(book.getBookID());
        books = bookDAO.getAll();
        Assert.assertEquals(oldSize - 1, books.size());
    }
}
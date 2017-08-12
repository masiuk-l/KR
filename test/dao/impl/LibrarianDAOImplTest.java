package dao.impl;

import dao.LibrarianDAO;
import entities.Librarian;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LibrarianDAOImplTest {
    @Test
    public void saveAndGetBySurname() throws Exception {
        LibrarianDAO librarianDAO = LibrarianDAOImpl.getInstance();
        Librarian librarian = new Librarian();
        librarian.setName("Иван");
        librarian.setSecondName("Иванович");
        librarian.setSurname("Иванов");
        librarian.setEmail("ffr@ww");
        librarian.setPassword("fvfdcsdv");
        librarian = librarianDAO.save(librarian);
        Librarian newLibrarian = librarianDAO.getBySurname("Иванов").get(0);
        Assert.assertTrue(librarian.equals(newLibrarian));
        librarianDAO.delete(newLibrarian.getLibrarianID());
    }


    @Test
    public void getAndUpdate() throws Exception {
        LibrarianDAO librarianDAO = LibrarianDAOImpl.getInstance();
        Librarian librarian = new Librarian();
        librarian.setName("Иван");
        librarian.setSecondName("Иванович");
        librarian.setSurname("Иванов");
        librarian.setEmail("ffr@ww");
        librarian.setPassword("fvfdcsdv");
        librarianDAO.save(librarian);
        String newSurname = "Иванова";
        librarian = librarianDAO.getBySurname("Иванов").get(0);
        librarian.setSurname(newSurname);
        librarianDAO.update(librarian);
        Librarian newLibrarian = librarianDAO.get(librarian.getLibrarianID());
        Assert.assertTrue(librarian.equals(newLibrarian));
        librarianDAO.delete(librarian.getLibrarianID());
    }

    @Test
    public void getAllAndDelete() throws Exception {
        LibrarianDAO librarianDAO = LibrarianDAOImpl.getInstance();
        Librarian librarian = new Librarian();
        librarian.setName("Иван");
        librarian.setSecondName("Иванович");
        librarian.setSurname("Иванов");
        librarian.setEmail("ffr@ww");
        librarian.setPassword("fvfdcsdv");
        librarianDAO.save(librarian);
        List<Librarian> librarians = librarianDAO.getAll();
        int oldSize = librarians.size();
        librarianDAO.delete(librarian.getLibrarianID());
        librarians = librarianDAO.getAll();
        Assert.assertEquals(oldSize - 1, librarians.size());
    }

}
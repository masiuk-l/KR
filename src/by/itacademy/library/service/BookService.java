package by.itacademy.library.service;

import by.itacademy.library.VO.BookVO;
import by.itacademy.library.entities.Book;

import java.io.Serializable;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 15.08.2017.
 */
public interface BookService {
    Book save(Book book);

    Book get(Serializable id);

    void update(Book book);

    void update(Book oldBook, Book newBook);

    int delete(Serializable id);

    List<Book> getByName(String name);

    List<Book> searchByName(String name);

    List<Book> getByIsbn(String isbn);

    List<Book> getByGenre(String genre);

    List<Book> getAll();

    BookVO getBookVO(Book book);
}

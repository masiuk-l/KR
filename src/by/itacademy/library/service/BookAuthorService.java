package by.itacademy.library.service;

import by.itacademy.library.entities.Author;
import by.itacademy.library.entities.Book;
import by.itacademy.library.entities.BookAuthor;

import java.io.Serializable;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 15.08.2017.
 */
public interface BookAuthorService {
    BookAuthor save(BookAuthor bookAuthor);

    BookAuthor get(Serializable id);

    void update(BookAuthor bookAuthor);

    int delete(Serializable id);

    List<BookAuthor> getByAuthorID(Author author);

    List<BookAuthor> getByBookID(Book book);

    List<BookAuthor> getAll();
}

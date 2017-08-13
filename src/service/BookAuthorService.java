package service;

import entities.Author;
import entities.Book;
import entities.BookAuthor;

import java.io.Serializable;
import java.util.List;

public interface BookAuthorService {
    BookAuthor save(BookAuthor bookAuthor);

    BookAuthor get(Serializable id);

    void update(BookAuthor bookAuthor);

    int delete(Serializable id);

    List<BookAuthor> getByAuthorID(Author author);

    List<BookAuthor> getByBookID(Book book);

    List<BookAuthor> getAll();
}

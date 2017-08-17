package service;

import VO.BookVO;
import entities.Book;

import java.io.Serializable;
import java.util.List;

public interface BookService {
    Book save(Book book);

    Book get(Serializable id);

    void update(Book book);

    int delete(Serializable id);

    List<Book> getByName(String name);

    List<Book> getByIsbn(String isbn);

    List<Book> getByGenre(String genre);

    List<Book> getAll();

    BookVO getBookVO(Book book);
}

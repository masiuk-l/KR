package VO.transfer;

import VO.BookVO;
import entities.Author;
import entities.Book;
import entities.Reader;

import java.util.ArrayList;
import java.util.List;

public class BookTransfer {
    public static BookVO toValueObject(Book book, List<Reader> readers, List<Author> authors) {
        BookVO bookVO = new BookVO();
        bookVO.setBookID(book.getBookID());
        bookVO.setName(book.getName());
        bookVO.setIsbn(book.getIsbn());
        bookVO.setGenre(book.getGenre());
        bookVO.setYear(book.getYear());
        bookVO.setQuantity(book.getQuantity());
        bookVO.setAuthors(new ArrayList<>(authors));
        bookVO.setReaders(new ArrayList<>(readers));
        return bookVO;
    }

    public static Book toEntity(BookVO bookVO) {
        Book book = new Book(bookVO.getBookID(), bookVO.getName(), bookVO.getIsbn(), bookVO.getGenre(),
                bookVO.getYear(), bookVO.getQuantity());
        return book;
    }
}

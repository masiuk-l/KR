package service;

import entities.Author;

import java.io.Serializable;
import java.util.List;

public interface AuthorService {

    Author save(Author author);

    Author get(Serializable id);

    void update(Author author);

    int delete(Serializable id);

    List<Author> getBySurname(String surname);

    List<Author> getAll();
}

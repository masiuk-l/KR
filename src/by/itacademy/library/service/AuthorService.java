package by.itacademy.library.service;

import by.itacademy.library.entities.Author;

import java.io.Serializable;
import java.util.List;


/**
 * Project KR. Created by masiuk-l on 15.08.2017.
 */
public interface AuthorService {

    Author save(Author author);

    Author get(Serializable id);

    void update(Author author);

    int delete(Serializable id);

    List<Author> getBySurname(String surname);

    List<Author> getAll();
}

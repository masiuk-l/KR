package by.itacademy.library.service;

import by.itacademy.library.entities.Librarian;

import java.io.Serializable;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 15.08.2017.
 */
public interface LibrarianService {
    Librarian save(Librarian librarian);

    Librarian get(Serializable id);

    void update(Librarian librarian);

    int delete(Serializable id);

    List<Librarian> getBySurname(String surname);

    Librarian getByLogin(String login);

    List<Librarian> getAll();

}

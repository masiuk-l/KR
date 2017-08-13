package service;

import entities.Librarian;

import java.io.Serializable;
import java.util.List;

public interface LibrarianService {
    Librarian save(Librarian librarian);

    Librarian get(Serializable id);

    void update(Librarian librarian);

    int delete(Serializable id);

    List<Librarian> getBySurname(String surname);

    List<Librarian> getAll();

}

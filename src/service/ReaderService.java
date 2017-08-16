package service;

import entities.Reader;

import java.io.Serializable;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
public interface ReaderService {

    Reader save(Reader reader);

    Reader get(Serializable id);

    void update(Reader reader);

    int delete(Serializable id);

    List<Reader> getBySurname(String surname);

    List<Reader> getByStatus(String status);

    Reader getByLogin(String login);

    List<Reader> getAll();
}

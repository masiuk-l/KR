package service;

import entities.Reader;

import java.io.Serializable;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
public interface ReaderService {

    Reader save(Reader Reader);

    Reader get(Serializable id);

    void update(Reader Reader);

    int delete(Serializable id);

    Reader getBySurname(String surname);

    List<Reader> getAll();
}

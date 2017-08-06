package service;

import entity.Reader;

import java.io.Serializable;
import java.util.List;


public interface ReaderService {

    Reader save(Reader Reader);

    Reader get(Serializable id);

    void update(Reader Reader);

    int delete(Serializable id);

    Reader getReaderBySurname(String surname, String supplier);

    List<Reader> getAll();
}

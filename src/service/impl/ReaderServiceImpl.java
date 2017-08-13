package service.impl;

import dao.ReaderDAO;
import dao.impl.ReaderDAOImpl;
import entities.Reader;
import service.ReaderService;
import service.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
public class ReaderServiceImpl extends AbstractService implements ReaderService {
    private ReaderDAO readerDAO = ReaderDAOImpl.getInstance();

    @Override
    public Reader save(Reader reader) {
        try {
            if (reader.getName() != null && reader.getSurname() != null && reader.getSecondName() != null) {
                startTransaction();
                reader = readerDAO.save(reader);
                commit();
            }
        } catch (SQLException e) {
            throw new ServiceException("Error creating Reader");
        }
        return reader;
    }

    @Override
    public Reader get(Serializable id) {
        return null;
    }

    @Override
    public void update(Reader reader) {

    }

    @Override
    public int delete(Serializable id) {
        return 0;
    }

    @Override
    public Reader getBySurname(String model) {
        return null;
    }

    @Override
    public List<Reader> getAll() {
        try {
            return readerDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

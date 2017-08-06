package service.impl;

import dao.ReaderDAO;
import dao.impl.ReaderDAOImpl;
import entity.Reader;
import service.ReaderService;
import service.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class ReaderServiceImpl extends AbstractService implements ReaderService {
    private ReaderDAO readerDAO = ReaderDAOImpl.getInstance();

    @Override
    public Reader save(Reader reader) {
        try {
            //validation Reader
            startTransaction();
            reader = readerDAO.save(reader);
            commit();
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
    public Reader getReaderBySurname(String model, String supplier) {
        return null;
    }

    @Override
    public List<Reader> getAll() {
        return null;
    }
}

package service.impl;

import VO.FormVO;
import VO.ReaderVO;
import VO.transfer.ReaderTransfer;
import dao.FormDAO;
import dao.ReaderDAO;
import dao.impl.FormDAOImpl;
import dao.impl.ReaderDAOImpl;
import entities.Form;
import entities.Reader;
import service.FormService;
import service.ReaderService;
import service.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 06.08.2017.
 */
public class ReaderServiceImpl extends AbstractService implements ReaderService {
    private ReaderDAO readerDAO = ReaderDAOImpl.getInstance();
    private FormDAO formDAO = FormDAOImpl.getInstance();
    private FormService formService = new FormServiceImpl();

    @Override
    public Reader save(Reader reader) {
        try {
            if (reader != null) {
                startTransaction();
                reader = readerDAO.save(reader);
                commit();
                return reader;
            } else {
                throw new ServiceException("Reader not defined");
            }
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating Reader");
        }

    }

    @Override
    public Reader get(Serializable id) {
        try {
            Reader reader;
            startTransaction();
            reader = readerDAO.get(id);
            commit();
            return reader;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error getting Reader");
        }
    }

    @Override
    public void update(Reader reader) {
        try {
            startTransaction();
            readerDAO.update(reader);
            commit();
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error updating Reader");
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            startTransaction();
            int rows = readerDAO.delete(id);
            commit();
            return rows;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error deleting Reader");
        }
    }

    @Override
    public List<Reader> getBySurname(String surname) {
        ArrayList<Reader> readers;
        try {
            startTransaction();
            readers = new ArrayList<>(readerDAO.getBySurname(surname));
            commit();
            return readers;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Reader");
        }
    }

    @Override
    public List<Reader> getByStatus(String status) {
        ArrayList<Reader> readers;
        try {
            startTransaction();
            readers = new ArrayList<>(readerDAO.getByStatus(status));
            commit();
            return readers;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Reader");
        }
    }

    @Override
    public Reader getByLogin(String login) {
        ArrayList<Reader> readers;
        try {
            startTransaction();
            readers = new ArrayList<>(readerDAO.getByLogin(login));
            if (readers.size() > 1)
                throw new ServiceException("Multiple login Error");
            commit();
            return readers.get(0);
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Reader");
        }
    }

    @Override
    public ReaderVO getReaderVO(Reader reader) {
        try {
            startTransaction();
            ReaderVO readerVO;
            List<FormVO> formVOS = new ArrayList<>();
            List<Form> forms = formDAO.getByReader(reader);
            for (Form form : forms) {
                FormVO formVO = formService.getFormVO(form);
                formVOS.add(formVO);
            }
            readerVO = ReaderTransfer.toValueObject(reader, formVOS);
            commit();
            return readerVO;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating ReaderVO");
        }
    }

    @Override
    public List<Reader> getAll() {
        ArrayList<Reader> readers;
        try {
            startTransaction();
            readers = new ArrayList<>(readerDAO.getAll());
            commit();
            return readers;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Reader");
        }
    }
}

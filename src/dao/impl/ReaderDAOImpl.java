package dao.impl;

import dao.ReaderDAO;
import db.ConnectionManager;
import entity.Reader;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 06.08.2017.
 */


public class ReaderDAOImpl implements ReaderDAO {
    private static final Logger LOG = Logger.getLogger(ReaderDAOImpl.class);
    private static final String saveReaderQuery = "INSERT INTO READER (NAME, SURNAME, SECOND_NAME, BIRTHDAY) VALUES (?, ?, ?, ?)";
    private static final String updateReaderQuery = "UPDATE READER SET NAME=?, SURNAME=?, SECOND_NAME=?, BIRTHDAY=? WHERE READER_ID=?";
    private static final String getReaderQuery = "SELECT * FROM READER WHERE Reader_ID=?";
    private static final String getAllReaderQuery = "SELECT * FROM READER";
    private static final String getReaderBySurnameQuery = "SELECT * FROM READER WHERE SURNAME=?";
    private static final String deleteReaderQuery = "DELETE FROM READER WHERE READER_ID=?";
    private static volatile ReaderDAO INSTANCE = null;
    private PreparedStatement psSave;
    private PreparedStatement psUpdate;
    private PreparedStatement psGet;
    private PreparedStatement psGetBySurname;
    private PreparedStatement psGetAll;
    private PreparedStatement psDelete;

    {
        try {
            psSave = ConnectionManager.getConnection().prepareStatement(saveReaderQuery, Statement.RETURN_GENERATED_KEYS);
            psUpdate = ConnectionManager.getConnection().prepareStatement(updateReaderQuery);
            psGet = ConnectionManager.getConnection().prepareStatement(getReaderQuery);
            psGetBySurname = ConnectionManager.getConnection().prepareStatement(getReaderBySurnameQuery);
            psGetAll = ConnectionManager.getConnection().prepareStatement(getAllReaderQuery);
            psDelete = ConnectionManager.getConnection().prepareStatement(deleteReaderQuery);
        } catch (SQLException e) {
            LOG.error(e);
        }
    }

    private ReaderDAOImpl() {
    }

    public static ReaderDAO getInstance() {
        ReaderDAO readerDAO = INSTANCE;
        if (readerDAO == null) {
            synchronized (ReaderDAOImpl.class) {
                readerDAO = INSTANCE;
                if (readerDAO == null) {
                    INSTANCE = readerDAO = new ReaderDAOImpl();
                }
            }
        }

        return readerDAO;
    }

    private static void close(ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            LOG.error(e);
        }
    }

    @Override
    public Reader save(Reader reader) throws SQLException {
        psSave.setString(1, reader.getName());
        psSave.setString(2, reader.getSurname());
        psSave.setString(3, reader.getSecondName());
        psSave.setDate(4, reader.getBirthday());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            reader.setReaderID(rs.getInt(1));
        }
        close(rs);
        return reader;
    }

    @Override
    public Reader get(Serializable id) throws SQLException {
        psGet.setInt(1, (int) id);
        psGet.executeQuery();
        ResultSet rs = psGet.getResultSet();
        if (rs.next()) {
            Reader reader = new Reader();
            reader.setReaderID(rs.getInt(1));
            reader.setName(rs.getString(2));
            reader.setSurname(rs.getString(3));
            reader.setSecondName(rs.getString(4));
            reader.setBirthday(rs.getDate(5));
            return reader;
        }
        close(rs);

        return null;
    }

    @Override
    public void update(Reader reader) throws SQLException {
        psUpdate.setInt(5, reader.getReaderID());
        psUpdate.setString(1, reader.getName());
        psUpdate.setString(2, reader.getSurname());
        psUpdate.setString(3, reader.getSecondName());
        psUpdate.setDate(4, reader.getBirthday());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        psDelete.setInt(1, (int) id);
        return psDelete.executeUpdate();
    }

    @Override
    public Reader getReaderBySurname(String surname) throws SQLException {
        psGetBySurname.setString(1, surname);
        psGetBySurname.execute();
        ResultSet rs = psGetBySurname.getResultSet();
        while (rs.next()) {
            Reader reader = new Reader();
            reader.setReaderID(rs.getInt(1));
            reader.setName(rs.getString(2));
            reader.setSurname(rs.getString(3));
            reader.setSecondName(rs.getString(4));
            reader.setBirthday(rs.getDate(5));
            return reader;
        }
        close(rs);

        return null;
    }

    @Override
    public List<Reader> getAll() throws SQLException {
        List<Reader> list = new ArrayList<>();
        psGetAll.execute();
        ResultSet rs = psGetAll.getResultSet();
        while (rs.next()) {
            Reader reader = new Reader();
            reader.setReaderID(rs.getInt(1));
            reader.setName(rs.getString(2));
            reader.setSurname(rs.getString(3));
            reader.setSecondName(rs.getString(4));
            reader.setBirthday(rs.getDate(5));
            list.add(reader);
        }
        close(rs);
        return list;
    }
}


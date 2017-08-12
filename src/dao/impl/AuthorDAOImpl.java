package dao.impl;

import dao.AuthorDAO;
import db.ConnectionManager;
import entities.Author;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 07.08.2017.
 */
public class AuthorDAOImpl implements AuthorDAO {

    private static final Logger LOG = Logger.getLogger(AuthorDAOImpl.class);
    private static final String saveAuthorQuery = "INSERT INTO AUTHORS (NAME, SURNAME, SECOND_NAME, BIRTHDAY, COUNTRY) VALUES (?, ?, ?, ?, ?)";
    private static final String updateAuthorQuery = "UPDATE AUTHORS SET NAME=?, SURNAME=?, SECOND_NAME=?, BIRTHDAY=? ,COUNTRY=? WHERE READER_ID=?";
    private static final String getAuthorQuery = "SELECT * FROM AUTHORS WHERE Author_ID=?";
    private static final String getAllAuthorQuery = "SELECT * FROM AUTHORS";
    private static final String getAuthorBySurnameQuery = "SELECT * FROM AUTHORS WHERE SURNAME=?";
    private static final String deleteAuthorQuery = "DELETE FROM AUTHORS WHERE READER_ID=?";
    private static volatile AuthorDAO INSTANCE = null;
    private PreparedStatement psSave;
    private PreparedStatement psUpdate;
    private PreparedStatement psGet;
    private PreparedStatement psGetBySurname;
    private PreparedStatement psGetAll;
    private PreparedStatement psDelete;

    {
        try {
            psSave = ConnectionManager.getConnection().prepareStatement(saveAuthorQuery, Statement.RETURN_GENERATED_KEYS);
            psUpdate = ConnectionManager.getConnection().prepareStatement(updateAuthorQuery);
            psGet = ConnectionManager.getConnection().prepareStatement(getAuthorQuery);
            psGetBySurname = ConnectionManager.getConnection().prepareStatement(getAuthorBySurnameQuery);
            psGetAll = ConnectionManager.getConnection().prepareStatement(getAllAuthorQuery);
            psDelete = ConnectionManager.getConnection().prepareStatement(deleteAuthorQuery);
        } catch (SQLException e) {
            LOG.error(e);
        }
    }

    private AuthorDAOImpl() {
    }

    public static AuthorDAO getInstance() {
        AuthorDAO authorDAO = INSTANCE;
        if (authorDAO == null) {
            synchronized (AuthorDAOImpl.class) {
                authorDAO = INSTANCE;
                if (authorDAO == null) {
                    INSTANCE = authorDAO = new AuthorDAOImpl();
                }
            }
        }

        return authorDAO;
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
    public Author save(Author author) throws SQLException {
        psSave.setString(1, author.getName());
        psSave.setString(2, author.getSurname());
        psSave.setString(3, author.getSecondName());
        psSave.setDate(4, author.getBirthday());
        psSave.setString(5, author.getCountry());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            author.setAuthorID(rs.getInt(1));
        }
        close(rs);
        return author;
    }

    @Override
    public Author get(Serializable id) throws SQLException {
        psGet.setInt(1, (int) id);
        psGet.executeQuery();
        ResultSet rs = psGet.getResultSet();
        if (rs.next()) {
            Author author = new Author();
            author.setAuthorID(rs.getInt(1));
            author.setName(rs.getString(2));
            author.setSurname(rs.getString(3));
            author.setSecondName(rs.getString(4));
            author.setBirthday(rs.getDate(5));
            author.setCountry(rs.getString(6));
            return author;
        }
        close(rs);

        return null;
    }

    @Override
    public void update(Author author) throws SQLException {
        psUpdate.setInt(6, author.getAuthorID());
        psUpdate.setString(1, author.getName());
        psUpdate.setString(2, author.getSurname());
        psUpdate.setString(3, author.getSecondName());
        psUpdate.setDate(4, author.getBirthday());
        psUpdate.setString(5, author.getCountry());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        psDelete.setInt(1, (int) id);
        return psDelete.executeUpdate();
    }

    @Override
    public List<Author> getBySurname(String surname) throws SQLException {
        List<Author> list = new ArrayList<>();
        psGetBySurname.setString(1, surname);
        psGetBySurname.execute();
        ResultSet rs = psGetBySurname.getResultSet();
        if (rs.next()) {
            Author author = new Author();
            author.setAuthorID(rs.getInt(1));
            author.setName(rs.getString(2));
            author.setSurname(rs.getString(3));
            author.setSecondName(rs.getString(4));
            author.setBirthday(rs.getDate(5));
            author.setCountry(rs.getString(6));
            list.add(author);
        }
        close(rs);

        return list;
    }

    @Override
    public List<Author> getAll() throws SQLException {
        List<Author> list = new ArrayList<>();
        psGetAll.execute();
        ResultSet rs = psGetAll.getResultSet();
        while (rs.next()) {
            Author author = new Author();

            author.setAuthorID(rs.getInt(1));
            author.setName(rs.getString(2));
            author.setSurname(rs.getString(3));
            author.setSecondName(rs.getString(4));
            author.setBirthday(rs.getDate(5));
            author.setCountry(rs.getString(6));

            list.add(author);
        }
        close(rs);
        return list;
    }
}

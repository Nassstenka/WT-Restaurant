package by.Anastasiya.restaurant.model.dao.impl;

import by.Anastasiya.restaurant.model.exception.ConnectionPoolException;
import by.Anastasiya.restaurant.model.exception.DAOException;
import by.Anastasiya.restaurant.model.beans.User;
import by.Anastasiya.restaurant.model.dao.IUserDAO;
import by.Anastasiya.restaurant.model.dao.pool.ConnectionPool;
import by.Anastasiya.restaurant.model.exception.DAOUserAlreadyExistsException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Date;

public class UserDAOImpl implements IUserDAO {

    private static final String TBL_COLUMN_ID = "id";
    private static final String TBL_COLUMN_LOGIN = "login";
    private static final String TBL_COLUMN_NAME = "name";
    private static final String TBL_COLUMN_SURNAME = "surname";
    private static final String TBL_COLUMN_DATE = "date";
    private static final String TBL_COLUMN_EMAIL = "email";
    private static final String TBL_COLUMN_PHONE = "phone";
    private static final String TBL_COLUMN_ROLE = "role";


    ConnectionPool pool = ConnectionPool.getInstance();

    private static final String INSERT_USER_SQL = "INSERT INTO users(login,password,name,surname,phone,email,date_of_birth,role_id) values(?,?,?,?,?,?,?,?)";
    private static final String SIGN_IN_SQL = "";

    private static String getSHA1Hash(byte[] password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(password);
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    @Override
    public void registration(String login, byte[] password, String name, String surname, String email, String phone, Date birthDate, int roleId) throws DAOException, DAOUserAlreadyExistsException {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = pool.takeConnection();
            ps = con.prepareStatement(INSERT_USER_SQL);
            ps.setString(1, login);
            ps.setString(2, getSHA1Hash(password));
            ps.setString(3, name);
            ps.setString(4, surname);
            ps.setString(5, phone);
            ps.setString(6, email);
            ps.setDate(7, new java.sql.Date(birthDate.getTime()));
            ps.setInt(8, roleId);

            ps.executeUpdate();


        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while adding new User", e);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new DAOUserAlreadyExistsException("This user already exists", e);
        } catch (SQLException e) {
            throw new DAOException("Error while adding new User", e);
        } catch (NoSuchAlgorithmException e) {
            throw new DAOException("Password hashing error", e);
        } finally {
            pool.closeConnection(con, ps);
        }
    }

    @Override
    public User signIn(String login, byte[] password) throws DAOException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = pool.takeConnection();
            ps = con.prepareStatement(SIGN_IN_SQL);
            ps.setString(1, login);
            ps.setString(2, getSHA1Hash(password));

            rs = ps.executeQuery();

            if (rs == null) {
                return null;
            }

            rs.last();

            if (rs.getRow() == 1) {
                return new User(rs.getInt(TBL_COLUMN_ID), rs.getString(TBL_COLUMN_LOGIN),rs.getString(TBL_COLUMN_NAME), rs.getString(TBL_COLUMN_SURNAME), rs.getString(TBL_COLUMN_EMAIL), rs.getString(TBL_COLUMN_PHONE), rs.getDate(TBL_COLUMN_DATE), rs.getString(TBL_COLUMN_ROLE));
            }

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while authorize User", e);
        } catch (SQLException e) {
            throw new DAOException("Error while authorize User", e);
        } catch (NoSuchAlgorithmException e) {
            throw new DAOException("Password hashing error", e);
        } finally {
            pool.closeConnection(con, ps, rs);
        }
        return null;
    }
}

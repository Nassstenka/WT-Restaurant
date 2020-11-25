package dao;

import beans.User;
import exception.DAOException;

public interface UserDAO {
    void signIn(String login, String password) throws DAOException;
    void registration (User user) throws DAOException;
}

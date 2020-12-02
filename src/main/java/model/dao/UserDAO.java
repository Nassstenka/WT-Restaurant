package model.dao;

import model.beans.User;
import model.exception.DAOException;

public interface UserDAO {
    void signIn(String login, String password) throws DAOException;
    void registration (User user) throws DAOException;
}

package by.Anastasiya.restaurant.model.dao;

import by.Anastasiya.restaurant.model.exception.DAOException;
import by.Anastasiya.restaurant.model.beans.User;
import by.Anastasiya.restaurant.model.exception.DAOUserAlreadyExistsException;

import java.util.Date;

public interface IUserDAO {
    void registration(String login, byte[] password, String name, String surname, String email, String phone, Date birthDate, int roleId) throws DAOException, DAOUserAlreadyExistsException;
    User signIn (String login, byte[] password) throws DAOException;
}

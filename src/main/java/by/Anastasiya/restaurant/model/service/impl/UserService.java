package by.Anastasiya.restaurant.model.service.impl;

import by.Anastasiya.restaurant.model.beans.User;
import by.Anastasiya.restaurant.model.dao.DAOFactory;
import by.Anastasiya.restaurant.model.dao.IUserDAO;
import by.Anastasiya.restaurant.model.exception.DAOException;
import by.Anastasiya.restaurant.model.exception.DAOUserAlreadyExistsException;
import by.Anastasiya.restaurant.model.exception.ServiceException;
import by.Anastasiya.restaurant.model.exception.ServiceUserAlreadyExistsException;
import by.Anastasiya.restaurant.model.service.IUserService;

import java.util.Date;

public class UserService implements IUserService {

    @Override
    public User signIn(String login, byte[] password) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();

        if (login.equals("") || password.length == 0) {
            return null;
        }

        IUserDAO userDAO = factory.getUserDAO();

        try {
            return userDAO.signIn(login, password);
        } catch (DAOException e) {
            throw new ServiceException("Error while signIn User", e);
        }
    }

    @Override
    public boolean registration(String login, byte[] password, String name, String surname, String email, String phone, Date birthDate, int roleId) throws ServiceException, ServiceUserAlreadyExistsException {

        if (login.equals("") || password.length == 0 || email.equals("") || birthDate == null) {
            return false;
        }

        DAOFactory factory = DAOFactory.getInstance();
        IUserDAO userDAO = factory.getUserDAO();

        try {
            userDAO.registration(login, password, name, surname, email, phone, birthDate, roleId);
        }
        catch (DAOUserAlreadyExistsException e) {
            throw new ServiceUserAlreadyExistsException("User already exists", e);
        }
        catch (DAOException e) {
            throw new ServiceException("Error while registration User", e);
        }

        return true;
    }
}

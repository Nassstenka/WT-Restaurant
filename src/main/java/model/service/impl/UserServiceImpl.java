package model.service.impl;

import model.beans.User;
import model.dao.DAOFactory;
import model.dao.UserDAO;
import model.exception.*;
import model.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void signIn(String login, String password) throws ServiceException {
        if (login == null || login.isEmpty()) {
            throw new ServiceException("Incorrect login");
        }
        try {
            DAOFactory daoObjectfactory = DAOFactory.GetInstance();
            UserDAO userDAO = daoObjectfactory.getUserDAO();
            userDAO.signIn(login, password);
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
        //...
    }

    @Override
    public void signOut(String login) throws ServiceException{

    }

    @Override
    public void registration(User user) throws ServiceException{

    }
}

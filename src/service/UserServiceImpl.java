package service;

import beans.User;
import dao.DAOFactory;
import dao.UserDAO;
import exception.DAOException;
import exception.ServiceException;

public class UserServiceImpl implements UserService{
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

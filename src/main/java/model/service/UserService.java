package model.service;

import model.beans.User;
import model.exception.ServiceException;

public interface UserService {
    void signIn(String login, String password) throws ServiceException;
    void signOut(String login) throws ServiceException;
    void registration(User user) throws ServiceException;
}

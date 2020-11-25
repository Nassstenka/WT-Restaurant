package service;

import beans.User;
import exception.ServiceException;

public interface UserService {
    void signIn(String login, String password) throws ServiceException;
    void signOut(String login) throws ServiceException;
    void registration(User user) throws ServiceException;
}

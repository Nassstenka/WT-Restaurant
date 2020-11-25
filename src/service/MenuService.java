package service;

import beans.Menu;
import exception.ServiceException;

public interface MenuService {
    void addNewDish(Menu menu) throws ServiceException;
    void addEditedDish(Menu menu) throws ServiceException;
}

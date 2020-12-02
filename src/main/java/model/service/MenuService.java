package model.service;

import model.beans.Menu;
import model.exception.ServiceException;

public interface MenuService {
    void addNewDish(Menu menu) throws ServiceException;
    void addEditedDish(Menu menu) throws ServiceException;
}

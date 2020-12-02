package model.dao;

import model.beans.Menu;
import model.exception.DAOException;

public interface MenuDAO {
    void addDish(Menu menu) throws DAOException;
    void deleteDish(long dishID) throws DAOException;
    void delete(Menu menu) throws DAOException;
}

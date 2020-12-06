package by.Anastasiya.restaurant.model.service.impl;

import by.Anastasiya.restaurant.model.beans.Category;
import by.Anastasiya.restaurant.model.beans.Dish;
import by.Anastasiya.restaurant.model.dao.DAOFactory;
import by.Anastasiya.restaurant.model.dao.IDishDAO;
import by.Anastasiya.restaurant.model.exception.DAOException;
import by.Anastasiya.restaurant.model.exception.ServiceException;
import by.Anastasiya.restaurant.model.service.IDishService;

import java.util.List;

public class DishService implements IDishService {
    @Override
    public List<Category> getCategories() throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IDishDAO itemDAO = factory.getItemDAO();

        try {
            return itemDAO.getCategories();
        } catch (DAOException e) {
            throw new ServiceException("Error while find all categories", e);
        }
    }

    @Override
    public List<Dish> getItemsByCategory(int categoryId) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IDishDAO dishDAO = factory.getItemDAO();

        if (categoryId < 1) {
            return null;
        }

        try {
            return dishDAO.findItemsByCategory(categoryId);
        } catch (DAOException e) {
            throw new ServiceException("Error while find Items by category", e);
        }
    }

    @Override
    public Dish getItem(int itemId) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IDishDAO itemDAO = factory.getItemDAO();

        if (itemId < 1) {
            return null;
        }

        try {
            return itemDAO.getItem(itemId);
        } catch (DAOException e) {
            throw new ServiceException("Error while find Item by ID", e);
        }
    }
}

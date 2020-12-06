package by.Anastasiya.restaurant.model.dao;

import by.Anastasiya.restaurant.model.exception.DAOException;
import by.Anastasiya.restaurant.model.beans.Category;
import by.Anastasiya.restaurant.model.beans.Dish;

import java.util.List;

public interface IDishDAO {
    List<Dish> findItemsByCategory(int categoryID) throws DAOException;
    List<Category> getCategories() throws DAOException;
    Dish getItem(int itemId) throws DAOException;
}

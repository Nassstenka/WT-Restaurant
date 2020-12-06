package by.Anastasiya.restaurant.model.service;

import by.Anastasiya.restaurant.model.beans.Category;
import by.Anastasiya.restaurant.model.beans.Dish;
import by.Anastasiya.restaurant.model.exception.ServiceException;

import java.util.List;

public interface IDishService {
    List<Dish> getItemsByCategory(int categoryId) throws ServiceException;
    List<Category> getCategories() throws ServiceException;
    Dish getItem(int itemId) throws ServiceException;
}

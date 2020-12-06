package by.Anastasiya.restaurant.model.service;

import by.Anastasiya.restaurant.model.beans.Order;
import by.Anastasiya.restaurant.model.exception.ServiceException;

public interface IOrderService {
    int createEmptyOrder(int userId) throws ServiceException;
    boolean addItem(int orderId, int itemId, int count) throws ServiceException;
    boolean deleteItem(int orderId, int itemId) throws ServiceException;
    Order getOrder(int orderId) throws ServiceException;
    int getCurrentOrderId(int userId) throws ServiceException;
    void confirmOrder(Order order) throws ServiceException;
}

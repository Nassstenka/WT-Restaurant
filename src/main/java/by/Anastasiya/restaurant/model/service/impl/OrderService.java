package by.Anastasiya.restaurant.model.service.impl;

import by.Anastasiya.restaurant.model.beans.Order;
import by.Anastasiya.restaurant.model.dao.DAOFactory;
import by.Anastasiya.restaurant.model.dao.IOrderDAO;
import by.Anastasiya.restaurant.model.exception.DAOException;
import by.Anastasiya.restaurant.model.exception.ServiceException;
import by.Anastasiya.restaurant.model.service.IOrderService;

public class OrderService implements IOrderService {

    @Override
    public int createEmptyOrder(int userId) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IOrderDAO orderDAO = factory.getOrderDAO();

        try {
            return orderDAO.createEmptyOrder(userId);
        } catch (DAOException e) {
            throw new ServiceException("Error while find create Order", e);
        }
    }

    @Override
    public boolean addItem(int orderId, int itemId, int count) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IOrderDAO orderDAO = factory.getOrderDAO();

        if (orderId < 1 || itemId < 1 || count < 1) {
            return false;
        }

        try {
            orderDAO.addItem(orderId,itemId,count);
            return true;
        } catch (DAOException e) {
            throw new ServiceException("Error while adding Item to Cart", e);
        }
    }

    @Override
    public boolean deleteItem(int orderId, int itemId) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IOrderDAO orderDAO = factory.getOrderDAO();

        if (orderId < 1 || itemId < 1) {
            return false;
        }

        try {
            orderDAO.deleteItem(orderId, itemId);
            return true;
        } catch (DAOException e) {
            throw new ServiceException("Error while remove Item from Cart", e);
        }
    }

    @Override
    public Order getOrder(int orderId) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IOrderDAO orderDAO = factory.getOrderDAO();

        if (orderId < 1) {
            return null;
        }

        try {
            return orderDAO.getOrder(orderId);
        } catch (DAOException e) {
            throw new ServiceException("Error while calling getOrder()", e);
        }
    }

    @Override
    public int getCurrentOrderId(int userId) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IOrderDAO orderDAO = factory.getOrderDAO();

        if (userId < 1) {
            return 0;
        }

        try {
            return orderDAO.getCurrentOrderId(userId);
        } catch (DAOException e) {
            throw new ServiceException("Error while get current orderID", e);
        }
    }

    @Override
    public void confirmOrder(Order order) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IOrderDAO orderDAO = factory.getOrderDAO();

        if (order.getItemMap().isEmpty()) {
            throw new ServiceException("Error while confirm Order. No Items in Cart");
        }

        try {
            orderDAO.confirmOrder(order);
        } catch (DAOException e) {
            throw new ServiceException("Error while confirm Order", e);
        }
    }

}

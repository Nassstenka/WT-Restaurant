package by.Anastasiya.restaurant.model.dao;

import by.Anastasiya.restaurant.model.dao.impl.DishDAOImpl;
import by.Anastasiya.restaurant.model.dao.impl.OrderDAOImpl;
import by.Anastasiya.restaurant.model.dao.impl.UserDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance;

    static {
        instance = new DAOFactory();
    }

    private final IUserDAO sqlUserImpl = new UserDAOImpl();
    private final IDishDAO sqlItemImpl = new DishDAOImpl();
    private final IOrderDAO sqlOrderImpl = new OrderDAOImpl();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public IUserDAO getUserDAO() {
        return sqlUserImpl;
    }

    public IDishDAO getItemDAO() {
        return  sqlItemImpl;
    }

    public IOrderDAO getOrderDAO() {
        return  sqlOrderImpl;
    }



}

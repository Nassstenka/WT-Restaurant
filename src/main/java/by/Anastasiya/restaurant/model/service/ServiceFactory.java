package by.Anastasiya.restaurant.model.service;

import by.Anastasiya.restaurant.model.service.impl.DishService;
import by.Anastasiya.restaurant.model.service.impl.OrderService;
import by.Anastasiya.restaurant.model.service.impl.UserService;

public final class ServiceFactory {
    private static final ServiceFactory instance;

    static {
        instance = new ServiceFactory();
    }

    private final IUserService sqlUserImpl = new UserService();
    private final IDishService sqlItemImpl = new DishService();
    private final IOrderService sqlOrderImpl = new OrderService();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public IUserService getUserService() {
        return sqlUserImpl;
    }

    public IDishService getItemService() {
        return  sqlItemImpl;
    }

    public IOrderService getOrderService() {
        return  sqlOrderImpl;
    }
}

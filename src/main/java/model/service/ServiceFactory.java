package model.service;

import model.service.impl.MenuServiceImpl;
import model.service.impl.UserServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();
    private final MenuService menuService = new MenuServiceImpl();

    private ServiceFactory() {};

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public MenuService getMenuService() {
        return menuService;
    }
}

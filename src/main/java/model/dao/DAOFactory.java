package model.dao;

import model.dao.impl.SQLMenuDAO;
import model.dao.impl.SQLUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private static final SQLUserDAO sqlUserImpl = new SQLUserDAO();
    private static final SQLMenuDAO sqlMenuImpl = new SQLMenuDAO();

    private DAOFactory() {}
    public static DAOFactory GetInstance() {
        return instance;
    }

    public SQLUserDAO getUserDAO() {
        return sqlUserImpl;
    }

    public SQLMenuDAO getMenuDAO() {
        return sqlMenuImpl;
    }
}

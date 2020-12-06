package by.Anastasiya.restaurant.model.dao.impl;

import by.Anastasiya.restaurant.model.beans.Category;
import by.Anastasiya.restaurant.model.beans.Dish;
import by.Anastasiya.restaurant.model.dao.IDishDAO;
import by.Anastasiya.restaurant.model.dao.pool.ConnectionPool;
import by.Anastasiya.restaurant.model.exception.ConnectionPoolException;
import by.Anastasiya.restaurant.model.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDAOImpl implements IDishDAO {
    private static final String TBL_COLUMN_ID = "dish_id";
    private static final String TBL_COLUMN_NAME = "name";
    private static final String TBL_COLUMN_DESCRIPTION = "description";
    private static final String TBL_COLUMN_PRICE = "price";
    private static final String TBL_COLUMN_COUNT = "count";
    private static final String TBL_COLUMN_CATEGORY_NAME = "category_name";
    private static final String TBL_COLUMN_CATEGORY_DESC = "category_desc";
    private static final String TBL_COLUMN_RATING = "rating";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String GET_ITEMS_BY_CATEGORY = "";
    private static final String GET_ALL_CATEGORIES_SQL = "";
    private static final String GET_ITEM_BY_ID = "";

    @Override
    public List<Dish> findItemsByCategory(int categoryID) throws DAOException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(GET_ITEMS_BY_CATEGORY);
            ps.setInt(1, categoryID);

            rs = ps.executeQuery();

            if (rs == null) {
                return null;
            }

            List<Dish> dishList = new ArrayList<>();

            while (rs.next()) {
                dishList.add(new Dish(
                        rs.getInt(TBL_COLUMN_ID),
                        rs.getString(TBL_COLUMN_CATEGORY_NAME),
                        rs.getString(TBL_COLUMN_NAME),
                        rs.getString(TBL_COLUMN_DESCRIPTION),
                        rs.getBigDecimal(TBL_COLUMN_PRICE),
                        rs.getDouble(TBL_COLUMN_RATING),
                        rs.getInt(TBL_COLUMN_COUNT)
                ));
            }
            return dishList;

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while find Items", e);
        } catch (SQLException e) {
            throw new DAOException("Error while find Items", e);
        } finally {
            connectionPool.closeConnection(con, ps, rs);
        }
    }

    @Override
    public List<Category> getCategories() throws DAOException {
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = connectionPool.takeConnection();
            st = con.createStatement();

            rs = st.executeQuery(GET_ALL_CATEGORIES_SQL);

            if (rs == null) {
                return null;
            }

            List<Category> categoryList = new ArrayList<>();

            while (rs.next()) {
                categoryList.add(new Category(
                        rs.getInt(TBL_COLUMN_ID),
                        rs.getString(TBL_COLUMN_CATEGORY_NAME),
                        rs.getString(TBL_COLUMN_CATEGORY_DESC)
                ));
            }

            return categoryList;

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while find Categories", e);
        } catch (SQLException e) {
            throw new DAOException("Error while find Categories", e);
        } finally {
            connectionPool.closeConnection(con, st, rs);
        }
    }

    @Override
    public Dish getItem(int itemId) throws DAOException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(GET_ITEM_BY_ID);
            ps.setInt(1, itemId);

            rs = ps.executeQuery();

            if (rs == null) {
                return null;
            }

            Dish dish = null;

            if (rs.next()) {
                dish = new Dish(
                        rs.getInt(TBL_COLUMN_ID),
                        rs.getString(TBL_COLUMN_CATEGORY_NAME),
                        rs.getString(TBL_COLUMN_NAME),
                        rs.getString(TBL_COLUMN_DESCRIPTION),
                        rs.getBigDecimal(TBL_COLUMN_PRICE),
                        rs.getDouble(TBL_COLUMN_RATING),
                        rs.getInt(TBL_COLUMN_COUNT)
                );
            }

            return dish;

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while find Items", e);
        } catch (SQLException e) {
            throw new DAOException("Error while find Items", e);
        } finally {
            connectionPool.closeConnection(con, ps, rs);
        }
    }
}

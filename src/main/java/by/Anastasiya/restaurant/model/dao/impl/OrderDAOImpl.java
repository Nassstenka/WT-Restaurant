package by.Anastasiya.restaurant.model.dao.impl;

import by.Anastasiya.restaurant.model.beans.Dish;
import by.Anastasiya.restaurant.model.beans.Order;
import by.Anastasiya.restaurant.model.dao.DAOFactory;
import by.Anastasiya.restaurant.model.dao.IOrderDAO;
import by.Anastasiya.restaurant.model.dao.pool.ConnectionPool;
import by.Anastasiya.restaurant.model.exception.ConnectionPoolException;
import by.Anastasiya.restaurant.model.exception.DAOException;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class OrderDAOImpl implements IOrderDAO {
    private static final String TBL_COLUMN_ORDER_ID = "order_id";
    private static final String TBL_COLUMN_START_DATE = "create_date";
    private static final String TBL_COLUMN_COMMENT = "comment";
    private static final String TBL_COLUMN_STATE = "status_name";
    private static final String TBL_COLUMN_DESCRIPTION = "description";
    private static final String TBL_COLUMN_ITEM_ID = "item_id";
    private static final String TBL_COLUMN_CONFIRMATION = "confirmed";
    private static final String TBL_COLUMN_ITEM_COUNT = "count";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String CREATE_EMPTY_ORDER_SQL = "";
    private static final String ADD_ITEM_TO_ORDER_SQL = "";
    private static final String GET_ORDER_BY_ID_SQL = "";
    private static final String DELETE_ITEM_FROM_ORDER_SQL = "";
    private static final String GET_CURRENT_ORDER_ID_BY_USER_SQL = "";
    private static final String CONFIRM_ORDER_SQL = "";

    @Override
    public int createEmptyOrder(int userId) throws DAOException {
        CallableStatement cs = null;
        Connection con = null;

        try {
            con = connectionPool.takeConnection();
            cs = con.prepareCall(CREATE_EMPTY_ORDER_SQL);

            cs.setInt(1,userId);

            cs.registerOutParameter(TBL_COLUMN_ORDER_ID, Types.INTEGER);

            cs.execute();

            return cs.getInt(TBL_COLUMN_ORDER_ID);


        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while adding new Order", e);
        } catch (SQLException e) {
            throw new DAOException("Error while adding new Order", e);
        } finally {
            connectionPool.closeConnection(con, cs);
        }
    }

    @Override
    public void addItem(int orderId, int itemId, int count) throws DAOException {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(ADD_ITEM_TO_ORDER_SQL);
            ps.setInt(1, orderId);
            ps.setInt(2, count);
            ps.setInt(3, itemId);

            ps.executeUpdate();

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while adding Item to Cart", e);
        } catch (SQLException e) {
            throw new DAOException("Error while adding Item to Cart", e);
        } finally {
            connectionPool.closeConnection(con, ps);
        }
    }

    @Override
    public void deleteItem(int orderId, int itemId) throws DAOException {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(DELETE_ITEM_FROM_ORDER_SQL);
            ps.setInt(1, orderId);
            ps.setInt(2, itemId);

            ps.executeUpdate();

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while remove Dish from Order", e);
        } catch (SQLException e) {
            throw new DAOException("Error while while remove Dish from Order", e);
        } finally {
            connectionPool.closeConnection(con, ps);
        }
    }

    @Override
    public Order getOrder(int orderId) throws DAOException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(GET_ORDER_BY_ID_SQL);
            ps.setInt(1, orderId);

            rs = ps.executeQuery();

            if (rs == null) {
                return null;
            }

            Map<Dish, Integer> orderItems = new HashMap<>();
            String orderState = null;
            Date orderDate = null;
            String paymentType = null;
            String orderComment = null;
            boolean isConfirmed = false;

            while (rs.next()) {
                Dish item = DAOFactory.getInstance().getItemDAO().getItem(rs.getInt(TBL_COLUMN_ITEM_ID));
                int itemCount = rs.getInt(TBL_COLUMN_ITEM_COUNT);

                if (orderItems.containsKey(item)) {
                    orderItems.put(item, orderItems.get(item) + itemCount);
                }
                else {
                    orderItems.put(item, itemCount);
                }
            }

            rs.previous();

            if (rs.next()) {
                orderState = rs.getString(TBL_COLUMN_STATE);
                orderDate = rs.getDate(TBL_COLUMN_START_DATE);
                paymentType = rs.getString(TBL_COLUMN_DESCRIPTION);
                orderComment = rs.getString(TBL_COLUMN_COMMENT);
                isConfirmed = rs.getBoolean(TBL_COLUMN_CONFIRMATION);
            }

            return new Order(orderId,orderItems,orderState,orderDate,paymentType,orderComment, isConfirmed);

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while search Order", e);
        } catch (SQLException e) {
            throw new DAOException("Error while search Order", e);
        } finally {
            connectionPool.closeConnection(con, ps);
        }
    }

    @Override
    public int getCurrentOrderId(int userId) throws DAOException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        int orderId = 0;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(GET_CURRENT_ORDER_ID_BY_USER_SQL);
            ps.setInt(1, userId);

            rs = ps.executeQuery();

            if (rs == null) {
                return 0;
            }

            if (rs.next()) {
                orderId = rs.getInt(TBL_COLUMN_ORDER_ID);
            }

            return orderId;

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while get OrderId", e);
        } catch (SQLException e) {
            throw new DAOException("Error while get OrderId", e);
        } finally {
            connectionPool.closeConnection(con, ps);
        }
    }

    @Override
    public void confirmOrder(Order order) throws DAOException {
        CallableStatement cs = null;
        Connection con = null;

        try {
            con = connectionPool.takeConnection();
            cs = con.prepareCall(CONFIRM_ORDER_SQL);

            cs.setString(1,order.getPaymentType());
            cs.setString(2,order.getComment());
            cs.setInt(3,order.getOrderId());

            cs.execute();


        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while confirm Order", e);
        } catch (SQLException e) {
            throw new DAOException("Error while confirm Order", e);
        } finally {
            connectionPool.closeConnection(con, cs);
        }
    }
}

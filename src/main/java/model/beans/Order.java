package model.beans;

import java.util.Objects;

public class Order {
    private long orderID;
    private DishInOrder dish;
    private long clientID;
    private long adminID;
    private double cost;
    private boolean isPermitted;

    public Order() {
    }

    public Order(long orderID, DishInOrder dish, long clientID, long adminID, double cost) {
        this.orderID = orderID;
        this.dish = dish;
        this.clientID = clientID;
        this.adminID = adminID;
        this.cost = cost;
        this.isPermitted = false;
    }

    public boolean isPermitted() {
        return isPermitted;
    }

    public void setPermitted(boolean permitted) {
        isPermitted = permitted;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public DishInOrder getDish() {
        return dish;
    }

    public void setDish(DishInOrder dish) {
        this.dish = dish;
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public long getAdminID() {
        return adminID;
    }

    public void setAdminID(long adminID) {
        this.adminID = adminID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID &&
                clientID == order.clientID &&
                adminID == order.adminID &&
                Double.compare(order.cost, cost) == 0 &&
                isPermitted == order.isPermitted &&
                dish.equals(order.dish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, dish, clientID, adminID, cost, isPermitted);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", dish=" + dish +
                ", clientID=" + clientID +
                ", adminID=" + adminID +
                ", cost=" + cost +
                ", isPermitted=" + isPermitted +
                '}';
    }
}

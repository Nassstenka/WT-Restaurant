package by.Anastasiya.restaurant.model.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class Order implements Serializable {
    private int orderId;
    private Map<Dish, Integer> itemMap;
    private String state;
    private Date createDate;
    private String paymentType;
    private String comment;
    private boolean isConfirmed;

    public Order(int orderId, Map<Dish, Integer> itemMap, String state, Date createDate, String paymentType, String comment, boolean isConfirmed) {
        this.orderId = orderId;
        this.itemMap = itemMap;
        this.state = state;
        this.createDate = createDate;
        this.paymentType = paymentType;
        this.comment = comment;
        this.isConfirmed = isConfirmed;
    }

    public Order() {

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Map<Dish, Integer> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Dish, Integer> itemMap) {
        this.itemMap = itemMap;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId &&
                isConfirmed == order.isConfirmed &&
                itemMap.equals(order.itemMap) &&
                state.equals(order.state) &&
                createDate.equals(order.createDate) &&
                paymentType.equals(order.paymentType) &&
                comment.equals(order.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, itemMap, state, createDate, paymentType, comment, isConfirmed);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", itemMap=" + itemMap +
                ", state='" + state + '\'' +
                ", createDate=" + createDate +
                ", paymentType='" + paymentType + '\'' +
                ", comment='" + comment + '\'' +
                ", isConfirmed=" + isConfirmed +
                '}';
    }
}

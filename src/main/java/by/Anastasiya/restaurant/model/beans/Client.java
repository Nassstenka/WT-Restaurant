package by.Anastasiya.restaurant.model.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Client extends User implements Serializable {
    private List<Order> orderList;

    public Client() {
    }

    public Client(int userId, String login, String name, String surname, String email, String phone, Date dateOfBirth, String roleName) {
        super(userId, login, name, surname, email, phone, dateOfBirth, roleName);
        this.orderList = null;
    }

    public Client(int userId, String login, String name, String surname, String email, String phone, Date dateOfBirth, String roleName, List<Order> orderList) {
        super(userId, login, name, surname, email, phone, dateOfBirth, roleName);
        this.orderList = orderList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return orderList.equals(client.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderList);
    }

    @Override
    public String toString() {
        return "Client{" +
                "orderList=" + orderList +
                '}';
    }
}

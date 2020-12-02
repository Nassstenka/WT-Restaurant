package model.beans;

import java.util.List;
import java.util.Objects;

public class Client extends User{
    private long id;
    private List<Order> orderList;

    public Client() {

    }

    public Client(User user) {
        super();
        this.orderList = null;
    }

    public Client(User user, List<Order> orderList) {
        super();
        this.orderList = orderList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(orderList, client.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderList);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", orderList=" + orderList +
                '}';
    }


}

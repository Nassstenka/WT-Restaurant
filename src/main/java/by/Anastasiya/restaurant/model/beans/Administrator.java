package by.Anastasiya.restaurant.model.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Administrator extends User implements Serializable {
    private List<Order> listToConfirm;

    public Administrator() {

    }

    public Administrator(int userId, String login, String name, String surname, String email, String phone, Date dateOfBirth, String roleName, List<Order> listToConfirm) {
        super(userId, login, name, surname, email, phone, dateOfBirth, roleName);
        this.listToConfirm = listToConfirm;
    }

    public List<Order> getListToConfirm() {
        return listToConfirm;
    }

    public void setListToConfirm(List<Order> listToConfirm) {
        this.listToConfirm = listToConfirm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Administrator that = (Administrator) o;
        return listToConfirm.equals(that.listToConfirm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), listToConfirm);
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "listToConfirm=" + listToConfirm +
                '}';
    }
}

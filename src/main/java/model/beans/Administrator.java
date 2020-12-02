package model.beans;

import java.util.List;
import java.util.Objects;

public class Administrator extends User{
    private long id;
    private List<Order> listToPermit;

    public Administrator () {

    }

    public Administrator(User user) {
        super(user.getId(), user.getRole(), user.getName(), user.getSurname(), user.getGender(),
                user.getYearOld(), user.getEmail(), user.getPassword(), user.isBlocked());
        this.listToPermit = null;
    }

    public Administrator(User user, long id, List<Order> listToPermit) {
        super(user.getId(), user.getRole(), user.getName(), user.getSurname(), user.getGender(),
                user.getYearOld(), user.getEmail(), user.getPassword(), user.isBlocked());
        this.id = id;
        this.listToPermit = listToPermit;
    }

    public Administrator (User user, List<Order> listToPermit) {
        super(user.getId(), user.getRole(), user.getName(), user.getSurname(), user.getGender(),
                user.getYearOld(), user.getEmail(), user.getPassword(), user.isBlocked());
        this.listToPermit = listToPermit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Order> getListToPermit() {
        return listToPermit;
    }

    public void setListToPermit(List<Order> listToPermit) {
        this.listToPermit = listToPermit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Administrator that = (Administrator) o;
        return id == that.id &&
                listToPermit.equals(that.listToPermit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, listToPermit);
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", listToPermit=" + listToPermit +
                '}';
    }
}

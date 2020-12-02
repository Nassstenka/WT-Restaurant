package model.beans;

import java.util.Objects;

public class Menu {
    private long dishID;
    private String dishName;
    private double cost;

    public Menu() {

    }

    public Menu(long dishID, String dishName, double cost) {
        this.dishID = dishID;
        this.dishName = dishName;
        this.cost = cost;
    }

    public long getDishID() {
        return dishID;
    }

    public void setDishID(long dishID) {
        this.dishID = dishID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
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
        Menu menu = (Menu) o;
        return dishID == menu.dishID &&
                Double.compare(menu.cost, cost) == 0 &&
                dishName.equals(menu.dishName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishID, dishName, cost);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "dishID=" + dishID +
                ", dishName='" + dishName + '\'' +
                ", cost=" + cost +
                '}';
    }
}

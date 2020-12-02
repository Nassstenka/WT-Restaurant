package model.beans;

import java.util.Objects;

public class DishInOrder {
    private long dishID;
    private int dishCount;

    public DishInOrder() {
    }

    public DishInOrder(long dishID, int dishCount) {
        this.dishID = dishID;
        this.dishCount = dishCount;
    }

    public long getDishID() {
        return dishID;
    }

    public void setDishID(long dishID) {
        this.dishID = dishID;
    }

    public int getDishCount() {
        return dishCount;
    }

    public void setDishCount(int dishCount) {
        this.dishCount = dishCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishInOrder that = (DishInOrder) o;
        return dishID == that.dishID &&
                dishCount == that.dishCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishID, dishCount);
    }

    @Override
    public String toString() {
        return "DishInOrder{" +
                "dishID=" + dishID +
                ", dishCount=" + dishCount +
                '}';
    }
}

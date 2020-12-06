package by.Anastasiya.restaurant.model.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Dish implements Serializable {
    private int dishId;
    private String categoryName;
    private String dishName;
    private String description;
    private BigDecimal price;
    private double rating;
    private int count;

    public Dish() {
    }

    public Dish(int dishId, String categoryName, String dishName, String description, BigDecimal price, double rating, int count) {
        this.dishId = dishId;
        this.categoryName = categoryName;
        this.dishName = dishName;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.count = count;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return dishId == dish.dishId &&
                Double.compare(dish.rating, rating) == 0 &&
                count == dish.count &&
                categoryName.equals(dish.categoryName) &&
                dishName.equals(dish.dishName) &&
                description.equals(dish.description) &&
                price.equals(dish.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishId, categoryName, dishName, description, price, rating, count);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", categoryName='" + categoryName + '\'' +
                ", dishName='" + dishName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", count=" + count +
                '}';
    }
}

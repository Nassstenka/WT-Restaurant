package by.Anastasiya.restaurant.model.beans;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable {
        private int categoryId;
        private String name;
        private String description;

        public Category(int categoryId, String name, String description) {
            this.categoryId = categoryId;
            this.name = name;
            this.description = description;
        }

        public Category() {}

        public int getCategoryId() {
            return categoryId;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Category category = (Category) o;
            return categoryId == category.categoryId &&
                    name.equals(category.name) &&
                    Objects.equals(description, category.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(categoryId, name, description);
        }

        @Override
        public String toString() {
            return "Category{" +
                    "categoryId=" + categoryId +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
}



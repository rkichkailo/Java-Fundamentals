package by.academy.Deal;

import java.util.Objects;

public class Bread extends Product{

    private String color;
    private String sort;
    boolean glutenFree;

    public Bread(double price, String productName, String color, String sort, boolean glutenFree, int shopQuantity, int bagQuantity) {
        super(price, productName, shopQuantity, bagQuantity);
        this.color = color;
        this.sort = sort;
        this.glutenFree = glutenFree;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    @Override
    protected double discount() {
        return 6;
    }
    @Override
    public String toString() {
        return "Bread{" +
                "productName='" + productName + '\'' +
                ", sort='" + sort + '\'' +
                ", color='" + color + '\'' +
                ", glutenFree=" + glutenFree +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bread bread = (Bread) o;
        return glutenFree == bread.glutenFree && Objects.equals(color, bread.color) && Objects.equals(sort, bread.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, sort, glutenFree);
    }

}

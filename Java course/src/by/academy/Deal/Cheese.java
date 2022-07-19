package by.academy.Deal;

import java.util.Objects;

public class Cheese extends Product{

    private double weight;
    private String country;
    private String sort;

    public Cheese(double price, String productName, double weight, String country, String sort, int shopQuantity, int bagQuantity) {
        super(price, productName,shopQuantity, bagQuantity);
        this.weight = weight;
        this.country = country;
        this.sort = sort;
    }

//   переопределили метод родителя - discount - задаем расчет скидки для конкретного продукта
    @Override
    public double discount() {
        if ("parmezan".equals(sort)  && "Italy".equals(country)){
            return 5;
        } else if ("dor blue".equals(sort) || "Feta".equals(sort)){
            return price * 0.06;
        } else {
            return price * 0.07;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cheese cheese = (Cheese) o;
        return Double.compare(cheese.weight, weight) == 0 && country.equals(cheese.country) && sort.equals(cheese.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight, country, sort);
    }

    @Override
    public String toString() {
        return "Cheese{" +
                "productName='" + productName + '\'' +
                ", sort='" + sort + '\'' +
                ", country='" + country + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}

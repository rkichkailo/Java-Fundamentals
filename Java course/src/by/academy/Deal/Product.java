package by.academy.Deal;

import java.util.Objects;

public abstract class Product {
    protected double price;
    protected String productName;
    protected int shopQuantity;
    protected int bagQuantity;

    public Product(double price) {
        super();
    }

    public Product(double price, String productName, int shopQuantity, int bagQuantity) {
        this.price = price;
        this.productName = productName;
        this.shopQuantity = shopQuantity;
        this.bagQuantity = bagQuantity;
    }

// расчитываем стоимость за кол-во продуктов
    public double calcPrice(){

        return (price - discount()) * bagQuantity;
    }

    protected abstract double discount();

    public int getBagQuantity() {
        return bagQuantity;
    }
    public void setBagQuantity(int bagQuantity) {
        this.bagQuantity = bagQuantity;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getShopQuantity() {
        return shopQuantity;
    }

    public void setShopQuantity(int quantity) {
        this.shopQuantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", productName='" + productName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, productName);
    }
}

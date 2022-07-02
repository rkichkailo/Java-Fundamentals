package by.academy.Deal;

import java.util.Objects;

public class Product {

    private double price;
    private String productName;
    private  int quantity;
    boolean isTax;

    public Product(double price) {
        super();
    }

    public Product(double price, String productName, int quantity, boolean isTax) {
        this.price = price;
        this.productName = productName;
        this.quantity = quantity;
        this.isTax = isTax;
    }
// расчитываем стоимость за кол-во продуктов
    public double calcPrice(){
        return price * quantity;
    }
//  расчитываем дивконт
    public double discount(){
        return 1;
    }
//  getter, setter, hash, toString
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isTax() {
        return isTax;
    }

    public void setTax(boolean tax) {
        isTax = tax;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", isTax=" + isTax +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && quantity == product.quantity && isTax == product.isTax && productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, productName, quantity, isTax);
    }
}

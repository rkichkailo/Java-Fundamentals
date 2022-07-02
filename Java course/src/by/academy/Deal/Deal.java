package by.academy.Deal;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Deal {

    private User seller;
    private User buyer;
    private Product [] products;
    private LocalDateTime buyTime;
    private double fullPrice = 0.0;

    public Deal() {
        super();
    }


    public Deal(User seller, User buyer, Product[] products) {
        this.seller = seller;
        this.buyer = buyer;
        this.products = products;
    }

//    public double fullPrice(){
//        for (int i = 0; i < products.length; i++) {
//            fullPrice += Product.calcPrice();
//        }
//        return fullPrice;
//    }

//    public double deal(){}

//    public String bill(){

//    }

//  getter, setter, hash, toString

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    public LocalDateTime getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(LocalDateTime buyTime) {
        this.buyTime = buyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deal deal = (Deal) o;
        return seller.equals(deal.seller) && buyer.equals(deal.buyer) && Arrays.equals(products, deal.products);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(seller, buyer);
        result = 31 * result + Arrays.hashCode(products);
        return result;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "seller=" + seller +
                ", buyer=" + buyer +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}

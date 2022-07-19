package by.academy.Deal;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Deal {
    private User seller;
    private User buyer;
    private Product [] products;
    private  int shopBag = 0;
    private LocalDateTime buyTime;
    private int index;

    public Deal() {
        super();
        this.products = new Product[10];
        this.index = 0;
    }

    public Deal(User buyer) {
        super();
        this.buyer = buyer;
    }
    public void addProduct (Product newProduct, int quantity) {

        if (quantity != 0) {
            if (shopBag == products.length)
                grow();
            else {
                if (index == 0) {
                    products[index] = newProduct;
                    products[index].bagQuantity = quantity;
                    shopBag += quantity;
                }
                if (index > 0) {
                    for (int i = 0; i < index; i++) {
                        if (products[i].equals(newProduct)) {
                            products[i].bagQuantity += quantity;
                            break;
                        } else {
                            products[index] = newProduct;
                            products[index].bagQuantity = quantity;
                            shopBag += quantity;
                        }
                    }
                }
                index++;
                System.out.println("Продукт добавлен в корзину " +
                        "\n------------------------------------------------------");
            }
        }else{
            System.out.println("неверное количество");
        }
    }

    private void grow(){
        int newLength = (int) (products.length == 0 ? 1 : products.length * 1.5);
        Product [] newProducts = new Product[newLength];
        System.arraycopy(products, 0, newProducts, 0, products.length);
        products = newProducts;
    }
    public void removeProduct(int productID, int quantity){
        if (products[productID].bagQuantity > quantity){
            products[productID].bagQuantity -= quantity;
            shopBag-=quantity;
        } else {
            //products[productID].bagQuantity--;
            products[productID].bagQuantity -= quantity;
            System.arraycopy(products, productID + 1, products, productID, (products.length - productID) - 1);
            shopBag-=quantity;
            index--;
        }
        System.out.println("Продукт удален из корзины " +
                "\n------------------------------------------------------");
    }
    public Product getProduct(int productID){
        return products[productID];
    }

    public double fullPrice(){
        double fullPrice = 0;
        for (Product n: products) {
            if (n != null){
                fullPrice += n.calcPrice();
            }
        }
        return fullPrice;
    }

//    public double deal(){}

//    public String bill(){



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

    public int getShopBag() {
        return shopBag;
    }

    public void setShopBag(int shopBag) {
        this.shopBag = shopBag;
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

package by.academy.Deal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Objects;

public class Deal {
    private User seller;
    private User buyer;
    private Product [] products;
    private  int shopBag = 0;
    private double endPrice;
    private final LocalDate date = LocalDate.now();
    private final LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
    private LocalDateTime buyTime = LocalDateTime.of(date, time);
    private final LocalDate deadline_date = date.plusDays(10);
    private int index;

    public Deal() {
        super();
    }

    public Deal(User buyer, User seller) {
        super();
        this.buyer = buyer;
        this.seller = seller;
        this.products = new Product[10];
        this.index = 0;
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
                System.out.println("Продукт добавлен в корзину " + "\n------------------------------------------------------");
            }
        } else {
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
        double result = 0;
        for (Product n: products) {
            if (n != null){
                result += n.calcPrice();
            }
        }
        return result;
    }

    public boolean checkMoney(){
        return buyer.getMoney() >= fullPrice();
    }

    public void deal() throws IOException {
        this.endPrice = fullPrice();
        seller.setMoney(seller.getMoney() + endPrice);
        buyer.setMoney(buyer.getMoney() - endPrice);
        printBill();
        saveBill();
    }
    public String getBillInfo(){
        StringBuilder bill = new StringBuilder();
        bill.append("=====================ЧЕК ПРОДАЖИ=====================");
        bill.append("\nВремя покупки: " + buyTime + "\nDeadline: " + deadline_date + "\n-----------------------------------------------------");
        for (Product n: products) {
            if (n != null){
                bill.append("\n" + n.productName + " * " + n.bagQuantity + " = " + n.calcPrice() + "\n скидка = " + n.discount());//System.out.printf("%.2f",  n.calcPrice());
            }
        }
        bill.append("\nИтого к оплате " + endPrice + "\n-----------------------------------------------------");//System.out.printf("%.2f", endPrice);
        bill.append("\nПродавец - " + seller.getName() + "\nПокупатель - " + buyer.getName());
        bill.append("\nВаш бюджет: " + buyer.getMoney() + "\n------------------------------------------------------\n");//System.out.printf("%.2f", buyer.getMoney());
        return bill.toString();
    }

    private void printBill() {
        System.out.println(getBillInfo());
    }
    private void saveBill() throws IOException {
        File file = new File("src/by/academy/Deal","Bill.txt");
        if (!file.exists()){
           file.createNewFile();
        }
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))){
            bufferedWriter.write(getBillInfo());
        }
    }

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

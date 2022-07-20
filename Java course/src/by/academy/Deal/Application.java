package by.academy.Deal;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        User buyer = new User();
        User seller = new User("Ruslana", 100);

        System.out.println("Введите номер вашего телефона:");
        String number = scanner.nextLine();

        BelarusPhoneValidator phoneBelarus = new BelarusPhoneValidator();
        AmericanPhoneValidator phoneAmerica = new AmericanPhoneValidator();
        EmailValidator userEmail = new EmailValidator();

        if (phoneBelarus.validate(number) || phoneAmerica.validate(number)){
            buyer.setPhone(number);
            System.out.println(buyer.getPhone());
        } else {
            System.out.println("не верный паттерн");
        }

        System.out.println("Введите адрес вашей электонной почты:");
        String email = scanner.nextLine();


        if (userEmail.validate(email)){
            buyer.setEmail(number);
            System.out.println(buyer.getEmail());
        } else {
            System.out.println("не верный паттерн");
        }

        System.out.println("Ваше имя:");
        buyer.setName(scanner.nextLine());

        System.out.println("Ваш бюджет:");
        buyer.setMoney(scanner.nextDouble());

        Shop.getMenu(1);

        int userAction = scanner.nextInt();

        Deal deal = new Deal(buyer, seller);

        if (userAction != 2) {
            boolean menuAction = true;

            while (menuAction) {
                Shop.getMenu(2);
                userAction = scanner.nextInt();

                switch (userAction) {
                    case 0:
                        Shop.showProducts();
                        Shop.getMenu(0);
                        break;
                    case 1:
                        Shop.getMenu(3);
                        int productID = scanner.nextInt();

                        Shop.getMenu(4);
                        int productQuantity = scanner.nextInt();

                        if (productQuantity <= deal.getProducts().length) {

                            deal.addProduct(Shop.getProduct(productID), productQuantity);
                            Shop.reduceQuantity(productID, productQuantity);
                        }
                        break;
                    case 2:
                        if (deal.getShopBag() == 0){
                            Shop.getMenu(5);
                            Shop.getMenu(0);
                        } else {
                            Shop.getMenu(6);
                            productID = scanner.nextInt();

                            Shop.getMenu(4);
                            productQuantity = scanner.nextInt();

                            Shop.increaseQuantity(deal.getProduct(productID), productQuantity);
                            deal.removeProduct(productID, productQuantity);
                        }
                        break;
                    case 3:
                        if (deal.getShopBag() == 0){
                            Shop.getMenu(5);
                            Shop.getMenu(0);
                        } else {
                            int index = 0;
                            for(Product n: deal.getProducts()){
                                if (n == null){
                                    continue;
                                }
                                System.out.println(index + ". " + n + ", quantity = " + n.bagQuantity);
                                index++;
                            }
                            Shop.getMenu(0);
                        }
                        break;
                    case 4:
                        if (deal.getShopBag() == 0) {
                            Shop.getMenu(5);
                            Shop.getMenu(0);
                        } else {
                            Shop.getMenu(7);
                            System.out.println(deal.fullPrice());
                            Shop.getMenu(0);
                            Shop.getMenu(8);
                            userAction = scanner.nextInt();

                            if (userAction == 0){
                                if (deal.deal()){
                                    deal.bill();
                                    Shop.getMenu(0);
                                    Shop.getMenu(9);
                                    menuAction = false;
                                    break;
                                    } else {
                                        System.out.println("У вас недостаточно средств");
                                    }
                                }
                            }
                        break;
                    case 5:
                        Shop.getMenu(9);
                        menuAction = false;
                        break;
                }
            }
        } else{
            Shop.getMenu(9);
        }
        scanner.close();
    }
}

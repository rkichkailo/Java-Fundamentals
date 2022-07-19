package by.academy.Deal;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
       // Shop shop = new Shop();

        User buyer = new User();

        Deal deal = new Deal();

        System.out.println("Ваше имя:");
        buyer.setName(scanner.nextLine());

        System.out.println("Ваш бюджет:");
        buyer.setMoney(scanner.nextDouble());

        System.out.println("Здравствуйте " + buyer.getName() +
                "\nВас преветствует интернет магазин DEAL. " +
                "\nДля перехода в меню продуктов нажмите 1" +
                "\nДля выхода из программы нажмите 2");
        int userAction = scanner.nextInt();

        if (userAction != 2) {

            boolean menuAction = true;

            while (menuAction) {

                System.out.println("Выберите действие: " +
                        "\n0 - Перечень продуктов реализуемых в магазине" +
                        "\n1 - Добавить продукт в козину" +
                        "\n2 - Удалить продукт из корзины" +
                        "\n3 - Просмотр корзины" +
                        "\n4 - Подсчет корзины" +
                        "\n5 - Выйти из приложения");
                userAction = scanner.nextInt();

                switch (userAction) {
                    case 0:
                        Shop.showProducts();
                        System.out.println("------------------------------------------------------");
                        break;
                    case 1:
                        System.out.println("Выберите номер продукта");
                        int productID = scanner.nextInt();

                        System.out.println("Выберите количество");
                        int productQuantity = scanner.nextInt();

                        if (productQuantity <= deal.getProducts().length) {

                            deal.addProduct(Shop.getProduct(productID), productQuantity);
                            Shop.reduceQuantity(productID, productQuantity);
                        }
                        break;
                    case 2:
                        System.out.println("Введите номер удаляемого продукта:");
                        productID = scanner.nextInt();

                        System.out.println("Выберите количество");
                        productQuantity = scanner.nextInt();

                        Shop.increaseQuantity(deal.getProduct(productID), productQuantity);
                        System.out.println(deal.getProduct(productID));
                        deal.removeProduct(productID, productQuantity);
                        break;
                    case 3:
                        if (deal.getShopBag() == 0){
                            System.out.println("Корзина пустая. Пожалуйста добавьте продукт" +
                                    "\n------------------------------------------------------");
                        } else {
                            int index = 0;
                            for(Product n: deal.getProducts()){
                                if (n == null){
                                    continue;
                                }
                                System.out.println(index + ". " + n + ", quantity = " + n.bagQuantity);
                                index++;
                            }
                            System.out.println("------------------------------------------------------");
                        }
                        break;
                    case 4:
                        System.out.println("подсчет");
                        System.out.println(deal.fullPrice());
                        break;
                    case 5:
                        System.out.println("Спасибо что выбрали наш магазин. До новых покупок!");
                        menuAction = false;
                        break;
                }


                //               switch (userAction) {
//                    case 1:
//                        shop.getProducts();
//                        break;
//                    case 2:
//                        System.out.println("Выберите номер соостветствующей категории продуктов:" + "\n0 - Хлеб \n1 - Сыры\n2 - Вина");
//                        productCategory = scanner.nextInt();
//                        if (productCategory == 0 || productCategory < 3) {
//                            menu.showProducts(productCategory);
//                        } else {
//                            System.out.println("К сожалению нет такой категории");
//                        }
//                        break;
//                    case 3:
//                        if (userBagAdded) {
//                            System.out.println("Выберите количетво продуктов для вашей корзины: ");
//                            buyer.setUserBag(scanner.nextInt());
//                            userBagAdded = true;
//                            menuAction = false;
//                            break;
//                        } else {
//                            System.out.println("Корзина уже добавлена, пожалуйста выберите другое действие");
//                        }
//                    case 4:
//                        System.out.println("Спасибо что выбрали наш магазин. До новых покупок!");
//                        menuAction = false;
//                        break;
//                }
//            }

//            if (userBagAdded && userAction != 4) {

//                Product[] userSelection = new Product[buyer.getUserBag()];
//                Deal deal = new Deal(seller, buyer, userSelection);
//                boolean bagActions = true;

//                while (bagActions) {

//                    System.out.println("Выберите действие с корзиной: " +
//                            "\n1 - Добавить продукт" + "\n2 - Удалить продукт" + "\n3 - Подсчет корзины");
//                    userAction = scanner.nextInt();

//                    if (userAction == 1) {
//                        System.out.println("Выберете номер соостветствующей категории продуктов:" +
//                                "\n0 - Хлеб \n1 - Сыры\n2 - Вина");
//                        productCategory = scanner.nextInt();

//                        if (productCategory == 0 || productCategory < 3) {
//                            boolean newUserBag = false;
//                            do {
//                                menu.showProducts(productCategory);
//                                System.out.println("Выберите номер продукта");
//                                int productID = scanner.nextInt();
//                                System.out.println("Выберите количество");
//                                int productQuantity = scanner.nextInt();

//                                if (productQuantity <= buyer.getUserBag()) {
////                                System.out.println(menu.getProduct(productCategory, productID));

//                                    deal.addProduct(menu.getProduct(productCategory, productID), productQuantity);
//                                    menu.allProducts[productCategory][productID].quantity -= productQuantity;
//                                    System.out.println(Arrays.toString(deal.getProducts()));
//                                    newUserBag = false;

//                                } else {
//                                    System.out.println("Вы превысили лемит своей корзины. Желаете продолжить?" + "\n1 - Да" + "\n2 - Hет");
//                                    userAction = scanner.nextInt();
//                                    if (userAction == 1) {
//                                        System.out.println("Выберите количетво продуктов для вашей корзины: ");
//                                        buyer.setUserBag(scanner.nextInt());
//                                        newUserBag = true;
//                                    } else {
//                                        break;
//                                    }
//                                }
//                            } while (newUserBag);
//                        }
//                    } else if (userAction == 3) {
//                        bagActions = false;
//                    }
//                }
//                System.out.println("Спасибо что выбрали наш магазин. До новых покупок!");
//            }
//        }
            }
        } else{
            System.out.println("Спасибо что выбрали наш магазин. До новых покупок!");
        }
    }
}

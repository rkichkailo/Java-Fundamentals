package by.academy.Deal;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
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
                        //System.out.println(deal.getProduct(productID));
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
            }
        } else{
            System.out.println("Спасибо что выбрали наш магазин. До новых покупок!");
        }
    }
}

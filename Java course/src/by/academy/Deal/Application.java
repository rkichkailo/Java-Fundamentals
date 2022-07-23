package by.academy.Deal;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        User buyer = new User();
        User seller = new User("Ruslana", 100);

        BirthDate dateBirth = new BirthDate();
        BelarusPhoneValidator phoneBelarus = new BelarusPhoneValidator();
        AmericanPhoneValidator phoneAmerica = new AmericanPhoneValidator();
        EmailValidator userEmail = new EmailValidator();
        Deal deal = new Deal(buyer, seller);

        String dateOfBirth, phone, email;
        int attempts, userAction, productID, productQuantity;
        boolean menuAction;

        attempts = 3;
        while (attempts > 0){
            System.out.println("Введите вашу дату рождения в формате DD/MM/YYYY или DD-MM-YYYY" +
                                "\n(осталось попыток = " + attempts + ")");
            dateOfBirth = scanner.nextLine();

            if (dateBirth.dateCheck(dateOfBirth)){
                buyer.setDateOfBirth(dateBirth.getDateBirth());
                break;
            } else {
                attempts--;
            }
        }

        attempts = 3;

        while (attempts > 0){
            System.out.println("Введите номер вашего телефона:" + "\n(осталось попыток = " + attempts + ")");
            phone = scanner.nextLine();

            if (phoneBelarus.validate(phone)){
                buyer.setPhone(phone);
                break;
            } else {
                System.out.println("Неправильный номер"
                        + "\n------------------------------------------------------");
                attempts--;
            }
        }

        attempts = 3;

        while (attempts > 0){
            System.out.println("Введите адрес вашей электонной почты:" + "\n(осталось попыток = " + attempts + ")");
            email = scanner.nextLine();

            if (userEmail.validate(email)){
                buyer.setEmail(email);
                break;
            } else {
                System.out.println("Неправильный адрес"
                        + "\n------------------------------------------------------");
                attempts--;
            }
        }

        System.out.println("Ваше имя:");
        buyer.setName(scanner.nextLine());

        System.out.println("Ваш бюджет:");
        buyer.setMoney(scanner.nextDouble());

        Shop.getMenu(0);

        userAction = scanner.nextInt();

        if (userAction != 2) {
            menuAction = true;

            while (menuAction) {
                Shop.getMenu(1);
                userAction = scanner.nextInt();

                switch (userAction) {
                    case 0:
                        Shop.showProducts();
                        System.out.println("------------------------------------------------------");
                        break;
                    case 1:
                        System.out.println("Выберите номер продукта");
                        productID = scanner.nextInt();

                        System.out.println("Выберите количество");
                        productQuantity = scanner.nextInt();

                        if (productQuantity <= deal.getProducts().length) {

                            deal.addProduct(Shop.getProduct(productID), productQuantity);
                            Shop.reduceQuantity(productID, productQuantity);
                        }
                        break;
                    case 2:
                        if (deal.getShopBag() == 0){
                            System.out.println("Корзина пустая. Пожалуйста добавьте продукт"
                                    + "------------------------------------------------------");
                        } else {
                            System.out.println("Введите номер удаляемого продукта:");
                            productID = scanner.nextInt();

                            System.out.println("Выберите количество");
                            productQuantity = scanner.nextInt();

                            Shop.increaseQuantity(deal.getProduct(productID), productQuantity);
                            deal.removeProduct(productID, productQuantity);
                        }
                        break;
                    case 3:
                        if (deal.getShopBag() == 0){
                            System.out.println("Корзина пустая. Пожалуйста добавьте продукт"
                                    + "------------------------------------------------------");
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
                        if (deal.getShopBag() == 0) {
                            System.out.println("Корзина пустая. Пожалуйста добавьте продукт"
                                    + "------------------------------------------------------");
                        } else {
                            System.out.println("Итоговая сумма: ");
                            System.out.printf("%.2f", deal.fullPrice());
                            System.out.println("\n------------------------------------------------------");
                            System.out.println("Желаете оформить покупку? \n0 - Да, 1 - Нет");
                            userAction = scanner.nextInt();

                            if (userAction == 0){
                                if (deal.deal()){
                                    deal.bill();
                                    System.out.println("------------------------------------------------------");
                                    Shop.getMenu(2);
                                    menuAction = false;
                                    break;
                                    } else {
                                        System.out.println("У вас недостаточно средств");
                                    }
                                }
                            }
                        break;
                    case 5:
                        Shop.getMenu(2);
                        menuAction = false;
                        break;
                }
            }
        } else{
            Shop.getMenu(2);
        }
        scanner.close();
    }
}
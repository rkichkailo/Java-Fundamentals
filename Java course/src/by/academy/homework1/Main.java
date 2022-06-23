package by.academy.homework1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Task1 task1 = new Task1();

        task1.runTask();


        /*int userAge = 0;
        boolean ageCorrect = false;
        double sumBuy = 0;
        boolean userBuy = false;
        double discount = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите ваш возраст: ");
        if (scan.hasNextInt()) {
            ageCorrect = true;
            userAge = scan.nextInt();
            System.out.println("Введите сумму вашей покупки: ");
            if (ageCorrect) {
                if (scan.hasNextInt()) {
                    sumBuy = (double) scan.nextInt();
                    userBuy = true;

                    while (userBuy) {
                        if (sumBuy == 0) {
                            System.out.println("К сожалению невозможно расчитать скидку");
                        } else {
                            if (sumBuy > 0) {
                                if (sumBuy < 100) {
                                    discount = (sumBuy * 5) / 100;
                                } else if (sumBuy >= 100 && sumBuy < 200) {
                                    discount = (sumBuy * 7) / 100;
                                } else if (sumBuy >= 200 && sumBuy < 300) {
                                    if (userAge > 18) {
                                        discount = (sumBuy * (12 + 4)) / 100;
                                    } else {
                                        discount = (sumBuy * (12 - 3)) / 100;
                                    }
                                } else if (sumBuy >= 300 && sumBuy < 400) {
                                    discount = (sumBuy * 15) / 100;
                                } else if (sumBuy >= 400) {
                                    discount = (sumBuy * 20) / 100;
                                }
                            }
                            System.out.println("Ваша скидка = " + discount);
                        }
                        userBuy = false;
                    }
                } else {
                    System.out.println("Вы ввели некорректное значение! Перезапустите программу и попробуйте еще раз");
                    scan.close();
                }
            }
        }else {
                System.out.println("Вы ввели некорректное значение! Перезапустите программу и попробуйте еще раз");
                scan.close();
        }*/
    }
}



package by.academy.Deal;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Какие продукты добавляем в корзину?");

        String [] userProducts = scanner.nextLine().split(" ");


        Deal firstTry = new Deal();



    }
}

package by.academy.homework1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число од 1 до 10:");
        int userNum;
        int n = 1;
        int multiply = 0;

        if(sc.hasNextInt()){
            userNum = sc.nextInt();
            if(userNum <= 0 || userNum > 10){
                System.out.println("Вы ввели недопустимое значение");
            } else {
                do{
                    multiply = userNum * n;
                    System.out.println(userNum + " * " + n + " = " + multiply);
                    n++;
                } while (n <= 10);
            }
            sc.close();
        } else {
            System.out.println("Вы ввели некорректное значение");
        }
    }
}

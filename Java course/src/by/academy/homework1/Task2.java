package by.academy.homework1;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

//  я не знаю как реализовать это залдание при помощи switch

        float f;
        double d;
        int i;
        int ch;
        String s ="5";
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите значение: ");

        if(sc.hasNextInt()){
            i = sc.nextInt();
            System.out.println(i%2);
        } else if (sc.hasNextDouble()) {
            d = sc.nextDouble();
            System.out.println((d*70)/100);
        } else if (sc.hasNextFloat()) {
            f = sc.nextFloat();
            System.out.println(f*f);
        } else {
            s = sc.nextLine();
            if(s.length()==1){
                ch = (int)s.charAt(0);
                System.out.println(ch);
            } else {
                System.out.println("Hello "+ s);
            }
        }
    }
}

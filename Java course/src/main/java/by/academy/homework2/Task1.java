package by.academy.homework2;

import java.util.Scanner;

public class Task1 {

    //Ввести две строки с консоли. Определить, является ли одна строка перестановкой символов другой строки. Учитываем регистр. Не использовать сортировку :)
    //Например:
    //1.	“hello” и “hlleo” -> true
    //2.	“hello” и “art” -> false

    static boolean checkStrings(String [] arr){

        String firstString = arr[0];
        String secondString = arr[1];
        int matches = 0;
        boolean result = false;

        if (firstString.length() == secondString.length()){
            for (int i = 0; i < firstString.length(); i++) {
                for (int j = 0; j < secondString.length(); j++) {
                    if (firstString.charAt(i) == secondString.charAt(j)){
                        matches++;
                    }
                }
            }
            if (matches >=firstString.length()){
                result = true;
            }
        }

        return result;
    }

//    boolean result = true;
//    if (firstString.length() != secondString.length()){

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите два слова разделенных пробелом:");

        String[] arr = scanner.nextLine().split(" ");

        boolean result = checkStrings(arr);

        System.out.println(result);

    }
}

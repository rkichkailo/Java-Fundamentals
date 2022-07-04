package by.academy.homework2;

import java.util.Arrays;
import java.util.Scanner;

    public class Task2 {

        public static void main(String[] args) {

//      Ввести n слов с консоли. Найти слово, в котором число различных символов минимально. Если таких слов несколько, найти первое из них.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слова через пробел");

        String [] words = scanner.nextLine().split(" ");
        String temp;
        String [] result = new String[words.length];
        int arrayIndex = 0;

        for (String s : words) {
            temp = "";
            for (int i = 0; i < s.length(); i++){
                if (temp.indexOf(s.charAt(i)) == -1){
                    temp += s.charAt(i);
                }
            }
            result[arrayIndex] = temp;
            arrayIndex++;
        }
        //System.out.println(Arrays.toString(result)); // массив слов из уникальных символов

        int minLength = 0;
        boolean findResult = true;

        while (findResult){
            for (int j = 0; j < result.length; j++) {
                if (result[j].length() == minLength){
                    System.out.println("Слово: " + words[j] + ", уникальные символы: " + result[j]);
                    findResult = false;
                    break;
                }
            }
            minLength++;
        }
        scanner.close();
    }
}